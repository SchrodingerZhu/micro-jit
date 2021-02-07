package micro.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MicroAddNode extends MicroBinaryNode {

    @Specialization
    long add(long lhs, long rhs) {
        return lhs + rhs;
    }

    @Specialization
    double add(double lhs, double rhs) {
        return lhs + rhs;
    } 
    
}
