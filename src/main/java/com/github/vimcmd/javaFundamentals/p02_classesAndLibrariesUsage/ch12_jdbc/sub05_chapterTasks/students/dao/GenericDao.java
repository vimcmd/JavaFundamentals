package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Unified interface for manage objects persistent state
 *
 * @param <T>  type of persistence object
 * @param <PK> primary key type
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {

    /**
     * Creates new entry and returns corresponding domain object
     *
     * @return domain object
     * @throws SQLException
     */
    T create() throws PersistException;

    /**
     * Creates new entry corresponding to domain object
     *
     * @param obj domain object
     * @return domain object
     * @throws SQLException
     */
    T persist(T obj) throws PersistException;

    /**
     * Find entry corresponding to domain object by primary key
     *
     * @param key entity primary key
     * @return domain object if found, else null
     * @throws SQLException
     */
    T getByPk(int key) throws PersistException;

    /**
     * Update entry corresponding to domain object state
     *
     * @param obj domain object
     * @throws SQLException
     */
    void update(T obj) throws PersistException;

    /**
     * Delete entry corresponding to domain object from database
     *
     * @param obj domain object
     * @throws SQLException
     */
    void delete(T obj) throws PersistException;

    /**
     * Get all entries from database
     *
     * @return list of domain objects
     * @throws SQLException
     */
    List<T> getAll() throws PersistException;

}
