package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld;

import java.io.Serializable;

/* base entity parent class */

public abstract class Entity implements Serializable, Cloneable {
    private Integer id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getPath();
}
