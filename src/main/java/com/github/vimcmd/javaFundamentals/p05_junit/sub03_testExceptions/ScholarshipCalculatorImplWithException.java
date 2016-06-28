package com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions;

import com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation.IscholarshipCalculator;

// # 6 # method with exception throwing

public class ScholarshipCalculatorImplWithException implements IscholarshipCalculator {

    public static final double BASIC_SCHOLARSHIP = 100;

    @Override
    public double scholarshipCalculate(double stepUpCoefficient) {
        return BASIC_SCHOLARSHIP * stepUpCoefficient;
    }

    public double stepUpCoefficientCalculate(int averageMark) throws NoSuchMarkException {
        double stepUpCoefficient;
        switch (averageMark) {
            case 2:
                stepUpCoefficient = 0;
                break;
            case 3:
                stepUpCoefficient = 1;
                break;
            case 4:
                stepUpCoefficient = 1.3;
                break;
            case 5:
                stepUpCoefficient = 1.5;
                break;
            default:
                throw new NoSuchMarkException("There is no mark: " + averageMark);
        }
        return stepUpCoefficient;
    }

}
