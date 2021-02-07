package micro.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

import micro.MicroTypeSystem;
import micro.MicroTypeSystemGen;

@TypeSystemReference(MicroTypeSystem.class)
public abstract class MicroExprNode extends Node {
    public abstract Object executeGeneric(VirtualFrame frame);

    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        return MicroTypeSystemGen.expectLong(executeGeneric(frame));
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return MicroTypeSystemGen.expectDouble(executeGeneric(frame));
    }

    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }
}
