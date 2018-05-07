package ms.minic.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

import java.util.List;

public class MCRootNode extends RootNode {

    @Children
    private final MCNode[] nodes;

    public MCRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, List<MCNode> nodes) {
        super(language, frameDescriptor);
        this.nodes = nodes.toArray(new MCNode[] {});
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        CompilerAsserts.compilationConstant(nodes.length);
        for (MCNode node : nodes) {
            node.execute(frame);
        }
        return 0;
    }
}
