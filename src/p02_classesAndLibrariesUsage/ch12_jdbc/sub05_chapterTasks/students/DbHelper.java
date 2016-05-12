package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {
    private Connection connection;

    public DbHelper(Connection connection) {
        this.connection = connection;
    }

    public void recreateTables() throws SQLException {
        this.connection.setAutoCommit(false);
        dropTables();
        createTables();
        fillData();
        this.connection.commit();
    }

    private void dropTables() throws SQLException {
        final String SQL_DROP_TABLES = "DROP TABLE IF EXISTS `Group`, `Student`";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(SQL_DROP_TABLES);
        statement.close();
    }

    private void createTables() throws SQLException {
        final String SQL_CREATE_TABLES = "" +
                "CREATE TABLE IF NOT EXISTS `Group` (" +
                "id INT NOT NULL AUTO_INCREMENT ," +
                "number INT NOT NULL ," +
                "department VARCHAR(45) NULL ," +
                "PRIMARY KEY (id)" +
                ");" +
                "CREATE TABLE IF NOT EXISTS `Student` (" +
                "id INT NOT NULL AUTO_INCREMENT ," +
                "name VARCHAR(45) NULL ," +
                "surname VARCHAR(45) NULL ," +
                "enrolment_date DATE NULL ," +
                "group_id INT, " +
                "PRIMARY KEY (id)" +
                ");";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(SQL_CREATE_TABLES);
        statement.close();
    }

    private void fillData() throws SQLException {
        final String SQL_INSERT_DATA = "" +
                "INSERT INTO `Group`(number, department) " +
                "VALUES " +
                "('112233', 'Information technologies')," +
                "('223344', 'Cybernetics')," +
                "('777777', 'Algorithms and analysis');" +
                "" +
                "INSERT INTO `Student`(name, surname, enrolment_date, group_id) " +
                "VALUES " +
                "('Phyliss', 'Havener', '2014-09-01', '1')," +
                "('Dawn', 'Mcafee', '2015-09-01', '1')," +
                "('Tyson', 'Harbor', '2015-09-01', '1');" +

                "INSERT INTO `Student`(name, surname, enrolment_date, group_id) " +
                "VALUES " +
                "('Thurman', 'Hokanson', '2013-11-24', '2')," +
                "('Davis', 'Janelle', '2014-10-10', '2');" +

                "INSERT INTO `Student`(name, surname, enrolment_date, group_id) " +
                "VALUES " +
                "('Thurman', 'Hokanson', '2015-11-24', '3')," +
                "('Davis', 'Janelle', '2013-10-10', '3');" +

                "INSERT INTO `Student`(name, surname, enrolment_date) " +
                "VALUES " +
                "('Thurman', 'Hokanson', '2015-11-24');";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(SQL_INSERT_DATA);
        statement.close();
    }
}
