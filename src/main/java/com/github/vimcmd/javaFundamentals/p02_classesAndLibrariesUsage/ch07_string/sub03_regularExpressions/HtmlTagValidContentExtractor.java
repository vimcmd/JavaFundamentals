package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagValidContentExtractor {

    public List<String> extractValidContent(String in) {
        List<String> validContent = new ArrayList<>();
        Pattern p = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
        Matcher m = p.matcher(in);
        boolean isFound = false;

        while (m.find()) {
            isFound = true;
            validContent.add(m.group(2));
        }

        if (!isFound) {
            validContent.add("None");
        }

        return validContent;
    }

}
