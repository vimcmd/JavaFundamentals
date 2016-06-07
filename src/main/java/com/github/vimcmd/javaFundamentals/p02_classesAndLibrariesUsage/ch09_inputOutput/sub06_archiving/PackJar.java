package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub06_archiving;

import java.io.*;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

/* # 12 # create jar-archive */

public class PackJar {
    private String jarFileName;
    private final int BUFFER = 2_048;

    public PackJar(String jarFileName) {
        this.jarFileName = jarFileName;
    }

    public void pack(String dirName) throws FileNotFoundException {
        // get file names list from directory
        File dir = new File(dirName);

        if (!dir.exists() || !dir.isDirectory()) {
            throw new FileNotFoundException(dir + "not found");
        }

        File[] files = dir.listFiles();
        ArrayList<String> listFilesToJar = new ArrayList<>();

        for(int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                listFilesToJar.add(files[i].getPath());
            }
        }

        String[] temp = {};
        String[] filesToJar = listFilesToJar.toArray(temp);

        // archiving (file will be placed in project root)
        try (FileOutputStream fos = new FileOutputStream(jarFileName);
             JarOutputStream jos = new JarOutputStream(fos)) {

            byte[] buffer = new byte[BUFFER];
            // compressing method
            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            for(int i = 0; i < filesToJar.length; i++) {
                jos.putNextEntry(new JarEntry(filesToJar[i]));
                try (FileInputStream fis = new FileInputStream(filesToJar[i])) {
                    int len;
                    while (( len = fis.read(buffer) ) > 0) {
                        jos.write(buffer, 0, len);
                    }
                    jos.closeEntry();
                } catch (FileNotFoundException e) {
                    System.err.println("file not found: " + e);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("illegal argument: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
