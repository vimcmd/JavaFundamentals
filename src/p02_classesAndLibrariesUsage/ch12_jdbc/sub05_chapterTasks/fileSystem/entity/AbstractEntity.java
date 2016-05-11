package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity;

public abstract class AbstractEntity {
    private AbstractEntity parent = null;
    private String name;

    public AbstractEntity(String name) {
        checkName(name);
        this.name = name;
    }

    protected void checkName(String name) {
        // FIXME: 11.05.2016 check name mathces pattern
        final String forbiddenChars = "\\/:*?\"<>|";
        if (name.matches(forbiddenChars)) {
            throw new IllegalArgumentException("Incorrect name: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public AbstractEntity getParent() {
        return parent;
    }

    public void setParent(AbstractEntity parent) {
        this.parent = parent;
    }

    public String getAbsolutePath() {
        StringBuilder sb = new StringBuilder();
        AbstractEntity parentDir = this.getParent();

        sb.insert(0, this.getName());
        sb.insert(0, System.getProperty("file.separator"));

        while (parentDir != null) {
            sb.insert(0, parentDir.getName());
            sb.insert(0, System.getProperty("file.separator"));
            parentDir = parentDir.getParent();
        }
        return sb.toString();
    }
}
