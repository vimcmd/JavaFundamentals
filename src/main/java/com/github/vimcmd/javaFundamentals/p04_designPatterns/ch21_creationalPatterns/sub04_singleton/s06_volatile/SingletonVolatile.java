package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s06_volatile;

/**
 * When you create single instance in multithreading application,
 * should be guaranteed inability to obtain not fully constructed object
 * and not lose performance due continuous monitoring of reference
 * synchronization logs. One of possible solutions for this problem
 * is usage volatile variables.
 * <br>
 * Volatile modifier declares that at the reference to the object
 * will be stored address of variable in processor cache, which eliminates
 * the possibility of obtaining outdated data by the reference in a
 * multithreaded application.
 */
public class SingletonVolatile {

    private static SingletonVolatile instance = null;
    private volatile static boolean isInstanceCreated = false;

    private SingletonVolatile() {
    }

    public static SingletonVolatile getInstance() {
        if (!isInstanceCreated) {
            synchronized (SingletonVolatile.class) {
                // or any other lock type
                // for ex. ReentrantLock or Semaphore
                try {
                    if (!isInstanceCreated) {
                        instance = new SingletonVolatile();
                        isInstanceCreated = true;
                    }
                } catch (Exception e) {
                    // process initialization exception
                }
            }
        }
        return instance;
    }

}
