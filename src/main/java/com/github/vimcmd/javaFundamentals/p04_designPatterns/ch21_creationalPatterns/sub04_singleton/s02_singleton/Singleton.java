package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s02_singleton;

/**
 * Class declares static method getInstance(), which initializes an instance on first call,
 * and later allows clients get controlled access to a single instance.
 * <br>
 * This implementation does not recommend declare other static methods, since calling any
 * of them also initializes an INSTANCE field.
 * <br>
 * If you allow to have subclasses, this approach will allow to refine methods by subclasses
 * and allow to appear more than one instance.
 * <br>
 * In practice this approach rarely used.
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
