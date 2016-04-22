package p02_classesAndLibrariesUsage.ch10_collections.sub05_legacyCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* # 20 # load properties file to instance and access to data */

public class PropertiesReaderDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            // load key-value pair properties via I/O stream
            properties.load(new FileReader("src" + File.separator + "properties" + File.separator + "database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = properties.getProperty("db.driver");

        // next two keys not exists in file
        String maxIdle = properties.getProperty("db.maxIdle"); // null will be assigned

        // value '20' will be assigned to key, if its not found in file
        String maxActive = properties.getProperty("db.maxActive", "20");

        System.out.println(driver);
        System.out.println(maxIdle);
        System.out.println(maxActive);
    }
}
