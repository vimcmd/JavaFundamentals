package p02_classesAndLibrariesUsage.ch11_threads.sub15_exchangeLocks;

/* # 33 # description of goods */

public class Item {
    private Integer id;
    private Integer number;

    public Item(Integer id, Integer number) {
        super();
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
