package p02_classesAndLibrariesUsing.ch07_strings.sub03_regularExpressions;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* # 8 # Strings processing using regular expressions */

/**
 * <p>Processing string using patterns</p>
 * <p>{@link Pattern} class used for defining regular expressions (patterns), which is searched in string, file
 * or other object of a sequence of characters.</p>
 * <p>On each matching can be obtained information using class {@link Matcher}</p>
 */
public class RegularExample {
    public static void main(String[] args) {
        System.out.println(isStringMatchesPattern("a+y", "aaay"));
        searchStringMatchingRegex("(\\w{6,})@(\\w+\\.)([a-z]{2,4})", "email addresses: pupkin@gmail.com, ivanov@bsy.by!");
        splitStringUsingRegex("\\s?\\d+\\s?", "java5tiger 77 java6mustang");
    }

    /**
     * Check if string matches pattern
     *
     * @param regex
     * @param input
     */
    private static boolean isStringMatchesPattern(String regex, String input) {
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(input);
        return m1.matches();
    }

    /**
     * Search and select substring matches specified pattern
     *
     * @param regex
     * @param input
     */
    private static void searchStringMatchingRegex(String regex, String input) {
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(input);

        while (m2.find()) {
            System.out.println(m2.group());
        }
    }

    /**
     * split string to substrings using pattern as delimiter
     */
    private static void splitStringUsingRegex(String regex, String input) {
        Pattern p3 = Pattern.compile(regex);
        String[] words = p3.split(input);
        System.out.println(Arrays.toString(words));
    }
}
