package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;


public class MicroAssignNode extends MicroStmtNode {
    private @Child MicroExprNode exprChild;
    private String name;

    @Override
    public void executeVoid(VirtualFrame frame) {
        var result = exprChild.executeGeneric(frame);
        var slot = frame.getFrameDescriptor().findOrAddFrameSlot(name);
        frame.setObject(slot, result);
    }

    public MicroAssignNode(MicroExprNode exprChild, String name) {
        this.exprChild = exprChild;
        this.name = name;
    }
    

}
