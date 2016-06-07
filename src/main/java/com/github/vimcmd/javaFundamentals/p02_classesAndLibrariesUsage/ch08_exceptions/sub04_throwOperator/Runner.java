package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch08_exceptions.sub04_throwOperator;

/* # 3 # Exceptions generation */

public class Runner {
    public static void main(String[] args) {
        SameResource f = new SameResource(); // SameResource f = null;

        try { // not required only if correct parameter value guarantied
            Connector.loadResource(f);
        } catch (IllegalArgumentException e) {
            System.err.println("Unchecked exception handling outside method: " + e);
        }

    }
}
