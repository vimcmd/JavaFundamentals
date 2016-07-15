package com.github.vimcmd.javaFundamentals.p11_hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

// # 1 # Entity POJO-class

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student",
            joinColumns = {@JoinColumn(name = "COURSE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")})
    private Set<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public Course(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", students=" + students + '}';
    }
}
