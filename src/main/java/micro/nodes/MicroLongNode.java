package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MicroLongNode extends MicroExprNode {
    private final long value;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    public MicroLongNode(long value) {
        this.value = value;
    }
    
}
