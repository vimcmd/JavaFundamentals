package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain;


/**
 * Object representation of Group
 */
public class Group {
    private Integer id = null;
    private int number;
    private String department;

    public Integer getId() {
        return id;
    }

    // protected for: using only in DAO (in inherited private class) to prevent modifying from other places
    protected void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", department='" + department + '\'' +
                '}';
    }
}
