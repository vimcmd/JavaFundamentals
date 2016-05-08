package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private DbConnector() {
    }

    public static Connection getConnection() throws SQLException {
        // TODO: 08.05.2016 move to properties
        String url = "jdbc:h2:~/h2/fileSystem";
        String user = "root";
        String pass = "pass";
        return DriverManager.getConnection(url, user, pass);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
