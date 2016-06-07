package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.callCenter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

    private int clientId;
    private boolean conversation;
    private CallCenter<Operator> callCenter;

    public Client(CallCenter<Operator> callCenter, int clientId) {
        this.callCenter = callCenter;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        Operator operator = null;
        try {
            operator = call();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (operator != null) {
                conversation = false;
                System.out.println("Client #" + clientId + " conversation with operator #" + operator.getOperatorId() + " ended");
                callCenter.releaseOperator(operator);
            }
        }
    }

    private Operator call() throws InterruptedException {
        Operator operator = null;
        operator = callCenter.incomingCallHandle(new Random().nextInt(2_000));
        if (operator != null) {
            conversation = true;
            System.out.println("Client #" + clientId + " conversation with operator #" + operator.getOperatorId() + " started");
            operator.phoneConversation();
        } else {
            System.out.println("Client #" + clientId + " hang up");
            boolean recall = new Random().nextInt(2) < 1;
            if (recall) {
                int recallAfterTime = new Random().nextInt(5_000);
                System.out.println("Client #" + clientId + " will recall after " + recallAfterTime);
                TimeUnit.MILLISECONDS.sleep(recallAfterTime);
                call();
            } else {
                System.out.println("Client #" + clientId + " no more calls");
            }
        }
        return operator;
    }
}
