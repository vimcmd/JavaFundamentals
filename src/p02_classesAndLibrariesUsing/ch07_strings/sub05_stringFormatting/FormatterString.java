package p02_classesAndLibrariesUsing.ch07_strings.sub05_stringFormatting;

import java.util.Formatter;

/* # 15 # Formatting strings using method format() */

public class FormatterString {
    public static void main(String[] args) {
        Formatter f = new Formatter(); // object declaration

        // format text using %S, %c
        // %s - string representation of argument; %S - same but in upper case
        // %c - character representation of argument;
        f.format("This %s is about %n%S %c", "book", "java", '8');
        System.out.println(f);
    }
}
