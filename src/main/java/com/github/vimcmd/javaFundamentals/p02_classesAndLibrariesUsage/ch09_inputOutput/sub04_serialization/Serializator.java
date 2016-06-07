package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch09_inputOutput.sub04_serialization;

import java.io.*;

/* # 7 # write serializable object to file and deserialize */

public class Serializator {

    public boolean serialization(Student student, String filename) {
        boolean flag = false;
        File file = new File(filename);
        ObjectOutputStream outStream = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                outStream = new ObjectOutputStream(fos);
                outStream.writeObject(student); // serialization
                flag = true;
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("file can not be created: " + e);
        } catch (NotSerializableException e) {
            System.err.println("class do not support serialization: " + e);
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println(e);
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("error on closing stream: " + e);
            }
        }

        return flag;
    }

    public Student deserialization(String filename) throws InvalidObjectException {
        File file = new File(filename);
        ObjectInputStream inStream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            inStream = new ObjectInputStream(fis);
            Student student = (Student) inStream.readObject(); // deserialization
            return student;
        } catch (ClassNotFoundException ce) {
            //e.printStackTrace();
            System.err.println("class not exists: " + ce);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("file not exists: " + e);
        } catch (InvalidClassException ice) {
            System.err.println("class versions mismatch: " + ice);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("error on closing stream: " + e);
            }
        }

        throw new InvalidObjectException("object not deserialized");
    }

}
