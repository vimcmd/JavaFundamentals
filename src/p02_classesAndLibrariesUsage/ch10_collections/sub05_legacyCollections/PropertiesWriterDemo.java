package p02_classesAndLibrariesUsage.ch10_collections.sub05_legacyCollections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/* # 19 # create properties instance and file */

public class PropertiesWriterDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            // set values for instance
            properties.setProperty("db.driver", "com.mysql.jdbc.Driver");
            //properties.setProperty("db.url", "jdbc:mysql://127.0.0.1:3306/test");
            properties.setProperty("db.user", "root");
            properties.setProperty("db.password", "pass");
            properties.setProperty("db.poolsize", "5");

            // write properties to file
            File propertiesFile = new File("src" + File.separator + "properties" + File.separator + "database.properties");
            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();
            }
            properties.store(new FileWriter(propertiesFile), "Comments section");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}