package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity;

public class FileEntity extends AbstractEntity {
    private long fileSize;

    public FileEntity(String name, long fileSize) {
        super(name);
        this.fileSize = fileSize;
    }

    @Override
    public String getAbsolutePath() {
        return super.getAbsolutePath() + " (size: " + fileSize + ")";
    }
}
