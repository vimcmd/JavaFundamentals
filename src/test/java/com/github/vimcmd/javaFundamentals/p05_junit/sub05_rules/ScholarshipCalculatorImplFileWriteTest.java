package com.github.vimcmd.javaFundamentals.p05_junit.sub05_rules;

import com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions.NoSuchMarkException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// # 12.2 # test with rules

public class ScholarshipCalculatorImplFileWriteTest {

    private static ScholarshipCalculatorImplFileWrite calculator;

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public final Timeout timeout = new Timeout(200, TimeUnit.MILLISECONDS);

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        calculator = new ScholarshipCalculatorImplFileWrite();
    }

    @Test
    public void testWriteResult() throws IOException {
        File file = folder.newFile("result.txt");
        calculator.writeResult(file);
    }

    @Test
    public void testWriteResult2() throws IOException {
        thrown.expect(NullPointerException.class);
        calculator.writeResult(null);
    }

    @Test
    public void testStepUpCoefficientCalculate() throws NoSuchMarkException {
        thrown.expect(NoSuchMarkException.class);
        calculator.stepUpCoefficientCalculate(11);
    }

}