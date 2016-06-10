package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch07_string.sub03_regularExpressions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbbreviatorTest {
    private Abbreviator abbr;

    @Before
    public void setUp() throws Exception {
        abbr = new Abbreviator();
    }

    @Test
    public void testAbbreviate() throws Exception {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
    }

    @Test
    public void testAbbreviateSentence() throws Exception {
        String sentense = "Lorem ipsum-dolor sit elit, sed do eiusmod!";
        String sentenseAbbreviated = "L3m i3m-d3r sit e2t, sed do e5d!";
        assertEquals(sentenseAbbreviated, abbr.abbreviate(sentense));
    }

    @Test
    public void testAbbreviateNothing() throws Exception {
        String sentense = "el omo si ten v1m";
        assertEquals(sentense, abbr.abbreviate(sentense));
    }
}