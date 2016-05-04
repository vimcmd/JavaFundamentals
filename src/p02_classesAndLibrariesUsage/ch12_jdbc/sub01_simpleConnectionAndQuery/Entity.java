package p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery;

import java.io.Serializable;

public class Entity implements Serializable, Cloneable {
    private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
