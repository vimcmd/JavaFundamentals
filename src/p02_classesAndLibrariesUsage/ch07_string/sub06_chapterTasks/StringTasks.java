package p02_classesAndLibrariesUsage.ch07_string.sub06_chapterTasks;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Sources:
 * <ul>
 * <li>
 * Java. Programming Methods (Epam free book, 2013) / chapter 7
 * </li>
 * </ul>
 */
public class StringTasks {

    private static final String lineSeparator = System.lineSeparator();
    private static final String splitSeparator = " ";
    private final String initialString;
    private long nanoTimeStart = System.nanoTime();
    private String resultString;

    public StringTasks(String initialString) {
        this.initialString = initialString;
    }

    public StringTasks() {
        this("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    public static void main(String[] args) {
        StringTasks stringTask = new StringTasks();
        stringTask.appendWordIfEndsWithSubstring("t", "WOW");
        System.out.println(stringTask);
    }

    private void setNanoTimeStart() {
        this.nanoTimeStart = System.nanoTime();
    }

    public String getInitialString() {
        return initialString;
    }

    public String getResultString() {
        return resultString;
    }

    private void setResultString(String resultString) {
        this.resultString = resultString;
    }

    @Override
    public String toString() {
        long nanoTimeTaken = System.nanoTime() - this.nanoTimeStart;
        return "Initial string : " + this.getInitialString() +
                lineSeparator +
                "Result string  : " + this.getResultString() +
                lineSeparator +
                "Time taken (ms): " + ( nanoTimeTaken / 1_000_000D );
    }

    public void stringReverse() {
        setNanoTimeStart();
        setResultString(new StringBuilder(this.getInitialString()).reverse()
                                                                  .toString());
    }

    /**
     * Sort words in string using loop
     *
     * @param splitSeparator the delimiting String
     */
    public void sortWordsInStringIgnoreCase(String splitSeparator) {
        setNanoTimeStart();
        String initialString = this.initialString.trim();
        String a[] = initialString.split(splitSeparator);

        // sorting
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if (a[i].compareToIgnoreCase(a[j]) > 0) {
                    String temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        setResultString(String.join(" ", a)
                              .trim());

    }

    /**
     * equivalent to {@link #sortWordsInStringIgnoreCase(String)}, using space as delimiter
     */
    public void sortWordsInStringIgnoreCase() {
        sortWordsInStringIgnoreCase(splitSeparator);
    }

    /**
     * Sort words in string using JavaSE API
     *
     * @param splitSeparator the delimiting String
     * @since 1.8
     */
    public void sortWordsInStringIgnoreCaseUsingArrays(String splitSeparator) {
        setNanoTimeStart();
        List<String> arr;
        arr = Arrays.asList(this.initialString.trim()
                                              .split(splitSeparator));
        arr.sort(String::compareToIgnoreCase);
        // or, here can be used this method:
        // Collections.sort(arr, String::compareToIgnoreCase);
        setResultString(String.join(" ", arr)
                              .trim());
    }

    public void sortWordsInStringIgnoreCaseUsingArrays() {
        sortWordsInStringIgnoreCaseUsingArrays(splitSeparator);
    }

    /**
     * @param splitSeparator the word delimiting String
     * @since 1.8
     */
    public void sortWordsInStringIgnoreCaseUsingStream(String splitSeparator) {
        setNanoTimeStart();
        List<String> list = Arrays.asList(this.initialString.trim()
                                                            .split(splitSeparator));
        list = list.stream()
                   .sorted(String::compareToIgnoreCase)
                   .collect(Collectors.toList());

        setResultString(String.join(" ", list)
                              .trim());
    }

    public void sortWordsInStringIgnoreCaseUsingStream() {
        sortWordsInStringIgnoreCaseUsingStream(splitSeparator);
    }

    /**
     * Replaces character at {@code charToReplaceIndex} position in each word in initial string. If specified index
     * larger than word length, replacing not performed.
     *
     * @param charToReplaceIndex index of character in word to be replaced (starts from 0). If any negative value passed,
     *                           replaces all non-space characters.
     * @param replacingChar      character, which should be replaced
     */
    public void replaceCharInEachWord(int charToReplaceIndex, char replacingChar) {
        setNanoTimeStart();
        StringBuilder result = new StringBuilder(initialString);

        if (charToReplaceIndex >= 0) {
            for(int i = 0; i < result.length() - charToReplaceIndex - 1; i++) {
                if (Character.isWhitespace(result.charAt(i))) {
                    //skip leading whitespaces
                    continue;
                } else {
                    //find char to replace
                    int index = 0;
                    while (index < charToReplaceIndex) {
                        // check to occasionally not jump to other word
                        if (Character.isWhitespace(result.charAt(i))) {
                            break;
                        }
                        i++;
                        index++;
                    }
                }

                //replace character
                if (!Character.isWhitespace(result.charAt(i))) {
                    result.setCharAt(i, replacingChar);
                }

                //skip following characters in word till next whitespace
                while (( Character.isAlphabetic(result.charAt(i)) ) && ( i <= result.length() - charToReplaceIndex - 1 )) {
                    i++;
                }
            }
        } else {
            // otherwise replace all characters in string
            for(int i = 0; i < result.length(); i++) {
                if (!Character.isWhitespace(result.charAt(i))) {
                    result.setCharAt(i, replacingChar);
                }
            }
        }

        setResultString(result.toString());
    }

    /**
     * Replaces character at {@code charToReplaceIndex} position in each word in initial string, excluding punctuation
     * symbols.
     *
     * @param charToReplaceIndex index of character in word to be replaced (starts from 0). If specified index larger
     *                           than word length, replacing not performed.
     * @param replacingChar      character, which should be replaced
     */
    public void replaceCharInEachWordUsingRegex(int charToReplaceIndex, char replacingChar) {
        Pattern pattern = Pattern.compile("\\w+\\s*");
        Matcher matcher = pattern.matcher(getInitialString());
        StringBuilder result = new StringBuilder(getInitialString());

        while (matcher.find()) {
            // check bounds
            if (( matcher.group().length() > charToReplaceIndex ) && ( matcher.end() >= ( matcher.start() + charToReplaceIndex ) )) {
                int charIndexInResult = matcher.start() + charToReplaceIndex;
                if (!Character.isWhitespace(result.charAt(charIndexInResult))) {
                    result.setCharAt(charIndexInResult, replacingChar);
                }
            }
        }

        setResultString(result.toString());
    }

    /**
     * After <b>each</b> word in text if it ends with given substring, appends given word.
     * @param wordEnding substring which words must end with
     * @param appendedWord word to append after matching word
     */
    public void appendWordIfEndsWithSubstring(String wordEnding, String appendedWord) {
        Pattern pattern = Pattern.compile("\\w+" + wordEnding + "\\b");
        Matcher matcher = pattern.matcher(getInitialString());
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group() + " " + appendedWord);
        }
        matcher.appendTail(result);

        setResultString(result.toString());
    }
}