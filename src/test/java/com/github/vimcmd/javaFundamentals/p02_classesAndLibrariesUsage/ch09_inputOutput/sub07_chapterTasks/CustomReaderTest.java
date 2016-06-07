package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class CustomReaderTest {

    @Test
    public void testReadLineCapitalize() throws Exception {
        String inputString = "Lorem ipsum dolor sit amet\r\n" +
                "consectetur adipisicing elit\r\n" +
                "sed do eiusmod";
        String outputString = "LOREM IPSUM DOLOR SIT AMET\r\n" +
                "CONSECTETUR ADIPISICING ELIT\r\n" +
                "SED DO EIUSMOD\r\n";

        StringWriter output = new StringWriter();
        final StringReader input = new StringReader(inputString);

        CustomReader customReader = new CustomReader(input);

        String out = "";
        while (( out = customReader.readLineCapitalize() ) != null) {
            output.write(out);
        }

        assertEquals(outputString, output.toString());

    }

    @Test
    public void testReadLineAndReplaceSubstring() throws Exception {
        String inputString = "Lorem ipsum dolem sit amet\r\n" +
                "consectetur adipisicing elit\r\n" +
                "sem do eiusmod";
        String outputString = "LorWOW ipsum dolWOW sit amet\r\n" +
                "consectetur adipisicing elit\r\n" +
                "sWOW do eiusmod\r\n";

        StringWriter output = new StringWriter();
        final StringReader input = new StringReader(inputString);

        CustomReader customReader = new CustomReader(input);

        String out = "";
        while (( out = customReader.readLineAndReplaceSubstring("em", "WOW") ) != null) {
            output.write(out);
        }

        assertEquals(outputString, output.toString());
    }

    @Test
    public void testReadLineAllWordsStartsWithVowel() throws Exception {
        String inputString = "Lorem ipsum minima dolor sit amet tenetur\r\n" +
                "consectetur recusandae elit\r\n" +
                "sed to eiusmod";
        String outputString = "ipsum amet\r\n" +
                "elit\r\n" +
                "eiusmod\r\n";

        StringWriter output = new StringWriter();
        final StringReader input = new StringReader(inputString);

        CustomReader customReader = new CustomReader(input);

        String out = "";
        while (( out = customReader.readLineAllWordsStartsWithVowel() ) != null) {
            output.write(out);
        }

        assertEquals(outputString, output.toString());
    }

    @Test
    public void testReadLineAllWordsWhereLastCharEqualsNextWordFirstChar() throws Exception {
        String inputString = "Lorem ipsum minima dolor sit amet tenetur\r\n" +
                "consectetur recusandae elit\r\n" +
                "sed to eiusmod";
        String outputString = "ipsu(M)inima; ame(T)enetur;\r\n" +
                "consectetu(R)ecusandae; recusanda(E)lit;\r\n" +
                "\r\n";

        StringWriter output = new StringWriter();
        final StringReader input = new StringReader(inputString);

        CustomReader customReader = new CustomReader(input);

        String out = "";
        while (( out = customReader.readLineAllWordsWhereLastCharEqualsNextWordFirstChar() ) != null) {
            output.write(out);
        }

        assertEquals(outputString, output.toString());
    }

    @Test
    public void testReadLineAndFindLongestNumber() throws Exception {
        String inputString = "lorem ipsum 026 dolor 003125476 sit amet 645234\r\n" +
                "consectetur 21 311 64 adipisicing elit 0.1567\r\n" +
                "sed 0123 do 4563 eiusmod";
        String outputString = "003125476\r\n" +
                "1567\r\n" +
                "0123 4563\r\n";

        StringWriter output = new StringWriter();
        final StringReader input = new StringReader(inputString);

        CustomReader customReader = new CustomReader(input);

        String out = "";
        while (( out = customReader.readLineAndFindLongestNumber() ) != null) {
            output.write(out);
        }

        assertEquals(outputString, output.toString());
    }
}