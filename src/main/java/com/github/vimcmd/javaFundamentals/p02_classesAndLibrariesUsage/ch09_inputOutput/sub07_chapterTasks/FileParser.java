package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * CustomReader wrapper
 */
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

    private void clearFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            // do nothing
        } catch (IOException e) {
            e.printStackTrace();
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

    /**
     *
     */
    public void allWordsStartsWithVowel() {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineAllWordsStartsWithVowel() ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void allWordsWhereLastCharMatchesNextWordFirstChar() {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineAllWordsWhereLastCharEqualsNextWordFirstChar() ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void allLongestNumbers() {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineAndFindLongestNumber() ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param in String containing words to count
     */
    public void wordsFrequencyFromListInAscendingOrder(String in) {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             CustomReader customReader = new CustomReader(fileReader)) {

            String line = "";
            while (( line = customReader.readLineAndCountFrequencyOfPredefinedWords(in) ) != null) {
                fileWriter.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Counts frequency of letters and words in file
     */
    public void wordsAndLettersFrequency() {
        try (FileWriter fileWriter = new FileWriter(outputFile, true);
             FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            Map<Character, Integer> characterFrequency = new TreeMap<>();
            Map<String, Integer> wordFrequency = new TreeMap<>();

            String line = "";
            while (( line = bufferedReader.readLine() ) != null) {
                for(Character letter : line.toLowerCase().toCharArray()) {
                    if (Character.isAlphabetic(letter)) {
                        int count = characterFrequency.containsKey(letter) ? characterFrequency.get(letter) : 0;
                        characterFrequency.put(letter, count + 1);
                    }
                }

                for(String word : line.toLowerCase().split("[^0-9_A-Za-zА-Яа-я]+")) {
                    if (!word.isEmpty()) {
                        int count = wordFrequency.containsKey(word) ? wordFrequency.get(word) : 0;
                        wordFrequency.put(word, count + 1);
                    }
                }
            }

            fileWriter.write("Letter frequency:" + System.getProperty("line.separator"));
            fileWriter.write(characterFrequency.toString() + System.getProperty("line.separator"));
            fileWriter.write("Word frequency:" + System.getProperty("line.separator"));
            fileWriter.write(wordFrequency.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
