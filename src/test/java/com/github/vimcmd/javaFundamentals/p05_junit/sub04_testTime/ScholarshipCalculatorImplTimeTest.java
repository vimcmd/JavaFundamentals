package com.github.vimcmd.javaFundamentals.p05_junit.sub04_testTime;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

// # 10.2 # test with time limit

public class ScholarshipCalculatorImplTimeTest {

    private static ScholarshipCalculatorImplTime calculator;

    @BeforeClass
    public static void init() {
        calculator = new ScholarshipCalculatorImplTime();
    }

    // FAILED with 10 but ok with 50
    @Test(timeout = 10) // try with 50
    public void testScholarshipCalculate() throws Exception {
        for(int i = 1; i < 100_000; i++) {
            double stepUpCoefficient = 1 / i;
            double expected = 100 * stepUpCoefficient;
            double actual = calculator.scholarshipCalculate(stepUpCoefficient);
            assertEquals(expected, actual, 0.01);
        }
    }
}