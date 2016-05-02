package p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.callCenter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Operator {
    private int operatorId;

    public Operator(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void phoneConversation() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5_000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
