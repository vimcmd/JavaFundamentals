package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.directory;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld.Entity;

public class DirectoryEntity extends Entity {
    private DirectoryEntity parentDirectory;
    private String directoryName;

    public DirectoryEntity() {
    }

    @Override
    public String getPath() {
        // TODO: 10.05.2016 implement method
        return null;
    }

    public DirectoryEntity(DirectoryEntity parentDirectory, String directoryName) {
        //super(id);
        this.parentDirectory = parentDirectory;
        this.directoryName = directoryName;
    }

    public DirectoryEntity(String directoryName) {
        //this.parentDirectory = ROOT
        this.directoryName = directoryName;
    }

    public DirectoryEntity getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(DirectoryEntity parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        // TODO: 10.05.2016 check if this name already exists under parent
        this.directoryName = directoryName;
    }

    @Override
    public String toString() {
        return "DirectoryEntity {id=" + getId() +
                ", parentDirectory='" + parentDirectory +
                "', directoryName='" + directoryName + '}';
    }
}
