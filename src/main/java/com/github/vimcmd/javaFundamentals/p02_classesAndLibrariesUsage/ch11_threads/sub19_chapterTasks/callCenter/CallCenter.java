package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.callCenter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CallCenter<Operator> {
    private final Queue<Operator> operators = new LinkedList<>();
    private Semaphore semaphore;

    public CallCenter(Queue<Operator> operatorList) {
        operators.addAll(operatorList);
        semaphore = new Semaphore(operators.size(), true);
        System.out.println("Available " + semaphore.availablePermits() + " operators");
    }

    public Operator incomingCallHandle(long maxWaitTimeoutMillis) throws InterruptedException {
        if (semaphore.tryAcquire(maxWaitTimeoutMillis, TimeUnit.MILLISECONDS)) {
            return operators.poll();
        } else {
            System.out.println("No operators available. Waiting...");
        }
        return null;
    }

    public void releaseOperator(Operator operator) {
        operators.add(operator);
        semaphore.release();
    }
}
