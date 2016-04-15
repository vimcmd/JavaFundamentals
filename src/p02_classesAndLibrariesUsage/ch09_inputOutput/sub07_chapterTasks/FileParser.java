package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.*;


public class FileParser {
    private File inputFile;
    private File outputFile;


    // TODO: 13.04.2016 complete javadoc

    /**
     * NOTE: Initialization invokes clear output file content if file exists and not empty.
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    public FileParser(File inputFile, File outputFile) throws IOException {
        if (!inputFile.exists() || inputFile.length() == 0) {
            throw new FileNotFoundException("Input file not exists or empty: " + inputFile.getCanonicalPath());
        } else {
            this.inputFile = inputFile;
        }

        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        if (outputFile.canWrite()) {
            if (outputFile.length() != 0) {
                clearFile(outputFile);
            }
            this.outputFile = outputFile;
        } else {
            throw new IOException("Can not write to file or file not exists");
        }
    }

    /**
     *
     */
    public void toUpperCase() {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineCapitalize() ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param findSubstring
     * @param replacement
     */
    public void replaceSubstringOnEachLine(String findSubstring, String replacement) {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineAndReplaceSubstring(findSubstring, replacement) ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            // do nothing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
