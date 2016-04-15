package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomReader extends BufferedReader {
    private String vowelsRussian = "аоэиуыеёюяАОЭИУЫЕЁЮЯ";
    private String vowelsEnglish = "aeiouyAEIOUY";
    private Pattern wordStartedWithVowel = Pattern.compile("\\b[" + vowelsEnglish + vowelsRussian + "]\\w*\\b");

    public CustomReader(Reader in) {
        super(in);
    }

    /**
     * Reads line and capitalizes all characters.
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
     *
     * @param findSubstring string is to be matched
     * @param replacement the string to be substituted for each match
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
     * @return resulting string
     * @throws IOException
     */
    public String readLineAllWordsStartsWithVowel() throws IOException {
        String line = super.readLine();

        if (line != null) {
            StringBuilder resultLine = new StringBuilder();
            Matcher matcher = wordStartedWithVowel.matcher(line);

            while (matcher.find()) {
                resultLine.append(matcher.group()).append(" ");
            }
            return resultLine.toString().trim() + System.getProperty("line.separator");
        } else {
            return null;
        }
    }
}
