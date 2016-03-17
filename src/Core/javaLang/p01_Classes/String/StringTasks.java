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

    public static final String lineSeparator = System.lineSeparator();
    private static final String splitSeparator = " ";
    private String initialString;
    private String resultString;

    public StringTasks(String initialString) {
        this.initialString = initialString;
    }

    public StringTasks() {
        this("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                     "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
                     "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                     "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                     "culpa qui officia deserunt mollit anim id est laborum.");
    }

    public static void main(String[] args) {
        StringTasks stringTask = new StringTasks();
        stringTask.sortWordsInStringStreamDefault(splitSeparator);
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
        return "Initial string: " + this.getInitialString() +
                lineSeparator +
                "Result string : " + this.getResultString();
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
    public void sortWordsInString(String splitSeparator) {
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
        // appending to result
        StringBuilder result = new StringBuilder();
        for(String elem : a) {
            if (!elem.isEmpty()) {
                result.append(elem)
                      .append(splitSeparator);
            }
        }

        this.resultString = result.toString()
                                  .trim();

    }

    /**
     * equivalent to {@link #sortWordsInString(String)}, using space as delimiter
     */
    public void sortWordsInString() {
        sortWordsInString(splitSeparator);
    }

    /**
     * Sort words in string using JavaSE classes
     *
     * @param splitSeparator the delimiting String
     * @since 1.8
     */
    public void sortWordsInStringDefault(String splitSeparator) {
        List<String> arr;
        arr = Arrays.asList(this.initialString.trim()
                                              .split(splitSeparator));
        arr.sort(String::compareToIgnoreCase);
        // or, here can be used this method:
        // Collections.sort(arr, String::compareToIgnoreCase);
        StringBuilder result = new StringBuilder();
        for(String elem : arr) {
            result.append(elem)
                  .append(splitSeparator);
        }
        this.resultString = result.toString()
                                  .trim();
    }

    /**
     *
     * @param splitSeparator the word delimiting String
     * @since 1.8
     */
    public void sortWordsInStringStreamDefault(String splitSeparator) {
        List<String> list = Arrays.asList(this.initialString.trim()
                                                            .split(splitSeparator));
        list = list.stream()
                   .sorted()
                   .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        for ( String elem : list )
        {
            result.append(elem)
                  .append(splitSeparator);
        }
        this.resultString = result.toString()
                                  .trim();
    }

}