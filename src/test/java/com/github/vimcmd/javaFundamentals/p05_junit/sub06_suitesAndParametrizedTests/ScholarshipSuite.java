package com.github.vimcmd.javaFundamentals.p05_junit.sub06_suitesAndParametrizedTests;

import com.github.vimcmd.javaFundamentals.p05_junit.sub01_testAnnotation.ScholarshipCalculatorTest;
import com.github.vimcmd.javaFundamentals.p05_junit.sub04_testTime.ScholarshipCalculatorImplTimeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// # 13 # run test suite

@Suite.SuiteClasses({ScholarshipCalculatorTest.class, ScholarshipCalculatorImplTimeTest.class})
@RunWith(Suite.class) // run test from annotation above
public class ScholarshipSuite {

}
