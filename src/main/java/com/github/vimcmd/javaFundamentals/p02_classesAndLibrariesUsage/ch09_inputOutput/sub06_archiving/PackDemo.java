package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub06_archiving;

/* # 13 # start archiving process */

import java.io.FileNotFoundException;

public class PackDemo {
    public static void main(String[] args) {
        String dirName = "src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub06_archiving";
        PackJar pj = new PackJar("example.jar");

        try {
            pj.pack(dirName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
