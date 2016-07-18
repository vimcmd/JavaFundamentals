package com.github.vimcmd.javaFundamentals.p11_hibernate;

import com.github.vimcmd.javaFundamentals.p11_hibernate.dao.CourseDao;
import com.github.vimcmd.javaFundamentals.p11_hibernate.dao.StudentDao;
import com.github.vimcmd.javaFundamentals.p11_hibernate.entity.Course;
import com.github.vimcmd.javaFundamentals.p11_hibernate.entity.Student;
import com.github.vimcmd.javaFundamentals.p11_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class StudentCourseSimpleDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            StudentDao studentDao = new StudentDao(session);
            CourseDao courseDao = new CourseDao(session);

            final String courseTitle1 = "Java";
            final String courseTitle2 = "Design patterns for Java";

            Course course1 = new Course(courseTitle1);
            HashSet<Student> set1 = new HashSet<Student>(){
                {
                    this.add(new Student("Ivanov", "Vitalii"));
                    this.add(new Student("Petov", "Sergey"));
                    this.add(new Student("Sidorov", "Innokentiy"));
                }
            };
            course1.setStudents(set1);
            courseDao.addCourse(course1);

            Course course2 = new Course(courseTitle2);
            courseDao.addCourse(course2);

            Set<Student> setRes = courseDao.findRegisteredOnCourse(courseTitle1);

            Student student1 = new Student("Alekseeva", "Alina");
            studentDao.addStudent(student1);

            System.out.println(setRes);

            Student student2 = studentDao.getStudent("Ivanov");
            System.out.println(student2);

            HashSet<Student> set2 = new HashSet<>();
            set2.add(student1);
            set2.add(student2);
            course2.setStudents(set2);
            courseDao.addCourse(course2);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}
