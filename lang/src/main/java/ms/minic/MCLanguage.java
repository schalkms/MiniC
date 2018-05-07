package ms.minic;

import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import ms.minic.nodes.MCRootNode;
import ms.minic.parser.MCReader;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;

@TruffleLanguage.Registration(id = "minic", name = "MiniC", version = "1.0", mimeType = "application/x-minic")
@ProvidedTags({StandardTags.StatementTag.class, StandardTags.RootTag.class})
public class MCLanguage extends TruffleLanguage<MCContext> {

    @Override
    protected MCContext createContext(Env env) {
        return new MCContext(this, env);
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        MCReader reader = new MCReader(request.getSource());
        MCRootNode root = reader.Read(this);
        return Truffle.getRuntime().createCallTarget(root);
    }
}
