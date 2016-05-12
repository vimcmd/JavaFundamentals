package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2.H2DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        H2DaoFactory h2DaoFactory = new H2DaoFactory();
        Connection connection = h2DaoFactory.getConnection();

        if (connection != null) {
            DbHelper dbHelper = new DbHelper(connection);
            dbHelper.recreateTables();
            System.out.println("Done");
        }


    }

    //private static Connection getConnection() {
    //    Connection connection = null;
    //    try {
    //        ResourceBundle resource = ResourceBundle.getBundle("properties.database_students");
    //        String url = resource.getString("db.url");
    //        String user = resource.getString("db.user");
    //        String pass = resource.getString("db.password");
    //        connection = DriverManager.getConnection(url, user, pass);
    //    } catch (MissingResourceException | SQLException e) {
    //        e.printStackTrace();
    //    }
    //
    //    return connection;
    //}
}
