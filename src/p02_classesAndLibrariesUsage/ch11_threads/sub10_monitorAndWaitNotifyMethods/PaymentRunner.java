package p02_classesAndLibrariesUsage.ch11_threads.sub10_monitorAndWaitNotifyMethods;

/* # 15.2 # interaction of wait() and notify() */

public class PaymentRunner {
    public static void main(String[] args) throws InterruptedException {
        final Payment payment = new Payment();

        new Thread() {
            @Override
            public void run() {
                payment.doPayment(); // call synchronized method
            }
        }.start();

        Thread.sleep(200);

        synchronized (payment) {
            payment.initAmount();
            System.out.println("Amount initialized with " +  + payment.getAmount());
            payment.notify(); // notify about lock returning
        }

        synchronized (payment) {
            payment.wait(1_000);
            System.out.println("done");
        }
    }
}
