package p02_classesAndLibrariesUsing.ch07_strings.sub08_chapterTasks;

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
}