package ms.minic;

import org.junit.Assert;
import org.junit.Test;

public class MCLanguageTest extends TestSuite {

    @Test
    public void testHelloWorld() {
        String code =
                "void main() {\n" +
                "  printf(\"Hello World!\");\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("Hello World!\n", out.toString());
    }

    @Test
    public void testAdd() {
        String code =
                "void main() {\n" +
                "  printf(1 + 1);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("2\n", out.toString());
    }

    @Test
    public void testMinus() {
        String code =
                "void main() {\n" +
                "  printf(2 - 2);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("0\n", out.toString());
    }

    @Test
    public void testMult() {
        String code =
                "void main() {\n" +
                "  printf(2 * 2);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("4\n", out.toString());
    }

    @Test
    public void testDiv() {
        String code =
                "void main() {\n" +
                "  printf(2 / 2);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("1\n", out.toString());
    }

    @Test
    public void testArithmetics() {
        String code =
                "void main() {\n" +
                "  printf(1 + 2 * 3);\n" +
                "  printf((1 + 2) * 3);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("7\n9\n", out.toString());
    }

    @Test
    public void testSVP() {
        String code =
                "void main() {\n" +
                "  int a, b, cs;\n" +
                "  a = 3;\n" +
                "  b = 4;\n" +
                "  cs = (a * a) + (b * b);\n" +
                "  printf(cs);\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("25\n", out.toString());
    }



    @Test
    public void testEmptyInstruction() {
        String code =
                "void main() {\n" +
                "  ;\n" +
                "}";
        executeCode(code);
        Assert.assertEquals("", out.toString());
    }
}
