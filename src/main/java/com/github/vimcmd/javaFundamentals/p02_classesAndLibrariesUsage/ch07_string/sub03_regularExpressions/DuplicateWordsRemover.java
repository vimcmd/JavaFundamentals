package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsRemover {

    public String removeDuplicates(String in) {
        /*
        Java tutorial to understand the grouping concept: https://docs.oracle.com/javase/tutorial/essential/regex/groups.html

        The pattern above basically means to capture any pattern where a word ((\w+))
        is followed by non-word character (e.g., space) then by itself
        again (\1 is the backreference to (\w+) earlier).

        So for the example input "Goodbye bye bye world world world",
        the matcher will find 3 patterns:
        1) Goodbye
        2) bye bye
        3) world world world
        Then for each of them, we can call replaceAll to replace the whole
        group with the first group (i.e., the first word - m.group(1)).
         */
        Pattern pattern = Pattern.compile("\\b(\\w+)(\\s+\\1\\b)*", Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(in);

        while(m.find()){
            in = in.replaceAll("\\b" + m.group() + "\\b", m.group(1));
        }

        return in;
    }

}
