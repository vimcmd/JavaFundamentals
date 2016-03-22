package p02_classesAndLibrariesUsage.ch07_string.sub06_chapterTasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTasksTest {

    public static final String initialStringToReverse = "AbCd@3.";
    public static final String reversedString = ".3@dCbA";
    public static final String initialStringToSortAlphabetically = "   Alena   Alice     alina albina     Anastasya   ALLA ArinA     ";
    public static final String sortedString = "albina Alena Alice alina ALLA Anastasya ArinA";


    /**
     * Basically, it tests default JSE API - StringBuilder.reverse()
     * @throws Exception
     */
    @Test
    public void testStringReverse() throws Exception {
        StringTasks stringExample = new StringTasks(initialStringToReverse);
        stringExample.stringReverse();
        assertEquals("Reversed string wrong", reversedString, stringExample.getResultString());
    }


    @Test
    public void testSortWordsInString() throws Exception {
        StringTasks stringSort = new StringTasks(initialStringToSortAlphabetically);
        stringSort.sortWordsInStringIgnoreCase();
        assertEquals("Sorting words in string goes wrong", sortedString, stringSort.getResultString());
    }


    @Test
    public void testSortWordsInStringDefault() throws Exception {
        StringTasks stringSort = new StringTasks(initialStringToSortAlphabetically);
        stringSort.sortWordsInStringIgnoreCaseUsingArrays();
        assertEquals("Sorting words in string goes wrong", sortedString, stringSort.getResultString());
    }

    @Test
    public void testSortWordsInStringStreamDefault() throws Exception {
        StringTasks stringSort = new StringTasks(initialStringToSortAlphabetically);
        stringSort.sortWordsInStringIgnoreCaseUsingStream();
        assertEquals("Sorting words in string goes wrong", sortedString, stringSort.getResultString());
    }

    @Test
    public void testReplaceCharInEachWord() throws Exception {
        final String initialString = "abc DECVFCNF 1234 ad   vr";
        final String expectedString = "abX DEXVFCNF 12X4 ad   vr";
        StringTasks string = new StringTasks(initialString);
        final char replacingChar = 'X';
        string.replaceCharInEachWord(2, replacingChar);
        assertEquals(expectedString, string.getResultString());
    }

    @Test
    public void testReplaceEachCharInEachWord() throws Exception {
        final String initialString = "abc DECVFCNF 1234 ad   vr";
        final String expectedString = "XXX XXXXXXXX XXXX XX   XX";
        StringTasks string = new StringTasks(initialString);
        final char replacingChar = 'X';
        string.replaceCharInEachWord(-9, replacingChar);
        assertEquals(expectedString, string.getResultString());
    }

    @Test
    public void testReplaceCharIndexLargerThanWordLength() throws Exception {
        final String initialString = "ab cde fge  cn ghtr ";
        StringTasks string = new StringTasks(initialString);
        final char replacingChar = 'X';
        string.replaceCharInEachWord(4, replacingChar);
        assertEquals(initialString, string.getResultString());
    }

    @Test
    public void testReplaceCharUsingRegex() throws Exception {
        final String initialString = "abcde efgra adgdf";
        final String resultString  = "abXde efXra adXdf";
        StringTasks string = new StringTasks(initialString);
        string.replaceCharInEachWordUsingRegex(2, 'X');
        assertEquals(resultString, string.getResultString());
    }

    @Test
    public void testReplaceCharUsingRegex_NoCharsReplaced() throws Exception {
        final String initialString = "abc ef ad qse";
        final String resultString  = "abc ef ad qse";
        StringTasks string = new StringTasks(initialString);
        string.replaceCharInEachWordUsingRegex(5, 'X');
        assertEquals(resultString, string.getResultString());
    }

    @Test
    public void testReplaceCharUsingRegex_NoCharsReplacedInPunctuationSymbols() throws Exception {
        final String initialString = "#^%# %$@%%^% %$#@#&";
        final String resultString  = "#^%# %$@%%^% %$#@#&";
        StringTasks string = new StringTasks(initialString);
        string.replaceCharInEachWordUsingRegex(2, 'X');
        assertEquals(resultString, string.getResultString());
    }

    @Test
    public void testReplaceCharUsingRegex_ExtraSpaces() throws Exception {
        final String initialString = "abc   cfv  cfrt    gtdr   c   ";
        final String resultString  = "abc   cfv  cfrX    gtdX   c   ";
        StringTasks string = new StringTasks(initialString);
        string.replaceCharInEachWordUsingRegex(3, 'X');
        assertEquals(resultString, string.getResultString());
    }

    @Test
    public void testAppendWordIfEndsWithSubstring() throws Exception {
        final String initialString = "lorem temet ememo somnem, indeo alem";
        final String resultString = "lorem WOW temet ememo somnem WOW, indeo alem WOW";
        StringTasks string = new StringTasks(initialString);
        string.appendWordIfEndsWithSubstring("em", "WOW");
        assertEquals(resultString, string.getResultString());
    }

    @Test
    public void testAppendWordIfEndsWithSubstringTailNotMissed() throws Exception {
        final String initialString = "lorem temet ememo somnem, indeo alem";
        final String resultString = "lorem WOW temet ememo somnem, indeo alem";
        StringTasks string = new StringTasks(initialString);
        string.appendWordIfEndsWithSubstring("orem", "WOW");
        assertEquals(resultString, string.getResultString());
    }
}