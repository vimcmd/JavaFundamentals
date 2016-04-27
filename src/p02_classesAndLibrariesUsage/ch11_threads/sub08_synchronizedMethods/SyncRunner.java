package p02_classesAndLibrariesUsage.ch11_threads.sub08_synchronizedMethods;

/* # 12.3 # write to single file with concurrent threads using synchronization */

import java.io.IOException;

public class SyncRunner {
    public static void main(String[] args) {
        Resource resource = null;
        try {
            resource = new Resource("src\\p02_classesAndLibrariesUsage\\ch11_threads\\sub08_synchronizedMethods\\resource.txt");
            SyncThread t1 = new SyncThread("FIRST", resource);
            SyncThread t2 = new SyncThread("SECOND", resource);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.println("file error: " + e);
        } catch (InterruptedException e) {
            System.err.println("thread error: " + e);
        } finally {
            if (resource != null) {
                resource.close();
            }
        }
    }
}
