package p02_classesAndLibrariesUsing.ch07_strings.sub05_stringFormatting;

import java.util.Formatter;

/* # 16 # Format numbers using flags %x, %o, %a, %g */

/*
%a hexadecimal floating point value
%b Logical (Boolean) value of the argument
%c character representation of the argument
%d decimal integer argument
%h hash code argument
%e Exponential representation of the argument
%f Decimal floating point value
%g Selects a short presentation of the following:% e or% f
%o Octal integer argument
%n Insert a newline
%s string representation of the argument
%t Time and date
%x hexadecimal integer argument
%% Caret %
 */

public class FormatterNumber {
    public static void main(String[] args) {
        Formatter f = new Formatter();
        f.format("Hex: %x, Octal: %o", 100, 100);
        System.out.println(f);

        f = new Formatter();
        f.format("%a", 100.001);
        System.out.println(f);

        f = new Formatter();
        for(double i = 1000; i < 1.0e+10; i*=100) {
            f.format("%g ", i);
            System.out.println(f);
        }
    }
}
