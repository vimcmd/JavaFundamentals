package com.github.vimcmd.javaFundamentals.p11_hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// # 3 # configuration and new session initialization

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // create session factory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();

            // NOTE: if mapped classes not listed in configuration xml,
            // you must explicitly add them to configuration:
            //Configuration conf = new Configuration()
            //        .addAnnotatedClass(Course.class)
            //        .addAnnotatedClass(Student.class);
            //conf.configure();
            //sessionFactory = conf.buildSessionFactory();
        } catch (Throwable e) {
            // make shure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
