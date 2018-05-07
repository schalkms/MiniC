package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MCParenExpressionNode extends MCExpressionNode {

    private final MCExpressionNode expression;

    public MCParenExpressionNode(MCExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public void execute(VirtualFrame frame) {
        expression.execute(frame);
        result = expression.getResult();
    }
}
