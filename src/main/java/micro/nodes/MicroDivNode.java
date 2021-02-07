package micro.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MicroDivNode extends MicroBinaryNode {

    @Specialization
    long div(long lhs, long rhs) {
        return lhs / rhs;
    }

    @Specialization
    double div(double lhs, double rhs) {
        return lhs / rhs;
    } 
    
}
