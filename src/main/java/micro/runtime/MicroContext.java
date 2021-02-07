package micro.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MicroContext {
    Scanner input;
    public MicroContext() {
        this.input = new Scanner(System.in);
    }
    public Object read() {
        try {
            return input.nextLong();
        } catch (InputMismatchException ex) {
            return input.nextDouble();
        }
    }
}
