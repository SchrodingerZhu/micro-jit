package micro;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
public class Launcher {
    public static void main(String [] args) {
        Source src;

        String MICRO = "micro";
        try {
            src = Source.newBuilder(MICRO, new File(args[0]))
                .build();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return;
        }

        try (Context context = Context.newBuilder(MICRO)
                .in(System.in)
                .out(System.out)
                .build()) {
            context.eval(src);
        } catch (PolyglotException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
