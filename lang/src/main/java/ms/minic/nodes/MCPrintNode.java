package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MCPrintNode extends MCNode {

    private MCExpressionNode expression;

    public MCPrintNode(MCExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public void execute(VirtualFrame frame) {
        expression.execute(frame);
        System.out.println(expression.getResult());
    }
}
