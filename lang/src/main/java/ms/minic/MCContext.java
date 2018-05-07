package ms.minic;

import com.oracle.truffle.api.TruffleLanguage;

public class MCContext {

    private static final int MEMORY_SIZE = 10000;

    private final MCLanguage language;
    private final TruffleLanguage.Env env;
    private final byte[] memory;

    public MCContext(MCLanguage language, TruffleLanguage.Env env) {
        this.language = language;
        this.env = env;
        this.memory = new byte[MEMORY_SIZE];
    }
}
