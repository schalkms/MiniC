package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MCAssignNode extends MCNode {

    private final MCExpressionNode expression;
    private final MCSymbolNode symbol;

    public MCAssignNode(MCSymbolNode symbol, MCExpressionNode expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    @Override
    public void execute(VirtualFrame frame) {
        expression.execute(frame);
        symbol.setResult(expression.getResult());
    }
}
