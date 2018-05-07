package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MCAddNode extends MCArithmeticNode {

    public MCAddNode(MCExpressionNode left, MCExpressionNode right) {
        super(left, right);
    }

    @Override
    public void execute(VirtualFrame frame) {
        left.execute(frame);
        right.execute(frame);
        result = Math.addExact(left.getResult(), right.getResult());
    }
}
