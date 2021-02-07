package micro.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MicroSubNode extends MicroBinaryNode {

    @Specialization
    long sub(long lhs, long rhs) {
        return lhs - rhs;
    }

    @Specialization
    double sub(double lhs, double rhs) {
        return lhs - rhs;
    } 
    
}
