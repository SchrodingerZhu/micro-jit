package micro.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

import micro.MicroTypeSystem;

@TypeSystemReference(MicroTypeSystem.class)
public abstract class MicroStmtNode extends Node {
    public abstract void executeVoid(VirtualFrame frame);
}
