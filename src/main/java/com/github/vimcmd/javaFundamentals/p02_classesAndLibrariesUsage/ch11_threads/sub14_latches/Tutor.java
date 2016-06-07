package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub14_latches;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* # 27 # tutor-thread, verifies students tasks */

public class Tutor extends Thread {
    private Integer idTutor;
    private List<Student> students;

    public Tutor() {
        this.students = new ArrayList<>();
    }

    public Tutor(List<Student> students) {
        this.students = students;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public void run() {
        for(Student student : students) {
            // check if student have tasks
            List<Task> tasks = student.getTasks();
            for(Task task : tasks) {

                try {
                    Thread.sleep(new Random().nextInt(1_000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // check if answer exists
                int mark = 3 + new Random().nextInt(7); // set mark from 3 to 10
                task.setMark(mark);
                System.out.println("Mark " + mark + " for student #" + student.getIdStudent() + " for " + task.getContent());
                student.getCountDownLatch().countDown();
            }
            System.out.println("All estimates are made for student #" + student.getIdStudent() + " complete");
        }
    }
}
