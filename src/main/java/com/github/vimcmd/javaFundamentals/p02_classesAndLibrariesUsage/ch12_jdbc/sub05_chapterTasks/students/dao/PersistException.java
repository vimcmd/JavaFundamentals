package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

/**
 * DAO pattern itself implies abstraction from data store and for this purpose not limited with relational databases
 * only (data store may be file, nosql db, etc.). Therefore, in general use a java.sql package in unified classes
 * and interfaces highly undesirable. Using own PersistException allows you to not depend on SQLException.
 */
public class PersistException extends Exception {
    public PersistException() {
    }

    public PersistException(String message) {
        super(message);
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

    public PersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
