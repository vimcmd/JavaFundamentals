package p02_classesAndLibrariesUsage.ch09_inputOutput.sub05_scanner;

import java.util.Locale;
import java.util.Scanner;

/* # 11 # Using delimiters and locales in Scanner */

public class ScannerDelimiterDemo {
    public static void main(String[] args) {
        double sum = 0.0;
        Scanner scanner = new Scanner("1,3;1,2; 2; 3,1; 3; 1,255; 10;");
        scanner.useLocale(Locale.FRANCE);
        //scanner.useLocale(Locale.ENGLISH); // result will be different (another float representation)
        scanner.useDelimiter(";\\s*");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                System.out.println(scanner.next());
            }
        }
        scanner.close();
        System.out.println("result sum: " + sum);
    }
}