package ms.minic;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String MINIC = "minic";

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Please specify a .minic source file");
            System.exit(1);
        }
        Source src = Source.newBuilder(MINIC, new File(args[0])).build();
        Context context = Context.newBuilder(MINIC).in(System.in).out(System.out).build();
        Value value = context.eval(src);
    }
}
