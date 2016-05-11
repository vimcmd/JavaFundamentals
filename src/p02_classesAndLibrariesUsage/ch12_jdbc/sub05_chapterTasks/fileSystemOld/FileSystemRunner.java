package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.directory.DirectoryDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.directory.DirectoryEntity;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.file.FileDao;

import java.sql.SQLException;

public class FileSystemRunner {
    public static void main(String[] args) throws SQLException {
        long start = System.currentTimeMillis();
        //Connection connection = DbConnector.getConnection();

        WrapperConnector wrapperConnector = new WrapperConnector();
        wrapperConnector.setAutoCommit(false);

        DbHelper dbHelper = new DbHelper(wrapperConnector);
        dbHelper.recreateTables();

        FileDao fileDao = new FileDao(wrapperConnector);
        DirectoryDao dirDao = new DirectoryDao(wrapperConnector);


        DirectoryEntity root = new DirectoryEntity("ROOT");

        DirectoryEntity subRoot = new DirectoryEntity(root, "subroot");

        dirDao.createEntity(root);
        dirDao.createEntity(subRoot);

        //FileDao.createFile("root\\subroot\\whoa\\newfile", "\\\\", 3465245);
        //dbHelper.createFile("root\\brandNewFile", "\\\\", 123);

        wrapperConnector.commit();
        wrapperConnector.closeConnection();
        System.out.println(( System.currentTimeMillis() - start ) + " ms");
    }
}
