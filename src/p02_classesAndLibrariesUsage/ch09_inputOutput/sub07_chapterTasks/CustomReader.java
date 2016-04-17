package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomReader extends BufferedReader {

    public CustomReader(Reader in) {
        super(in);
    }

    /**
     * Reads line and capitalizes all characters.
     *
     * @return uppercase String
     * @throws IOException
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
     * @param findSubstring string is to be matched
     * @param replacement   the string to be substituted for each match
     * @return The resulting String
     * @throws IOException
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
     * Reads line and searches only words starting with vowels (russian and english)
     *
     * @return resulting string
     * @throws IOException
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
     * @return
     * @throws IOException
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
