package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub05_scanner;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/* # 10 # parse text file */

public class ScannerDemo {
    public static void main(String[] args) {
        String filepath = "src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub05_scanner\\scan.txt";
        Scanner scanner = null;
        createFile(filepath);

        try {
            FileReader fr = new FileReader(filepath);
            scanner = new Scanner(fr);
            scanner.useLocale(Locale.ENGLISH);

            // read from file
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt() + " :int");
                } else if (scanner.hasNextBoolean()) {
                    System.out.println(scanner.nextBoolean() + " :boolean");
                } else if (scanner.hasNextDouble()) {
                    System.out.println(scanner.nextDouble() + " :double");
                } else {
                    System.out.println(scanner.next() + " :String");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void createFile(String filepath) {
        File file = new File(filepath);
        FileWriter fw = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
                fw = new FileWriter(file);
                fw.write("true\n" +
                        "0\n" +
                        "Java\n" +
                        "0.2\n" +
                        "12\n" +
                        "1.7\n" +
                        "false\n" +
                        "1/2");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
