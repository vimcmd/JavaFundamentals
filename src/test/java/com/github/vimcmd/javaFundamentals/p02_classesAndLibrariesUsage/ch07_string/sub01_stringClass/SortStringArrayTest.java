package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub01_stringClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortStringArrayTest {
    
    @Test
    public void testSortStringArray() throws Exception {
        SortStringArray sortExample = new SortStringArray("Alena Alice alina albina Anastasya ALLA ArinA");
        String expectedValue = "albina Alena Alice alina ALLA Anastasya ArinA";
        assertEquals(expectedValue, sortExample.sortStringArray());
    }

    @Test
    public void testSortStringArray2() throws Exception {
        SortStringArray sortExample = new SortStringArray("Zz zx zb Za");
        String expectedValue = "Za zb zx Zz";
        assertEquals(expectedValue, sortExample.sortStringArray());
    }
}