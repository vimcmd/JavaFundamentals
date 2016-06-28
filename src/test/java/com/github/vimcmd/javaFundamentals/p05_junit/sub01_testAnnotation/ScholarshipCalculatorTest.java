package com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation;

import org.junit.Test;

import static org.junit.Assert.*;

// # 2 # test with annotation @Test

public class ScholarshipCalculatorTest {

    @Test
    public void testScholarshipCalculate() throws Exception {
        IscholarshipCalculator calculator = new ScholarshipCalculatorImpl();

        double basicScholarship = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP;
        double stepUpCoefficient = 1.1;
        double expected = basicScholarship * stepUpCoefficient;
        double actual = calculator.scholarshipCalculate(stepUpCoefficient);

        // check with delta 0.01
        assertEquals(expected, actual, 0.01);
        // or with message:
        //assertEquals("wrong calculation results: ", expected, actual, 0.01);

        // deprecated
        //assertEquals(expected, actual); // exact match
    }
}