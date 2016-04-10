package p02_classesAndLibrariesUsage.ch09_inputOutput.sub04_serialization;

import java.io.Serializable;

/* # 6 # Serializable class */

public class Student implements Serializable {

    // NOTE: if class extends not serializable class, it must have public constructor without arguments for
    // proper variables initialization

    protected static String faculty; // will not be serialized, initialized on deserialization
    private String name;
    private int id;
    private transient String password; // will be initialized with default value according to type
    private static final long serialVersionUID = 1L; // only case when static field will be serialized. Must be have new value on any class changes

    public Student(String nameOfFaculty, String name, int id, String password) {
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nfaculty: " + faculty + "\nname: " + name + "\nid: " + id + "\npassword: " + password;
    }
}
