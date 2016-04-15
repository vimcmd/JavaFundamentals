package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CustomReader extends BufferedReader {
    public CustomReader(Reader in) {
        super(in);
    }

    public String readLineCapitalize() throws IOException {
        String line = super.readLine();
        if (line != null) {
            return line.toUpperCase() + System.getProperty("line.separator");
        } else {
            return null;
        }
    }

    public String readLineAndReplaceSubstring(String findSubstring, String replacement) throws IOException {
        String line = super.readLine();
        if (line != null) {
            return line.replaceAll(findSubstring, replacement) + System.getProperty("line.separator");
        } else {
            return null;
        }
    }
}
