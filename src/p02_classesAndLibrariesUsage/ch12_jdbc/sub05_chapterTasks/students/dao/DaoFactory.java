package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory for working with database
 */
public interface DaoFactory<T> {

    /**
     * @return Connection to database
     * @throws PersistException
     */
    T getContext() throws PersistException; // in case of JDBC context will be a Connection

    /**
     * Returns object for manage persist state
     * @param context target connection with storage
     * @param dtoClass target domain class
     * @return object for manage persist state
     * @throws PersistException
     */
    GenericDao getDao(T context, Class dtoClass) throws PersistException;

}
