package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.directory;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.AbstractDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.WrapperConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DirectoryDao extends AbstractDao<DirectoryEntity> {

    public DirectoryDao(WrapperConnector wrapperConnector) {
        super(wrapperConnector);
    }

    @Override
    public List<DirectoryEntity> findAll() {
        return null;
    }

    @Override
    public DirectoryEntity findEntityById(int id) {
        return null;
    }

    @Override
    public boolean createEntity(DirectoryEntity parentDirectory) {
        ////boolean created = false;
        //final String SQL_INSERT_DIR = "INSERT INTO DIRECTORIES(FK_PARENT_DIR_ID, NAME) VALUES (?, ?)";
        //final String SQL_SELECT_DIR = "SELECT subdir.* FROM DIRECTORIES subdir INNER JOIN DIRECTORIES parent ON subdir.FK_PARENT_DIR_ID=parent.PK_DIR_ID WHERE parent.PK_DIR_ID=? AND subdir.NAME=?";
        //int currentDirId = 1; // link to root '.' directory
        ////DirectoryEntity currentDirectory = ROOT;
        //
        //
        //
        //if (path.equals("")) {
        //    // TODO: 08.05.2016 escape special symbols in path
        //    return currentDirId;
        //}
        //
        //System.err.println("directories PATH: " + parentDirectory.getPath()); // debug
        //
        //List<String> directories = Arrays.asList(path.split(delimiter));
        //PreparedStatement findSubdirInParent = wrapperConnector.getPreparedStatement(SQL_SELECT_DIR);
        //PreparedStatement insertDir = wrapperConnector.getPreparedStatement(SQL_INSERT_DIR);
        //
        //for(String dir : directories) {
        //    // process others directories (first parent id already set up):
        //    // find same name dirs in parent (cursor id)
        //    // if not exists, create and set cursor id
        //    // else set cursor id and pass
        //
        //    try {
        //        findSubdirInParent.setInt(1, currentDirId);
        //        findSubdirInParent.setString(2, dir);
        //        findSubdirInParent.execute();
        //        ResultSet subDirInParent = findSubdirInParent.getResultSet();
        //
        //        if (!subDirInParent.isBeforeFirst()) { // (isBeforeFirst() support is optional)
        //            // if parent not contains dir,
        //            // create it
        //            insertDir.setInt(1, currentDirId);
        //            insertDir.setString(2, dir);
        //            insertDir.execute();
        //
        //            // search again and move cursor
        //            findSubdirInParent.execute();
        //            subDirInParent = findSubdirInParent.getResultSet();
        //            subDirInParent.next();
        //            currentDirId = subDirInParent.getInt("PK_DIR_ID");
        //            System.err.println("directory CREATED '" + dir + "' with id=" + currentDirId); // debug
        //
        //        } else {
        //            subDirInParent.next();
        //            currentDirId = subDirInParent.getInt("PK_DIR_ID");
        //            System.err.println("directory EXISTS '" + dir + "' with id=" + currentDirId); // debug
        //        }
        //
        //        subDirInParent.close();
        //        //created = true;
        //
        //    } catch (SQLException e) {
        //        e.printStackTrace();
        //    }
        //}
        ////return created;
        //return currentDirId;
        System.err.println("method not implemented");
        return false;
    }

    @Override
    public boolean updateEntity(DirectoryEntity entity) {
        return false;
    }
}
