package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub14_latches;

/* # 29 # launch students group formation and executing verification of their tasks */

import java.util.ArrayList;
import java.util.Random;

public class ExamRunner {
    public static void main(String[] args) {
        final int NUMBER_OF_STUDENTS = 3;
        ArrayList<Student> students = new ArrayList<>();

        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            final int NUMBER_OF_TASKS = 1 + ( new Random().nextInt(10) ); // at least one task for each student
            Student student = new Student(new Random().nextInt(9_999), NUMBER_OF_TASKS);
            System.out.println("Student #" + student.getIdStudent() + " have " + NUMBER_OF_TASKS + " tasks");

            for(int j = 0; j < NUMBER_OF_TASKS; j++) {
                Task task = new Task("Task#" + j);
                student.addTask(task);
            }

            students.add(student);
        }

        students.forEach(Student::start);

        Tutor tutor = new Tutor(students);

        try {
            Thread.sleep(new Random().nextInt(5_000)); // start verification thread with delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tutor.start();
    }
}
