package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

public class SimpleFile extends Entity {
    private Integer parent_id;
    private String name;
    private long size;

    public SimpleFile() {
    }

    public SimpleFile(int parent_id, String name, long size) {
        //super(id);
        this.parent_id = parent_id;
        this.name = name;
        this.size = size;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
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
        return "SimpleFile {" + getId() +
                ", parent_id=" + parent_id +
                ", name='" + name +
                ", size=" + size + '}';
    }
}
