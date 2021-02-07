package micro.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MicroMultNode extends MicroBinaryNode {

    @Specialization
    long mult(long lhs, long rhs) {
        return lhs * rhs;
    }

    @Specialization
    double mult(double lhs, double rhs) {
        return lhs * rhs;
    } 
    
}
