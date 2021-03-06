package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.Identified;

import java.util.Date;

/**
 * Object representation of Student entity
 */
public class Student implements Identified<Integer> {
    private int id;
    private String name;
    private String surname;
    private Date enrolmentDate;
    private Integer groupId = null; // relational link to group id (not group object)

    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enrolmentDate=" + enrolmentDate +
                ", groupId=" + groupId +
                '}';
    }
}
