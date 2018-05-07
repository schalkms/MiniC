package ms.minic;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Source;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TestSuite {

    protected final ByteArrayOutputStream out = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    protected void executeCode(String code) {
        Source source = Source.create("minic", code);
        try (Engine engine = Engine.newBuilder().out(this.out).err(err).build()) {
            try (Context context = Context.newBuilder().engine(engine).build()) {
                context.eval(source);
            }
        }
    }
}
