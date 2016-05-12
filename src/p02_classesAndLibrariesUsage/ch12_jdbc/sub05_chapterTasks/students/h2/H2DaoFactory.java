package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.DaoFactory;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.GroupDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class H2DaoFactory implements DaoFactory {
    @Override
    public Connection getConnection() throws SQLException {
        // catch MissingResourceException
        ResourceBundle resource = ResourceBundle.getBundle("properties.database_students");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        // JDBC 4.x supports driver auto-loading from classpath
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public GroupDao getGroupDao(Connection connection) {
        return new H2GroupDao(connection);
    }

    @Override
    public StudentDao getStudentDao(Connection connection) {
        return null; // not yet implemented
    }
}
