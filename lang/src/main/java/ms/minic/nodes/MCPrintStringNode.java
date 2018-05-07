package ms.minic.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MCPrintStringNode extends MCNode {

    private String string;

    public MCPrintStringNode(String string) {
        this.string = string;
    }

    @Override
    public void execute(VirtualFrame frame) {
        System.out.println(string);
    }
}
