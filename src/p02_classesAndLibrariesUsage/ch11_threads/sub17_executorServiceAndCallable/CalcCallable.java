package p02_classesAndLibrariesUsage.ch11_threads.sub17_executorServiceAndCallable;

import java.util.Random;
import java.util.concurrent.Callable;

/* # 38 # callable thread with returning result */

public class CalcCallable implements Callable<Number> {
    @Override
    public Number call() throws Exception {
        return new Random().nextGaussian(); // computing imitation
    }
}
