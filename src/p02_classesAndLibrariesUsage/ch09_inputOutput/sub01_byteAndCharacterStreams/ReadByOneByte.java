package p02_classesAndLibrariesUsage.ch09_inputOutput.sub01_byteAndCharacterStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* # 1 # Read by one character (byte) from input stream */

public class ReadByOneByte {
    public static void main(String[] args) {
        String file = "data\\file.txt"; // "data" must be in project root
        File f = new File(file);
        int b, count = 0;
        FileReader is = null;
        //FileInputStream fis = null; // alternative

        try {
            is = new FileReader(f);

            while (( b = is.read() ) != -1) {
                System.out.print((char) b);
                count++;
            }
            System.out.print("\n"+"byte count: " + count);

        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("file error: " + e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("closing error: " + e);
            }
        }
    }
}
