package p02_classesAndLibrariesUsage.ch11_threads.sub17_executorServiceAndCallable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* # 41 # thread which processes an instance of product */

public class BaseCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String product = ProductList.getProduct();
        String result = null;

        if (product != null) {
            result = product + " done!";
        } else {
            result = "product list is empty";
        }

        TimeUnit.MILLISECONDS.sleep(500 + new Random().nextInt(1_000));
        System.out.println(result);
        return result;
    }
}
