package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub02_file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/* # 3 # work with file system */

public class FileTest {
    public static void main(String[] args) {
        // File object associated with file on hard drive
        File fp = new File("src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub02_file\\FileTest2.java");
        if (fp.exists()) {
            System.out.println(fp.getName() + " exists");
            if (fp.isFile()) {
                System.out.println("path to file:\t" + fp.getPath());
                System.out.println("absolute path to file:\t" + fp.getAbsolutePath());
                System.out.println("file size:\t" + fp.length());
                System.out.println("last modification:\t" + new Date(fp.lastModified()));
                System.out.println("can read:\t" + fp.canRead());
                System.out.println("can write:\t" + fp.canWrite());
                System.out.println("file deleted:\t" + fp.delete());
            } else {
                System.out.println("File" + fp.getName() + " not exists");
            }
        }

        try {
            if (fp.createNewFile()) {
                System.out.println("File " + fp.getName() + " succesefully created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // File object associated with directory (folder)
        // in root folder should be exist directory com.learn with few files
        File dir = new File("src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub02_file");
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("directory " + dir.getPath() + " exists");
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for(File file : files) {
                Date date = new Date(file.lastModified());
                System.out.print(file.getPath() + "\t|" + file.length() + "\t|" + date + "\n");
            }
        }

        // listRoots() returns available root directories
        File root = File.listRoots()[1];
        System.out.printf("%s %,d from %,d free\n", root.getPath(), root.getUsableSpace(), root.getTotalSpace());
    }
}
