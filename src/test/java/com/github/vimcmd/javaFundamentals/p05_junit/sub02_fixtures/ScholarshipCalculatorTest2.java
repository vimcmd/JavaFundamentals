package com.github.vimcmd.javaFundamentals.p05_junit.sub02_fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// # 4 # test with fixtures @Before and @After

public class ScholarshipCalculatorTest2 {

    private ScholarshipCalculatorImpl scholarshipCalculator;

    @Before
    public void setUp() throws Exception {
        scholarshipCalculator = new ScholarshipCalculatorImpl();
    }

    @After
    public void tearDown() throws Exception {
        scholarshipCalculator = null;
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