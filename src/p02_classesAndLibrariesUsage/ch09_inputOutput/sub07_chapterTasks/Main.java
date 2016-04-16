package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;


import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = "input.txt";
        File inputFile = new File(input);
        String output = "output.txt";
        File outputFile = new File(output);

        // TODO: 16.04.2016 write tests

        FileFiller fileFiller = new FileFiller(inputFile);
        fileFiller.fillWordsWithSameEndStart();

        FileParser fileParser = new FileParser(inputFile, outputFile);
        fileParser.allWordsWhereLastCharMatchesNextWordFirstChar();
    }
}
