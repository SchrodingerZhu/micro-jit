package micro.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

public class MicroRoot extends RootNode {
    @Children MicroStmtNode[] statements;
    public MicroRoot(TruffleLanguage<?> language, MicroStmtNode[] stmts) {
        super(language);
        this.statements = stmts;
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frame) {
        for (var stm : statements) {
            stm.executeVoid(frame);
        }
        return 0;
    }
    
}
