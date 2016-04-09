package p02_classesAndLibrariesUsage.ch09_inputOutput.sub03_predfinedStreams;

import java.io.*;
import java.util.Locale;

/* # 4 # Buffered write to file */

public class BufferedWriterDemo {

    public static void main(String[] args) {
        String filePath = "src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub03_predfinedStreams\\res.txt";
        File f = new File(filePath);
        double arr[] = {1.10, 1.21, 1.4412, 5.0, 6.014, 7, 8};

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            for ( double version : arr ) {
                pw.printf(Locale.ENGLISH,"Java %.2g%n", version);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("io error: " + e);
        } finally {
            if (pw != null) {
                pw.close(); // only outer stream should be closed

                // since 1.7 mostly interfaces added AutoCloseable, which implicitly invokes close()
                // called try-with-resources (multiple)
                // on all streams created from:
                // try( stream1 ; stream2 ; ... ; streamN) {} catch {}
                // for ex:
                //
                //String destination1 = "destination1";
                //String destination2 = "destination2";
                //
                //try (Writer writer = new FileWriter(destination1); OutputStream out = new FileOutputStream(destination2)) {
                //    // using writer and out
                //    writer.flush();
                //    out.flush();
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
            }
        }
    }
}