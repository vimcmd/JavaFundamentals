package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.file;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.AbstractDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.WrapperConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class FileDao extends AbstractDao<FileEntity> {

    public FileDao(WrapperConnector wrapperConnector) {
        super(wrapperConnector);
    }

    @Override
    public List<FileEntity> findAll() {
        return null;
    }

    @Override
    public FileEntity findEntityById(int id) {
        return null;
    }

    @Override
    public boolean createEntity(FileEntity fileEntity) {
        //boolean created = false;
        final String SQL_INSERT_FILE = "INSERT INTO FILES(FK_PARENT_DIR_ID, NAME, SIZE) VALUES(?, ?, ?)";
        final String SQL_FIND_FILE = "SELECT * FROM FILES WHERE FK_PARENT_DIR_ID=? AND NAME=?";
        int createdFileId = -1;

        System.err.println("file PATH: " + fileEntity.getPath()); // debug

        List<String> directoriesWithFile = Arrays.asList(path.split(delimiter));
        String fileName = directoriesWithFile.get(directoriesWithFile.size() - 1);
        String directories = path.substring(0, path.length() - fileName.length());

        int lastDirId = createDir(directories, delimiter);

        PreparedStatement insertFile = wrapperConnector.getPreparedStatement(SQL_INSERT_FILE);
        PreparedStatement findFile = wrapperConnector.getPreparedStatement(SQL_FIND_FILE);

        try {
            findFile.setInt(1, lastDirId);
            findFile.setString(2, fileName);
            findFile.execute();
            ResultSet findFileResultSet = findFile.getResultSet();

            if (!findFileResultSet.isBeforeFirst()) {
                insertFile.setInt(1, fileEntity.getParentDirectory().getId());
                insertFile.setString(2, fileEntity.getName());
                insertFile.setLong(3, fileEntity.getSize());
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

    @Override
    public boolean updateEntity(FileEntity entity) {
        return false;
    }
}
