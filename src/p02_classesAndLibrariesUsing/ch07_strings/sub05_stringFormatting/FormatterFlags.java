package p02_classesAndLibrariesUsing.ch07_strings.sub05_stringFormatting;

import java.util.Formatter;

/* # 18 # Using format flags */

/**
 * <p>
 * Precision flags uses only in formatting %f, %e, %g for numbers with floating point; in %s for strings.
 * </p>
 * <p>
 * It specifies the number of displayed decimal digits or symbols. For example, {@code %10.4f} output number with
 * minimal field width 10 and 4 decimals. Default precision equals 6 decimals.
 * </p>
 * <p>
 * Applying to string, set field maximum width. For example, {@code %5.7s} output with length not greater than 7 and
 * not less than 5 characters. If string larger, trailing characters are discarded.
 * </p>
 */
public class FormatterFlags {
    public static void main(String[] args) {
        Formatter f = new Formatter();

        // align to right
        f.format("|%10.2f|", 123.123);
        System.out.println(f);

        // align to left
        // using flag '-'
        f = new Formatter();
        f.format("|%-10.2f|", 123.123);
        System.out.println(f);

        // using flag ' ' and '('
        f = new Formatter();
        f.format("% (d", -100);
        System.out.println(f);

        // using flag ','
        f = new Formatter();
        f.format("%,.2f", 123456789.34);
        System.out.println(f);

        // setting number precision
        f = new Formatter();
        f.format("%.4f", 111111.11111111111);
        System.out.println(f);

        // setting string precision
        f = new Formatter();
        f.format("%.18s", "Now I know clas java.util.Formatter");
        System.out.println(f);
    }
}
