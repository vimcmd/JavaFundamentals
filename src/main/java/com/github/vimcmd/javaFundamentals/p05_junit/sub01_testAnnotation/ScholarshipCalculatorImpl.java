package com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation;

// # 1 # calculating scholarship depending on multiplying factor

public class ScholarshipCalculatorImpl implements IscholarshipCalculator {

    public static final double BASIC_SCHOLARSHIP = 100;

    @Override
    public double scholarshipCalculate(double stepUpCoefficient) {
        return BASIC_SCHOLARSHIP * stepUpCoefficient;
    }

}
