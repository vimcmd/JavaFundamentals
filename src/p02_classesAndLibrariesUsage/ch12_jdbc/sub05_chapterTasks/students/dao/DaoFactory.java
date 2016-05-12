package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory for working with database
 */
public interface DaoFactory {

    /**
     * @return connection to database
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;

    /**
     * @param connection connection to database
     * @return object for manage persistence of object {@link Group}
     * @see Group
     */
    GroupDao getGroupDao(Connection connection); // may be use getConnection()?

    /**
     * @param connection connection to database
     * @return object for manage persistence of object {@link Student}
     * @see Student
     */
    StudentDao getStudentDao(Connection connection);

}
