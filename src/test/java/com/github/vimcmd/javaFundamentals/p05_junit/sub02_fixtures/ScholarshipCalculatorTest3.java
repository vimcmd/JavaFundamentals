package com.github.vimcmd.javaFundamentals.p05_junit.sub02_fixtures;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// # 5 # test with fixture @BeforeClass

public class ScholarshipCalculatorTest3 {

    private static ScholarshipCalculatorImpl scholarshipCalculator;

    @BeforeClass
    public static void initScholarshipCalculator() { // must be static
        scholarshipCalculator = new ScholarshipCalculatorImpl();
    }

    @Test
    public void setUpCoefficientForFive() throws Exception {
        double expected = 1.5;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(5);
        assertEquals("Coefficient for mark 5 is wrong: ", expected, actual, 0.01);
    }

    @Test
    public void setUpCoefficientForThree() throws Exception {
        double expected = 1;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(3);
        assertEquals("Coefficient for mark 3 is wrong: ", expected, actual, 0.01);
    }
}