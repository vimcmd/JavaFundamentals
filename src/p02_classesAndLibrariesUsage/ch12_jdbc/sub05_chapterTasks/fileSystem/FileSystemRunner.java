package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity.DirectoryEntity;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity.FileEntity;

import java.sql.SQLException;

public class FileSystemRunner {
    public static void main(String[] args) throws SQLException {
        long start = System.currentTimeMillis();
        //Connection connection = DbConnector.getConnection();

        //WrapperConnector wrapperConnector = new WrapperConnector();
        //wrapperConnector.setAutoCommit(false);
        //
        //DbHelper dbHelper = new DbHelper(wrapperConnector);
        //dbHelper.recreateTables();
        //
        //wrapperConnector.commit();
        //wrapperConnector.closeConnection();

        DirectoryEntity root = new DirectoryEntity("ROOT");
        DirectoryEntity subRoot = new DirectoryEntity("subroot");
        DirectoryEntity newFolder = new DirectoryEntity("new folder");
        DirectoryEntity newFolder2 = new DirectoryEntity("new folder");
        FileEntity newFile = new FileEntity("readme.txt", 4235234);
        root.addSubDirectory(subRoot);
        subRoot.addSubDirectory(newFolder);
        subRoot.addSubDirectory(newFolder2);
        newFolder.addSubFile(newFile);

        System.out.println(root.getAbsolutePath());
        System.out.println(newFolder.getAbsolutePath());
        System.out.println(newFile.getAbsolutePath());

        System.out.println(( System.currentTimeMillis() - start ) + " ms");
    }
}
