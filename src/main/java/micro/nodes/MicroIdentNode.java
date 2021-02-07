package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;


public class MicroIdentNode extends MicroExprNode {
    private String name;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
       var slot = frame.getFrameDescriptor().findFrameSlot(name);
       return frame.getValue(slot);
    }    

    public MicroIdentNode(String name) {
        this.name = name;
    }
}
