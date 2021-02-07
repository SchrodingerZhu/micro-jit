package micro.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

import micro.MicroLanguage;
public class MicroReadNode extends MicroStmtNode {
    String[] names;
    
    @ExplodeLoop
    @Override
    public void executeVoid(VirtualFrame frame) {
        var symTable = frame.getFrameDescriptor();
        for (var name : names) {
            Object result = this.lookupLanguageReference(MicroLanguage.class).get().getContext().read();
            var slot = symTable.findOrAddFrameSlot(name);
            frame.setObject(slot, result);
        }
    }

    public MicroReadNode(String[] names) {
        this.names = names; 
    }
    
}
