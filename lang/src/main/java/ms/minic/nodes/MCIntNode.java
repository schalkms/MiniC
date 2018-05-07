package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MCIntNode extends MCExpressionNode {

    private int value;

    public MCIntNode(int value) {
        this.value = value;
    }

    @Override
    public void execute(VirtualFrame frame) {
        result = value;
    }
}
