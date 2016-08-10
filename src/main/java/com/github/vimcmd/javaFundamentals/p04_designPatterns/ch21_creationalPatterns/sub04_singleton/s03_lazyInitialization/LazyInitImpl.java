package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s03_lazyInitialization;

/**
 * Declaring static inner class, which static field is an singleton instance
 * solves problem of third-party static class methods owner, and provides
 * lazy initialization.
 * <br>
 * Proposed by Bill Pough.
 * <br>
 * Single instance initialized on first call getInstance().
 * The problem with processing exceptions in constructor still has not been solved.
 * So, if the class constructor does not cause fears of creating exceptions, you can use this approach.
 */
public class LazyInitImpl {

    private LazyInitImpl() {
    }

    public static LazyInitImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder { // nested class
        private static final LazyInitImpl INSTANCE = new LazyInitImpl();
    }

}
