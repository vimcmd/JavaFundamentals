package p02_classesAndLibrariesUsage.ch11_threads.sub14_latches;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/* # 26 # student-thread, performing tasks and waiting for verification */

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> tasks;
    private CountDownLatch countDownLatch;

    public Student(Integer idStudent, int numberOfTasks) {
        this.idStudent = idStudent;
        this.countDownLatch = new CountDownLatch(numberOfTasks);
        this.tasks = new ArrayList<Task>(numberOfTasks);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void run() {
        int i = 0;

        for(Task currentTask : tasks) {
            // some time for solving task
            try {
                Thread.sleep(new Random().nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // send answer
            currentTask.setAnswer("Answer #" + ++i);
            System.out.println("answer #" + i + " from student " + getIdStudent() + " for " + currentTask.getContent());
        }

        try {
            countDownLatch.await(); // waiting for answer verification
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // count average mark
        float averageMark = 0;
        for(Task task : tasks) {
            // do something
            averageMark += task.getMark();
        }

        averageMark /= tasks.size();

        System.out.println("Student #" + getIdStudent() + " average mark: " + averageMark);
    }
}
