package com.github.vimcmd.javaFundamentals.p11_hibernate.dao;

import com.github.vimcmd.javaFundamentals.p11_hibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

// # 5 # dao-class of interaction with student table

public class StudentDao {

    private Session session;

    public StudentDao(Session session) {
        this.session = session;
    }

    public Student getStudent(String lastName) {
        Student student = null;
        try {
            Query query = session.getNamedQuery("findStudentByLastName");
            query.setParameter("lastName", lastName);
            student = (Student) query.uniqueResult();
            System.out.println(student);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean isStudentExists(String lastName) {
        Student student = null;
        try {
            Query query = session.getNamedQuery("findStudentByLastName");
            query.setParameter("lastName", lastName);
            student = (Student) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return student != null;
    }

    public void addStudent(Student student) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }
    }

    public void deleteStudent(Student student) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.delete(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }
    }

    public void updateStudent(Student student) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(student);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }
    }
}