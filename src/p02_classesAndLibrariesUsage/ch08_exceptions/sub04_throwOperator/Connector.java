package p02_classesAndLibrariesUsage.ch08_exceptions.sub04_throwOperator;

/* # 3 # Exceptions generation */

public class Connector {
    public static void loadResource(SameResource f) {
        if (f == null || !f.exists() || f.isCreate()) {
            throw new IllegalArgumentException();
            // or for example,
            //throw new IllegalResourceException();
        }
        // more code
    }
}
