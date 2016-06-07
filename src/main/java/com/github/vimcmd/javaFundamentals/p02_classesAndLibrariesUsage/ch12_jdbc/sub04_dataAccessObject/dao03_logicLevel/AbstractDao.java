package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao03_logicLevel;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/* # 13 # DAO with Connection field without direct initialization (just injection) */

/**
 * In practice, often needs use only one connection to database while invoking different DAO layers.
 * In this case, connection was created and extracted from connection pool before all DAO instances initialized, and
 * closed, of course, after all needed database queries are executed.
 * @param <T>
 */
public abstract class AbstractDao <T extends Entity>{
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll();

    public abstract T findEntityById(int id);

    public abstract boolean delete(int id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract boolean update(T entity);

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (can not close statement): " + e);
            // logging
        }
    }
}
