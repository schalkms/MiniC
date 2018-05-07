package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class MCNode extends Node {

    public abstract void execute(VirtualFrame frame);
}
