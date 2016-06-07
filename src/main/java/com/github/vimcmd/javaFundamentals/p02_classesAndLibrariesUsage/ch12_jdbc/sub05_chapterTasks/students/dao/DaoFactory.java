package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory for working with database
 */
public interface DaoFactory<T> {

    /**
     * Context - entity, describing session of interaction with data store system. In JDBC case, Connection acting
     * as context.
     * @return Connection to database
     * @throws PersistException
     */
    T getContext() throws PersistException;

    /**
     * Returns object for manage persist state
     * @param context target connection with storage
     * @param dtoClass target domain class
     * @return object for manage persist state
     * @throws PersistException
     */
    GenericDao getDao(T context, Class dtoClass) throws PersistException;

}
