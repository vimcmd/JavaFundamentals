package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub03_threadsPriority;

/* # 3.1 #  */

public class PriorityRunner {
    public static void main(String[] args) {
        Thread min = new PriorityThread("Min");
        Thread max = new PriorityThread("Max");
        Thread norm = new PriorityThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        min.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        max.start();
        norm.start();

        //// all threads in group has same priority
        //ThreadGroup threadGroup = new ThreadGroup("Thread group 01");
        //// after creating thread can not change its group membership
        //// if thread had a lower priority before assigning to group, keep old priority value.
        //// but if thread had a higher priority than its group, priority will be set to group value
        //Thread threadA = new Thread(threadGroup, "thread a");
        //threadA.getThreadGroup();
    }
}
