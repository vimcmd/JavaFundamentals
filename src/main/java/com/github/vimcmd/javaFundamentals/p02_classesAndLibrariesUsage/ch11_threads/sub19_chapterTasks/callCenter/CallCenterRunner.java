package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.callCenter;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CallCenterRunner {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Operator> operators = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            operators.add(new Operator(i));
        }

        CallCenter<Operator> callCenter = new CallCenter<>(operators);

        for(int i = 0; i < 50; i++) {
            new Thread(new Client(callCenter, i)).start();
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        }


    }
}
