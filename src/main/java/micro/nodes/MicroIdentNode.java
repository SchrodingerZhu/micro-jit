package micro.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;


public class MicroIdentNode extends MicroExprNode {
    private String name;
    @CompilerDirectives.CompilationFinal boolean noSuchVar = false;
    @Override
    public Object executeGeneric(VirtualFrame frame) {
       var slot = frame.getFrameDescriptor().findFrameSlot(name);
       if (slot == null && !noSuchVar) {
           CompilerDirectives.transferToInterpreter();
           noSuchVar = true;
           throw new RuntimeException("no such variable: " + name);
       }
       return frame.getValue(slot);
    }    

    public MicroIdentNode(String name) {
        this.name = name;
    }
}
