package ms.minic.nodes.arithmetic;

import ms.minic.nodes.MCExpressionNode;

public abstract class MCArithmeticNode extends MCExpressionNode {

    protected MCExpressionNode left;
    protected MCExpressionNode right;

    public MCArithmeticNode(MCExpressionNode left, MCExpressionNode right) {
        this.left = left;
        this.right = right;
    }
}
