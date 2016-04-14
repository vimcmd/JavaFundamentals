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
            return line.toUpperCase() + "\n";
        } else {
            return null;
        }
    }

    public String readLineWithReplace(String findSubstring, String replaceSubstring) {
        // TODO: 14.04.2016 implement method
        return null;
    }
}
