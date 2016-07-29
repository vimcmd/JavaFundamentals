package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlTagValidContentExtractorTest {

    private static HtmlTagValidContentExtractor htvce;

    @Before
    public void setUp() throws Exception {
        htvce = new HtmlTagValidContentExtractor();
    }

    @Test
    public void testExtractValidContent0() throws Exception {
        List<String> expected = new ArrayList<String>() {
            {
                add("Nayeem loves counseling");
            }
        };
        assertEquals(expected, htvce.extractValidContent("<h1>Nayeem loves counseling</h1>"));
    }

    @Test
    public void testExtractValidContent1() throws Exception {
        List<String> expected = new ArrayList<String>() {
            {
                add("Sanjay has no watch");
            }
        };
        assertEquals(expected, htvce.extractValidContent("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>"));
    }

    @Test
    public void testExtractValidContent2() throws Exception {
        List<String> expected = new ArrayList<String>() {
            {
                add("None");
            }
        };
        assertEquals(expected, htvce.extractValidContent("<Amee>safat codes like a ninja</amee>"));
    }


}