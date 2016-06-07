package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* # 9 # Groups and quantifiers */

public class RegularGroups {
    public static void main(String[] args) {
        String input = "abdcxyz";

        // in this case to first group relates all possible chars,
        // but in second group remains minimal amount of chars
        simpleMatching("([a-z]*)([a-z]+)", input);

        // in this case to first group relates minimal amount chars, because used reluctant quantifier.
        simpleMatching("([a-z]?)([a-z]+)", input);

        // in this case to first group assigned all string, because second group using reluctant quantifier and
        // first - possessive.
        simpleMatching("([a-z]+)([a-z]*)", input);

        // in this case string does not matches pattern, because both groups selects minimal chars amount.
        simpleMatching("([a-z]?)([a-z]?)", input);
    }

    public static void simpleMatching(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("First group: " + matcher.group(1));
            System.out.println("Second group: " + matcher.group(2) + "\n");
        } else {
            System.out.println("nothing\n");
        }
    }
}
