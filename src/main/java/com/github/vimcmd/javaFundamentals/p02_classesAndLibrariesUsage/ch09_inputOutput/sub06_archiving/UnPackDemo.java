package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub06_archiving;



public class UnPackDemo {
    // NOTE: all paths must be absolute or relative to project root
    public static void main(String[] args) {

        // location and name of archive
        String nameJar = "example.jar";

        // output location
        String destinationPath = "d:\\temp\\";

        new UnPackJar().unpack(destinationPath, nameJar);
    }
}
