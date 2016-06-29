package com.github.vimcmd.javaFundamentals.p05_junit.sub04_testTime;

import com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation.IscholarshipCalculator;

// # 10.1 # test with time limit

public class ScholarshipCalculatorImplTime implements IscholarshipCalculator {

    public static final double BASIC_SCHOLARSHIP = 100;

    @Override
    public double scholarshipCalculate(double stepUpCoefficient) {
        return BASIC_SCHOLARSHIP * stepUpCoefficient;
    }
}
