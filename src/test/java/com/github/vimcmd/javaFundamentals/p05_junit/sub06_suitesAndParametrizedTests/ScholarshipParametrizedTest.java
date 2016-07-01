package com.github.vimcmd.javaFundamentals.p05_junit.sub06_suitesAndParametrizedTests;

import com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions.NoSuchMarkException;
import com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions.ScholarshipCalculatorImplWithException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScholarshipParametrizedTest {

    // parameters declaration as fields
    private int averageMark;
    private double stepUpCoefficient;

    // public constructor with arguments for field initialization
    public ScholarshipParametrizedTest(int averageMark, double stepUpCoefficient) {
        this.averageMark = averageMark;
        this.stepUpCoefficient = stepUpCoefficient;
    }

    // define parameters as collection
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{2, 0.0}, {3, 1.0}, {4, 1.3}, {5, 1.5}});
    }

    @Test
    public void testStepUpCoefficient() throws NoSuchMarkException {
        ScholarshipCalculatorImplWithException calculator = new ScholarshipCalculatorImplWithException();
        double expected = this.stepUpCoefficient;
        double actual = calculator.stepUpCoefficientCalculate(this.averageMark);
        assertEquals(expected, actual, 0.01);
    }
}
