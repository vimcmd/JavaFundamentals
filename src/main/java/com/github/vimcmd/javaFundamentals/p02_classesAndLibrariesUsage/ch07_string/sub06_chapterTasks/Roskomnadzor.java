package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub06_chapterTasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Roskomnadzor {
    private Roskomnadzor() {
    }

    public static void main(String[] args) {
        String sentence = "Роскомнадзор запретил букву";
        String resultString = sentence;

        for(Character ch : getSortedCharSetOfString(sentence)) {
            System.out.println(resultString + " " + Character.toUpperCase(ch));
            resultString = forbidCharacterInString(resultString, ch);
        }

    }

    public static HashSet<Character> getSortedCharSetOfString(String string) {
        HashSet<Character> charSet = new LinkedHashSet<>();
        char[] sortedCharArray = string.toLowerCase().toCharArray();
        Arrays.sort(sortedCharArray);
        for(char ch : sortedCharArray) {
            if (Character.isAlphabetic(ch)) {
                charSet.add(ch);
            }
        }
        return charSet;
    }

    public static String forbidCharacterInString(String initialString, Character character) {
        // delete both lower and upper case
        return initialString.replaceAll(character.toString(), "")
                            .replaceAll(String.valueOf(Character.toUpperCase(character)), "")
                            .trim();
    }

}