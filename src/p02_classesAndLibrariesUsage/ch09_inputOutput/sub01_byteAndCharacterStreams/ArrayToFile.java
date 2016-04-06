package p02_classesAndLibrariesUsage.ch09_inputOutput.sub01_byteAndCharacterStreams;

import java.io.*;

/* # 2 # Out array to stream as characters and bytes */

public class ArrayToFile {
    public static void main(String[] args) {
        String pArray[] = {"foo", "bar", "java se 8"};
        File fbyte = new File("data\\byte.data");
        File fsymb = new File("data\\symbol.txt");

        FileOutputStream fos = null;
        FileWriter fw = null;

        try {
            fos = new FileOutputStream(fbyte);
            fw = new FileWriter(fsymb);
            
            for ( String s : pArray ) {
                fos.write(s.getBytes());
                fw.write(s);
            }
            
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("error on io stream opening: " + e);
        } finally {
            // each close() call needs own try-catch block
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("error on io stream closing: " + e);
            }

            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("error on io stream closing: " + e);
            }
        }
    }
}
