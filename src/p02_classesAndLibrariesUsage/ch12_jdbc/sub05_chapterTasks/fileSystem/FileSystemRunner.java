package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

import java.sql.Connection;
import java.sql.SQLException;

public class FileSystemRunner {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnector.getConnection();
        connection.setAutoCommit(false);

        DbHelper dbHelper = new DbHelper(connection);
        dbHelper.recreateTables();

        //dbHelper.createDir("root\\subroot2\\newFolder", "\\\\");
        dbHelper.createFile("root\\subroot\\whoa\\newfile", "\\\\", 3465245);
        dbHelper.createFile("root\\brandNewFile", "\\\\", 123);

        connection.commit();
        DbConnector.closeConnection(connection);
    }
}
