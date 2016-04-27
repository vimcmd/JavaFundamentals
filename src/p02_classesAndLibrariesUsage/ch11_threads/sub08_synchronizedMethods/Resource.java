package p02_classesAndLibrariesUsage.ch11_threads.sub08_synchronizedMethods;

import java.io.*;

/* # 12.1 # resource with synchronised write method */

public class Resource {
    private FileWriter fileWriter;

    public Resource(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }

        fileWriter = new FileWriter(file, true);
    }

    // to avoid simultaneous concurrent thread writing use synchronized
    public synchronized void write(String str, int i) { // try without synchronized
        try {
            fileWriter.append(str + i);
            System.out.print(str + i);
            Thread.sleep((long) ( Math.random() * 50 ));
            fileWriter.append(">>" + i + " ");
            System.out.print(">>" + i + " ");
            // must be string(i)>>(i), without synchronized result may be anything
        } catch (IOException e) {
            System.err.println("file error: " + e);
        } catch (InterruptedException e) {
            System.err.println("thread error: " + e);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("file closing error: " + e);
        }
    }
}
