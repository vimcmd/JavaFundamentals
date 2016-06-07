package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

public class SimpleDirectory extends Entity {
    private Integer parent_id;
    private String name;

    public SimpleDirectory() {
    }

    public SimpleDirectory(int parent_id, String name) {
        //super(id);
        this.parent_id = parent_id;
        this.name = name;
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

    @Override
    public String toString() {
        return "SimpleDirectory {id=" + getId() +
                ", parent_id=" + parent_id +
                ", name='" + name + '}';
    }
}
