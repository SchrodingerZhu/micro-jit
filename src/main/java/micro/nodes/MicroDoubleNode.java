package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MicroDoubleNode extends MicroExprNode {
    private final double value;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    public MicroDoubleNode(double value) {
        this.value = value;
    }
    
}
