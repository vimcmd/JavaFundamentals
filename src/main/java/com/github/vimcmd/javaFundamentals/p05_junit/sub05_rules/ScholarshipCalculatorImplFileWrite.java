package com.github.vimcmd.javaFundamentals.p05_junit.sub05_rules;

import com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation.IscholarshipCalculator;
import com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions.NoSuchMarkException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// # 12.1 # test with rules

public class ScholarshipCalculatorImplFileWrite implements IscholarshipCalculator {

    public static final double BASIC_SCHOLARSHIP = 100;

    @Override
    public double scholarshipCalculate(double stepUpCoefficient) {
        return BASIC_SCHOLARSHIP * stepUpCoefficient;
    }

    public void writeResult(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.append(this.toString());
        fw.flush();
        fw.close();
    }

    public double stepUpCoefficientCalculate(int averageMark) throws NoSuchMarkException {
        double stepUpCoefficient;
        switch (averageMark) {
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
