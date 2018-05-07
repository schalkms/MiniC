package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MCDivNode extends MCArithmeticNode {

    public MCDivNode(MCExpressionNode left, MCExpressionNode right) {
        super(left, right);
    }

    @Override
    public void execute(VirtualFrame frame) {
        left.execute(frame);
        right.execute(frame);
        result = left.getResult() / right.getResult();
    }
}
