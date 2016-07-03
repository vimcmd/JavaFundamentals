package com.github.vimcmd.javaFundamentals.p05_junit.sub07_events;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

// # 15 # event listener implementation

public class ScholarshipRunListener extends RunListener {

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("test started: " + description.getMethodName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("test finished:" + description.getMethodName() + "\n---------");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("test failured with exception: " + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("test ignored: " + description.getMethodName() + "\n---------");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("tests run result:");
        System.out.println("run time: " + result.getRunTime() + "ms");
        System.out.println("tests count: " + result.getRunCount());
        System.out.println("tests ignored: " + result.getIgnoreCount());
        System.out.println("all tests was successful: " + result.wasSuccessful());
    }
}
