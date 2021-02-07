package micro.nodes;

import com.oracle.truffle.api.dsl.NodeChild;

@NodeChild("leftChild")
@NodeChild("rightChild")
public abstract class MicroBinaryNode extends MicroExprNode {
    
}
