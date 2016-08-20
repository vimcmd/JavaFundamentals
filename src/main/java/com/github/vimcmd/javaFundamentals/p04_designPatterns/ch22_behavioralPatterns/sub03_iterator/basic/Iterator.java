package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch22_behavioralPatterns.sub03_iterator.basic;

/**
 * analogue to java.util.iterator
 */
public interface Iterator {

    /**
     * set iterator to initial position
     */
    void first();

    /**
     * analogue to hasNext()
     */
    boolean isDone();

    /**
     * change iterator value, next() analogue
     */
    void next();

    /**
     * extracts object from current position, next() analogue
     */
    Object currentItem();

}
