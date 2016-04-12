package p02_classesAndLibrariesUsage.ch09_inputOutput.sub06_archiving;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* # 14 # read jar-archive */

public class UnPackJar {
    private File destFile;
    private final int BUFFER = 2_048;

    public void unpack(String destinationDirectory, String nameJar) {
        File sourceJarFile = new File(nameJar);

        try (JarFile jarFile = new JarFile(sourceJarFile)) {
            File unzipDir = new File(destinationDirectory);

            // open jar-archive for extracting
            Enumeration<JarEntry> jarFileEntries = jarFile.entries();
            while (jarFileEntries.hasMoreElements()) {

                // extract current entry from archive
                JarEntry entry = jarFileEntries.nextElement();
                String entryName = entry.getName();
                System.out.println("Extracting: " + entryName);
                destFile = new File(unzipDir, entryName);

                // define directory
                File destinationParent = destFile.getParentFile();

                // create directories hierarchy
                destinationParent.mkdirs();

                // extract entry if it is not directory
                if (!entry.isDirectory()) {
                    writeFile(jarFile, entry);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void writeFile(JarFile jarFile, JarEntry entry) {
        int currentByte;
        byte data[] = new byte[BUFFER];

        try (BufferedInputStream bis = new BufferedInputStream(jarFile.getInputStream(entry));
             FileOutputStream fos = new FileOutputStream(destFile);
             BufferedOutputStream destination = new BufferedOutputStream(fos, BUFFER)) {

            // write file to drive
            while (( currentByte = bis.read(data, 0, BUFFER) ) > 0) {
                destination.write(data, 0 , currentByte);
            }
            destination.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
