package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MCSubNode extends MCArithmeticNode {

    public MCSubNode(MCExpressionNode left, MCExpressionNode right) {
        super(left, right);
    }

    @Override
    public void execute(VirtualFrame frame) {
        left.execute(frame);
        right.execute(frame);
        result = Math.subtractExact(left.getResult(), right.getResult());
    }
}
