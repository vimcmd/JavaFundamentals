package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;


import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = "input.txt";
        File inputFile = new File(input);
        String output = "output.txt";
        File outputFile = new File(output);

        if (!inputFile.exists()) {
            inputFile.createNewFile();
        }

        FileFiller fileFiller = new FileFiller(inputFile);
        fileFiller.fillPoem();

        // do something with other class
    }
}
