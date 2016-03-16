package Core.javaLang.p01_Classes.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTasksTest {

    /**
     * Basically, it tests default JSE methods - StringBuilder.reverse()
     * @throws Exception
     */
    @Test
    public void testStringReverse() throws Exception {
        String initialString = "AbCd@3.";
        String reversedString = ".3@dCbA";

        StringTasks stringExample = new StringTasks(initialString);
        assertEquals("Reversed string wrong", reversedString, stringExample.stringReverse());
    }
}