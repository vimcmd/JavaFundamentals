package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;


import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DbHelper {

    private WrapperConnector wrapperConnector;

    public DbHelper(WrapperConnector wrapperConnector) {
        this.wrapperConnector = wrapperConnector;
    }

    public void recreateTables() throws SQLException {
        wrapperConnector.setAutoCommit(false);
        dropTables();
        createTables();
        wrapperConnector.commit();
    }

    private void dropTables() throws SQLException {
        final String SQL_DROP_TABLES = "DROP TABLE IF EXISTS DIRECTORIES, FILES";
        Statement statement = wrapperConnector.getStatement();
        statement.executeUpdate(SQL_DROP_TABLES);
    }

    /**
     * @throws SQLException
     */
    private void createTables() throws SQLException {
        final String SQL_CREATE_TABLE_DIRECTORIES = "CREATE TABLE directories (" +
                "pk_dir_Id INT AUTO_INCREMENT NOT NULL," +
                "fk_parent_dir_id    INT NOT NULL," +
                "name         VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (pk_dir_Id)," +
                "FOREIGN KEY (fk_parent_dir_id) REFERENCES directories (pk_dir_Id)" +
                ");";
        final String SQL_CREATE_TABLE_FILES = "CREATE TABLE files (" +
                "pk_file_Id INT AUTO_INCREMENT NOT NULL," +
                "fk_parent_dir_id INT NOT NULL," +
                "name      VARCHAR(255) NOT NULL," +
                "size      BIGINT       NOT NULL," +
                "PRIMARY KEY (pk_file_Id)," +
                "FOREIGN KEY (fk_parent_dir_id) REFERENCES directories (pk_dir_Id)" +
                ");";
        final String SQL_CREATE_ROOT_DIRECTORY = "INSERT INTO DIRECTORIES (FK_PARENT_DIR_ID, NAME) VALUES (1, '.')";
        Statement statement = wrapperConnector.getStatement();
        statement.executeUpdate(SQL_CREATE_TABLE_DIRECTORIES);
        statement.executeUpdate(SQL_CREATE_TABLE_FILES);
        statement.executeUpdate(SQL_CREATE_ROOT_DIRECTORY);
        statement.close();
    }
}
