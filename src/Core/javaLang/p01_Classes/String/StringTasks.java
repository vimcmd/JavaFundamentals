package Core.javaLang.p01_Classes.String;

import java.util.Arrays;
import java.util.List;
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
    private final long nanoTimeStart = System.nanoTime();
    private String initialString;
    private String resultString;

    public StringTasks(String initialString) {
        this.initialString = initialString;
    }

    public StringTasks() {
        this("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    public static void main(String[] args) {
        StringTasks stringTask = new StringTasks();
        stringTask.replaceCharInEachWord(1, 'X');
        System.out.println(stringTask);
    }

    public String getInitialString() {
        return initialString;
    }

    public String getResultString() {
        return resultString;
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
        this.resultString = new StringBuilder(this.getInitialString()).reverse()
                                                                      .toString();
    }

    /**
     * Sort words in string using loop
     *
     * @param splitSeparator the delimiting String
     */
    public void sortWordsInStringIgnoreCase(String splitSeparator) {
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

        this.resultString = String.join(" ", a)
                                  .trim();

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
        List<String> arr;
        arr = Arrays.asList(this.initialString.trim()
                                              .split(splitSeparator));
        arr.sort(String::compareToIgnoreCase);
        // or, here can be used this method:
        // Collections.sort(arr, String::compareToIgnoreCase);
        this.resultString = String.join(" ", arr)
                                  .trim();
    }

    public void sortWordsInStringIgnoreCaseUsingArrays() {
        sortWordsInStringIgnoreCaseUsingArrays(splitSeparator);
    }

    /**
     * @param splitSeparator the word delimiting String
     * @since 1.8
     */
    public void sortWordsInStringIgnoreCaseUsingStream(String splitSeparator) {
        List<String> list = Arrays.asList(this.initialString.trim()
                                                            .split(splitSeparator));
        list = list.stream()
                   .sorted(String::compareToIgnoreCase)
                   .collect(Collectors.toList());

        this.resultString = String.join(" ", list)
                                  .trim();
    }

    public void sortWordsInStringIgnoreCaseUsingStream() {
        sortWordsInStringIgnoreCaseUsingStream(splitSeparator);
    }

    /**
     * Replaces character at {@code charToReplaceIndex} position in each word in initial string. If specified index
     * larger than word length, replacing not performed.
     *
     * @param charToReplaceIndex index of character in word to be replaced (starts from 0)
     * @param replacingChar      character, which should be replaced
     */
    public void replaceCharInEachWord(int charToReplaceIndex, char replacingChar) {
        StringBuilder result = new StringBuilder(initialString);

        //prevent OutOfBoundException
        if (charToReplaceIndex > 0) {
            for(int i = 0; i < result.length() - charToReplaceIndex; i++) {
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

        this.resultString = result.toString();
    }
}