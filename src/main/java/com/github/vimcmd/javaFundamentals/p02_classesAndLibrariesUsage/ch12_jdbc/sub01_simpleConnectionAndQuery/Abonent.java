package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery;

/* # 2.2 # class with information */

public class Abonent extends Entity {
    private String phone;
    private String name;

    public Abonent() {
    }

    public Abonent(int id, String phone, String name) {
        super(id);
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Abonent [id=" + getId() + ", phone=" + getPhone() + ", name=" + getName() + "]";
    }
}
