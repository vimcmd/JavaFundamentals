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
            Pattern pattern = Pattern.compile("\\b\\w+\\b");
            Matcher matcher = pattern.matcher(line);
            ArrayList<String> words = new ArrayList<>();
            ArrayList<String> resultWords = new ArrayList<>(); // ordered set

            while (matcher.find()) {
                words.add(matcher.group());
            }

            for(int i = 0; i < words.size(); i++) {
                if (i + 1 >= words.size()) {
                    continue;
                }
                String currentWord = words.get(i);
                char currentWordLastChar = currentWord.charAt(currentWord.length() - 1);
                String nextWord = words.get(i + 1);
                char nextWordFirstChar = nextWord.charAt(0);

                if (currentWordLastChar == nextWordFirstChar) {
                    resultWords.add(currentWord.substring(0, currentWord.length() - 1) +
                            "(" + currentWordLastChar + ")" +
                            nextWord.substring(1) + ";");

                    {
                        //if (resultWords.size() <= 1) {
                        //    resultWords.add(words.get(i));
                        //} else if (resultWords.size() > 1 && !( resultWords.get(resultWords.size() - 1) ).equals(currentWord)) {
                        //    // prevent duplication with last added word
                        //    resultWords.add(words.get(i));
                        //}


                        //resultWords.add(words.get(i));
                        //resultWords.add(words.get(i + 1) + ";");
                    }
                }
            }

            return String.join(" ", resultWords).trim() + System.getProperty("line.separator");

        } else {
            return null;
        }
    }
}
