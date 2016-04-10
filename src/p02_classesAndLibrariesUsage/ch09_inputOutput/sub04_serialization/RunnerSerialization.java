package p02_classesAndLibrariesUsage.ch09_inputOutput.sub04_serialization;

/* # 8 # run serialization and deserialization processes */

import java.io.InvalidObjectException;

public class RunnerSerialization {
    public static void main(String[] args) throws InterruptedException {
        // create and write object
        Student student = new Student("MMF", "Sidorov", 1, "Fn$yf^68");
        System.out.println(student);
        String file = "src\\p02_classesAndLibrariesUsage\\ch09_inputOutput\\sub04_serialization\\demo.data";
        Serializator serializator = new Serializator();
        boolean b = serializator.serialization(student, file);

        Student.faculty = "GEO"; // change value of static field

        // read object
        Student res = null;
        try {
            res = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            // processing
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
