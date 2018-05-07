package ms.minic;

import org.graalvm.polyglot.PolyglotException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MCLanguageExceptionTest extends TestSuite {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testUnsuccessfulParse() {
        expect();
        String code = "void main()";
        executeCode(code);
    }

    @Test
    public void testDuplicateVariableDeclaration() {
        expect();
        String code =
                "void main() {\n" +
                "  int x, x;\n" +
                "}";
        executeCode(code);
    }

    @Test
    public void testVariableDoesNotExist() {
        expect();
        String code =
                "void main() {\n" +
                "  x = 3;\n" +
                "}";
        executeCode(code);
    }

    private void expect() {
        thrown.expect(PolyglotException.class);
        thrown.expectMessage("MCLanguageException");
    }
}
