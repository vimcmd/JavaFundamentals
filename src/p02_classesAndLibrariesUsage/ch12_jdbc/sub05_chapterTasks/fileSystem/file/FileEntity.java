package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.file;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.Entity;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.directory.DirectoryEntity;

public class FileEntity extends Entity {
    private DirectoryEntity parentDirectory;
    private String name;
    private long size;

    public FileEntity() {
    }

    @Override
    public String getPath() {
        // TODO: 10.05.2016 implement method
        return null;
    }

    public FileEntity(DirectoryEntity parentDirectory, String name, long size) {
        //super(id);
        this.parentDirectory = parentDirectory;
        this.name = name;
        this.size = size;
    }

    public DirectoryEntity getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(DirectoryEntity parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileEntity {" + getId() +
                ", parent_id=" + parentDirectory +
                ", name='" + name +
                ", size=" + size + '}';
    }
}
