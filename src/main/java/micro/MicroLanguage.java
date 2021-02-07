package micro;

import java.util.HashMap;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.FrameInstance.FrameAccess;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.dsl.processor.expression.DSLExpression.Call;

import org.antlr.runtime.CharStreamState;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import micro.Absyn.*;
import micro.nodes.*;
import micro.runtime.MicroContext;

@TruffleLanguage.Registration(id = MicroLanguage.ID, name = MicroLanguage.ID, defaultMimeType = MicroLanguage.MIME, characterMimeTypes = MicroLanguage.MIME)
public class MicroLanguage extends TruffleLanguage<MicroContext> {
    public static final String ID = "micro";
    public static final String MIME = "application/x-micro";

    @Override
    protected MicroContext createContext(Env env) {
        return new MicroContext();
    }

    public MicroContext getContext() {
        return getCurrentContext(MicroLanguage.class);
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Prog parseTree;
        Source source = request.getSource();
        microLexer lexer = new microLexer(CharStreams.fromString(source.getCharacters().toString()));
        microParser parser = new microParser(new CommonTokenStream(lexer));
        parseTree = parser.prog().result;
        if (parseTree == null) {
            System.exit(1);
        }
        MicroRoot root = transform(parseTree);
        return Truffle.getRuntime().createCallTarget(root);
    }

    private MicroRoot transform(Prog program) {
        Program p = (Program) program;
        MicroStmtNode[] nodes = new MicroStmtNode[p.liststm_.size()];
        int cur = 0;
        for (var stm : p.liststm_) {
            nodes[cur++] = transform(stm);
        }
        return new MicroRoot(this, nodes);
    }

    private MicroStmtNode transform(Stm stm) {
        if (stm instanceof SAssign) {
            var node = (SAssign) stm;
            var expr = transform(node.exp_);
            return new MicroAssignNode(expr, node.ident_);
        }
        if (stm instanceof SRead) {
            var node = (SRead) stm;
            String[] slots = new String[node.listident_.size()];
            int cur = 0;
            for (String id : node.listident_) {
                slots[cur++] = id;
            }
            return new MicroReadNode(slots);
        }
        if (stm instanceof SWrite) {
            var node = (SWrite) stm;
            MicroExprNode[] nodes = new MicroExprNode[node.listexp_.size()];
            int cur = 0;
            for (Exp exp : node.listexp_) {
                nodes[cur++] = transform(exp);
            }
            return new MicroWriteNode(nodes);
        }
        return null;
    }

    private MicroExprNode transform(Exp exp) {
        if (exp instanceof EInt) {
            var node = (EInt) exp;
            return new MicroLongNode(node.integer_.longValue());
        }
        if (exp instanceof EDbl) {
            var node = (EDbl) exp;
            return new MicroDoubleNode(node.double_);
        }
        if (exp instanceof EIdn) {
            var node = (EIdn) exp;
            return new MicroIdentNode(node.ident_);
        }
        if (exp instanceof EAdd) {
            var node = (EAdd) exp;
            return MicroAddNodeGen.create(transform(node.exp_1), transform(node.exp_2));
        }
        if (exp instanceof EMul) {
            var node = (EMul) exp;
            return MicroMultNodeGen.create(transform(node.exp_1), transform(node.exp_2));
        }
        if (exp instanceof ESub) {
            var node = (ESub) exp;
            return MicroSubNodeGen.create(transform(node.exp_1), transform(node.exp_2));
        }
        if (exp instanceof EDiv) {
            var node = (EDiv) exp;
            return MicroDivNodeGen.create(transform(node.exp_1), transform(node.exp_2));
        }
        return null;
    }

}
