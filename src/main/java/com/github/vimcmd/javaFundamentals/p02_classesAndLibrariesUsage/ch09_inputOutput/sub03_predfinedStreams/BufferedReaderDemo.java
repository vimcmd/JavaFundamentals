package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub03_predfinedStreams;

import java.io.*;

/* # 5 # Read from file */

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String filePath = "src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub03_predfinedStreams\\res.txt";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null) {
                String[] s = tmp.split("\\s");
                for ( String res : s ) {
                    System.out.println(res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
