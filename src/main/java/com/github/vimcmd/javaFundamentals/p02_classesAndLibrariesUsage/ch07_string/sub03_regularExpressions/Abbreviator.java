package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Abbreviator {
    public String abbreviate(String string) {
        Pattern pattern = Pattern.compile("(\\w)(\\w{2,})(\\w)"); // or use "(\b[A-Za-z])([A-Za-z]{2,})([A-Za-z]\b)"
        Matcher matcher = pattern.matcher(string);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "$1" + matcher.group(2).length() + "$3");
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
