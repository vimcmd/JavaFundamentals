package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub15_exchangeLocks;

import java.util.concurrent.Exchanger;

/* # 30 # contains Exchanger and provides the basis for exchanger and consumer */

public class Subject {
    protected static Exchanger<Item> exchanger = new Exchanger<>();
    protected Item item;
    private String name;

    public Subject(String name, Item item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
