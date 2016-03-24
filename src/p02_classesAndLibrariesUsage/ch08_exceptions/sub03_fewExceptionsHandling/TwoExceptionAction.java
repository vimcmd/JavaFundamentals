package p02_classesAndLibrariesUsage.ch08_exceptions.sub03_fewExceptionsHandling;



/* # 1 # Handling two exception types */

public class TwoExceptionAction {
    public static void main(String[] args) {
        try {
            int a = (int) ( Math.random() * 2 );
            System.out.println("a = " + a);

            int c[] = {1 / a}; // dangerous place #1
            c[a] = 71; // dangerous place #2
        } catch (ArithmeticException e) {
            System.err.println("Division by zero: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Out of bounds: " + e);
        }
        System.out.println("After try/catch block");
    }
}
