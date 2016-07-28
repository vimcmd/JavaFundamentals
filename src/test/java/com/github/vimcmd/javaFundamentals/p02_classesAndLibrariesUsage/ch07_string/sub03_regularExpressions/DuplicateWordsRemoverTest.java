package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateWordsRemoverTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        DuplicateWordsRemover d = new DuplicateWordsRemover();
        assertEquals("Goodbye bye world", d.removeDuplicates("Goodbye bye bye world world world"));
        assertEquals("Swapnil went to his business", d.removeDuplicates("Swapnil went went to to to his business"));
        assertEquals("Rana is the best player in eye game", d.removeDuplicates("Rana is is the the best player in eye eye game"));
        assertEquals("in inthe", d.removeDuplicates("in inthe"));
        assertEquals("Hello Ab", d.removeDuplicates("Hello hello Ab aB"));
    }
}