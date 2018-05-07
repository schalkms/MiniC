package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MCMulNode extends MCArithmeticNode {

    public MCMulNode(MCExpressionNode left, MCExpressionNode right) {
        super(left, right);
    }

    @Override
    public void execute(VirtualFrame frame) {
        left.execute(frame);
        right.execute(frame);
        result = Math.multiplyExact(left.getResult(), right.getResult());
    }
}
