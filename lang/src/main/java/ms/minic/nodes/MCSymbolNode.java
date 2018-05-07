package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MCSymbolNode extends MCExpressionNode {

    private final String symbol;

    public MCSymbolNode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void execute(VirtualFrame frame) {
    }
}
