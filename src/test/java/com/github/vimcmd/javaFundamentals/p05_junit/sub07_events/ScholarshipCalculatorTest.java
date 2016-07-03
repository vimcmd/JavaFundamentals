package com.github.vimcmd.javaFundamentals.p05_junit.sub07_events;

import com.github.vimcmd.javaFundamentals.p05_junit.sub03_testExceptions.NoSuchMarkException;
import com.github.vimcmd.javaFundamentals.p05_junit.sub05_rules.ScholarshipCalculatorImplFileWrite;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// # 17 # test running with event listener

@RunWith(ScholarshipRunner.class)
public class ScholarshipCalculatorTest {

    private static ScholarshipCalculatorImplFileWrite calculator;

    @BeforeClass
    public static void init() {
        calculator = new ScholarshipCalculatorImplFileWrite();
    }

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public final Timeout timeout = new Timeout(300, TimeUnit.MILLISECONDS);

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testWriteResult() throws IOException {
        File file = folder.newFile("a:/result.txt"); // test will be failed
        calculator.writeResult(file);
    }

    @Test
    public void testStepUpCoefficientCalculate() throws NoSuchMarkException {
        thrown.expect(NoSuchMarkException.class);
        calculator.stepUpCoefficientCalculate(11);
    }

    @Ignore("test not finished yet")
    @Test
    public void writeResultTestTwo() throws IOException {
        thrown.expect(NullPointerException.class);
        calculator.writeResult(null);
    }
}
