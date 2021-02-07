package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;


public class MicroWriteNode extends MicroStmtNode {
    @Children MicroExprNode[] exprChildren;

    @ExplodeLoop
    @Override
    public void executeVoid(VirtualFrame frame) {
        for (var child : exprChildren) {
            System.out.println(child.executeGeneric(frame));
        }
    }

    public MicroWriteNode(MicroExprNode[] exprChildren) {
        this.exprChildren = exprChildren;
    }
    
}
