package com.github.vimcmd.javaFundamentals.p11_hibernate.dao;

import com.github.vimcmd.javaFundamentals.p11_hibernate.entity.Course;
import com.github.vimcmd.javaFundamentals.p11_hibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

// # 4 # dao-class of interaction with course table

public class CourseDao {

    private Session session;

    public CourseDao(Session session) {
        this.session = session;
    }

    public Set<Student> findRegisteredOnCourse(String courseTitle) {
        Set<Student> registeredOnCourse;
        Query query = session.createQuery("FROM course WHERE title=:title");
        query.setParameter("title", courseTitle);
        Course course = (Course) query.uniqueResult();
        registeredOnCourse = course.getStudents();
        return registeredOnCourse;
    }

    public boolean addCourse(Course course) {
        boolean flag = false;
        Transaction t = null;

        try {
            t = session.beginTransaction();
            session.saveOrUpdate(course);
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }
        return flag;
    }
}
