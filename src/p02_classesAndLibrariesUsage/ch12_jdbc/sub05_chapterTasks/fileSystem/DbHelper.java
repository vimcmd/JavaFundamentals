package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;


import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DbHelper {

    private Connection connection;

    public DbHelper(Connection connection) {
        this.connection = connection;
    }

    public void recreateTables() throws SQLException {
        this.connection.setAutoCommit(false);
        dropTables();
        createTables();
        this.connection.commit();
    }

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    private void dropTables() throws SQLException {
        final String SQL_DROP_TABLES = "DROP TABLE IF EXISTS DIRECTORIES, FILES";
        Statement statement = this.connection.createStatement();
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
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(SQL_CREATE_TABLE_DIRECTORIES);
        statement.executeUpdate(SQL_CREATE_TABLE_FILES);
        statement.executeUpdate(SQL_CREATE_ROOT_DIRECTORY);
        statement.close();
    }

    /**
     * @param path
     * @param delimiter
     * @return Id (primary key) of last created directory
     */
    public int createDir(String path, String delimiter) {
        //boolean created = false;
        final String SQL_INSERT_DIR = "INSERT INTO DIRECTORIES(FK_PARENT_DIR_ID, NAME) VALUES (?, ?)";
        final String SQL_SELECT_DIR = "SELECT subdir.* FROM DIRECTORIES subdir INNER JOIN DIRECTORIES parent ON subdir.FK_PARENT_DIR_ID=parent.PK_DIR_ID WHERE parent.PK_DIR_ID=? AND subdir.NAME=?";
        int currentDirId = 1; // link to root '.' directory

        if (path.equals("")) {
            // TODO: 08.05.2016 escape special symbols in path
            return currentDirId;
        }

        System.err.println("directories PATH: " + path); // debug

        List<String> directories = Arrays.asList(path.split(delimiter));
        PreparedStatement findSubdirInParent = getPreparedStatement(SQL_SELECT_DIR);
        PreparedStatement insertDir = getPreparedStatement(SQL_INSERT_DIR);

        for(String dir : directories) {
            // process others directories (first parent id already set up):
            // find same name dirs in parent (cursor id)
            // if not exists, create and set cursor id
            // else set cursor id and pass

            try {
                findSubdirInParent.setInt(1, currentDirId);
                findSubdirInParent.setString(2, dir);
                findSubdirInParent.execute();
                ResultSet subDirInParent = findSubdirInParent.getResultSet();

                if (!subDirInParent.isBeforeFirst()) { // (isBeforeFirst() support is optional)
                    // if parent not contains dir,
                    // create it
                    insertDir.setInt(1, currentDirId);
                    insertDir.setString(2, dir);
                    insertDir.execute();

                    // search again and move cursor
                    findSubdirInParent.execute();
                    subDirInParent = findSubdirInParent.getResultSet();
                    subDirInParent.next();
                    currentDirId = subDirInParent.getInt("PK_DIR_ID");
                    System.err.println("directory CREATED '" + dir + "' with id=" + currentDirId); // debug

                } else {
                    subDirInParent.next();
                    currentDirId = subDirInParent.getInt("PK_DIR_ID");
                    System.err.println("directory EXISTS '" + dir + "' with id=" + currentDirId); // debug
                }

                subDirInParent.close();
                //created = true;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return created;
        return currentDirId;
    }

    /**
     * @param path
     * @param delimiter
     * @param fileSize
     * @return Id (primary key) of last created file. If error occurred, -1 will be returned
     */
    public int createFile(String path, String delimiter, long fileSize) {
        //boolean created = false;
        final String SQL_INSERT_FILE = "INSERT INTO FILES(FK_PARENT_DIR_ID, NAME, SIZE) VALUES(?, ?, ?)";
        final String SQL_FIND_FILE = "SELECT * FROM FILES WHERE FK_PARENT_DIR_ID=? AND NAME=?";
        int createdFileId = -1;

        System.err.println("file PATH: " + path); // debug

        List<String> directoriesWithFile = Arrays.asList(path.split(delimiter));
        String fileName = directoriesWithFile.get(directoriesWithFile.size() - 1);
        String directories = path.substring(0, path.length() - fileName.length());

        int lastDirId = createDir(directories, delimiter);

        PreparedStatement insertFile = getPreparedStatement(SQL_INSERT_FILE);
        PreparedStatement findFile = getPreparedStatement(SQL_FIND_FILE);

        try {
            findFile.setInt(1, lastDirId);
            findFile.setString(2, fileName);
            findFile.execute();
            ResultSet findFileResultSet = findFile.getResultSet();

            if (!findFileResultSet.isBeforeFirst()) {
                insertFile.setInt(1, lastDirId);
                insertFile.setString(2, fileName);
                insertFile.setLong(3, fileSize);
                insertFile.execute();

                // search again
                findFile.execute();
                findFileResultSet = findFile.getResultSet();
                findFileResultSet.next();
                createdFileId = findFileResultSet.getInt("PK_FILE_ID");
                System.err.println("file CREATED '" + fileName + "' with id=" + createdFileId); // debug
            } else {
                findFileResultSet.next();
                createdFileId = findFileResultSet.getInt("PK_FILE_ID");
                System.err.println("file EXISTS '" + fileName + "' with id=" + createdFileId); // debug
            }

            findFileResultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return createdFileId;
    }


}
