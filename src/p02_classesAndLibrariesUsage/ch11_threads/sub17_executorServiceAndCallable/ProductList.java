package p02_classesAndLibrariesUsage.ch11_threads.sub17_executorServiceAndCallable;

/* # 40 # list of processed objects */

import java.util.ArrayDeque;

public class ProductList {
    private static ArrayDeque<String> list = new ArrayDeque<String>() {
        {
            this.add("Product 1");
            this.add("Product 2");
            this.add("Product 3");
            this.add("Product 4");
            this.add("Product 5");
        }
    };

    public static String getProduct() {
        return list.poll();
    }
}
