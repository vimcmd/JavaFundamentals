package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {
    private File inputFile;
    private File outputFile;

    // TODO: 13.04.2016 implement classes from different readers for ease parsing


    /**
     * @param outputFile
     */
    public FileParser(File outputFile) throws IOException {
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        if (outputFile.canWrite()) {
            this.outputFile = outputFile;
        } else {
            throw new IOException("Can not write to file or file not exists");
        }
    }


    public void toUpperCase() {
        try (FileWriter fileWriter = new FileWriter(outputFile, false); BufferedWriter bw = new BufferedWriter(fileWriter)) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
