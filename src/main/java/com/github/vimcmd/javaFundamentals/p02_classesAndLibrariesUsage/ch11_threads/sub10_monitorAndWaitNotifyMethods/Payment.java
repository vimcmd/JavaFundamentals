package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub10_monitorAndWaitNotifyMethods;

/* # 15.1 # interaction of wait() and notify() */

public class Payment {
    // Each object instance have 'monitor'. Monitor may have only one owner at time.
    // When concurrent thread tries to access object, which already have owner,
    // it must wait until owner will release monitor, and only after that take ownership and start to use object.
    // Methods wait(), notify(), notifyAll() works correctly only with instances, whose monitor already owned by someone.
    // Static methods capture monitor of class instance 'Class' on class, on which is called.

    private int amount;
    private boolean close;

    public int getAmount() {
        return amount;
    }

    public boolean isClose() {
        return close;
    }

    public synchronized void doPayment() {
        try {
            System.out.println("PAYMENT IS STARTED");

            while (amount <= 0) {
                this.wait(); // pause thread and release lock
                // after retuning lock, execution will be continued
            }

            // some code to complete payment

            close = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PAYMENT IS CLOSED: " + isClose());
    }

    public void initAmount() {
        amount = (int) ( Math.random() * 100 );
    }
}
