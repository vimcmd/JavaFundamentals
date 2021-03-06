package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

import java.io.Serializable;

/* base entity parent class */

public class Entity implements Serializable, Cloneable {
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
}
