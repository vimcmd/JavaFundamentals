package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements chapter 9 tasks.
 */
public class CustomReader extends BufferedReader {

    public CustomReader(Reader in) {
        super(in);
    }

    /**
     * Read a line of text and returns result. Adds line break in the end of line.
     *
     * @return a capitalized String
     * @throws IOException If an I/O error occurs
     * @see BufferedReader#readLine()
     */
    public String readLineCapitalize() throws IOException {
        String line = super.readLine();
        if (line != null) {
            return line.toUpperCase() + System.getProperty("line.separator");
        } else {
            return null;
        }
    }

    /**
     * Read a line of text and returns result. Adds line break in the end of line.
     *
     * @param findSubstring string is to be matched
     * @param replacement   the string to be substituted for each match
     * @return The resulting String
     * @throws IOException If an I/O error occurs
     * @see BufferedReader#readLine()
     */
    public String readLineAndReplaceSubstring(String findSubstring, String replacement) throws IOException {
        String line = super.readLine();
        if (line != null) {
            return line.replaceAll(findSubstring, replacement) + System.getProperty("line.separator");
        } else {
            return null;
        }
    }

    /**
     * Read a line of text and returns result. Adds line break in the end of line.
     *
     * @return String containing only words starting with vowel (russian and english)
     * @throws IOException If an I/O error occurs
     * @see BufferedReader#readLine()
     */
    public String readLineAllWordsStartsWithVowel() throws IOException {
        String line = super.readLine();

        if (line != null) {
            StringBuilder resultLine = new StringBuilder();
            String vowelsRussian = "аоэиуыеёюяАОЭИУЫЕЁЮЯ";
            String vowelsEnglish = "aeiouyAEIOUY";
            Pattern wordStartedWithVowel = Pattern.compile("\\b[" + vowelsEnglish + vowelsRussian + "]\\w*\\b");
            Matcher matcher = wordStartedWithVowel.matcher(line);

            while (matcher.find()) {
                resultLine.append(matcher.group()).append(" ");
            }
            return resultLine.toString().trim() + System.getProperty("line.separator");
        } else {
            return null;
        }
    }

    /**
     * Read a line of text and returns result. Adds line break in the end of line.
     *
     * @return Only words in special form where last character equal to first character of next word.
     *         For ex.: for words "word door" result will be "wor(D)oor;"
     * @throws IOException If an I/O error occurs
     * @see BufferedReader#readLine()
     */
    public String readLineAllWordsWhereLastCharEqualsNextWordFirstChar() throws IOException {
        String line = super.readLine();

        if (line != null) {
            Pattern word = Pattern.compile("\\b\\w+\\b");
            Matcher wordMatcher = word.matcher(line);
            StringBuilder result = new StringBuilder();
            String previousWord = "";
            String currentWord = "";


            while (wordMatcher.find()) {

                if (previousWord.equals("")) {
                    // setting previous word and skip first iteration
                    previousWord = wordMatcher.group();
                    continue;
                }

                currentWord = wordMatcher.group();

                if (currentWord.charAt(0) == previousWord.charAt(previousWord.length() - 1)) {
                    result.append(previousWord.substring(0, previousWord.length() - 1))
                          .append("(")
                          .append(Character.toUpperCase(currentWord.charAt(0)))
                          .append(")")
                          .append(currentWord.substring(1))
                          .append("; ");
                }

                previousWord = currentWord;
            }

            return result.toString().trim() + System.getProperty("line.separator");

        } else {
            return null;
        }
    }
}
