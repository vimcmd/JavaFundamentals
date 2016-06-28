package com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// # 8-9 # testing method which generates exception

public class ScholarshipCalculatorImplWithExceptionTest {

    private static ScholarshipCalculatorImplWithException calculator;

    @BeforeClass
    public static void init() {
        calculator = new ScholarshipCalculatorImplWithException();
    }

    /**
     * Test will be successful only if expected exception will be generated
     *
     * @throws Exception
     */
    @Test(expected = NoSuchMarkException.class)
    public void testStepUpCoefficientCalculateForEleven() throws Exception {
        double expected = 1;
        double actual = calculator.stepUpCoefficientCalculate(11);
        assertEquals("For mark 11 wasn't exception: ", expected, actual, 0.01);
    }

    /**
     * Test will be successful only if expected exception message correct
     *
     * @throws Exception
     */
    @Test
    public void testStepUpCoefficientCalculateForElevenExceptionText() throws Exception {
        int averageMark = 11;
        try {
            calculator.stepUpCoefficientCalculate(averageMark);
            // if no exceptions generated, call fail() method, which means test failed
            fail("Test for mark " + averageMark + " should have thrown a NoSuchMarkException");
        } catch (NoSuchMarkException e) {
            // test exception message
            assertEquals("There is no mark: " + averageMark, e.getMessage());
        }
    }

}