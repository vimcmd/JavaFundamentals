package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub04_singleton.s01_singletonEnum;

/**
 * Any implementation of enum class guarantees that only one instance of each element.
 * When implementing a singleton pattern, enumeration describes only one item.
 * <br>
 * Possibility of an exception in the constructor imposes certain responsibilities
 * on instance initialization process. Re-initialization process must be posiible
 * in singleton implementation.
 */
public enum SingletonEnum {
    INSTANCE

    // fields, methods
}
