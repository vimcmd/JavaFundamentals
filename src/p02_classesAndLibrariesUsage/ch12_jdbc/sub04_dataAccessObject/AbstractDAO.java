package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/* # 7 # common methods to interact with data model */

/**
 * The top of DAO hierarchy (also may be interface). Typically, this is set of CRUD/SCRUD methods.
 * DAO is a layer between application and database. DAO abstracts business-entities and abstracts them on database record.
 *
 * @param <K> describes key in table (in very rare cases, table may not contain primary key)
 * @param <T> describes common system business-entity
 */
public abstract class AbstractDAO<K, T extends Entity> {

    public abstract List<T> findAll();

    public abstract T findEntityById(K id);

    public abstract boolean delete(K id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);

    // this class also may contain methods for close connection/statement and return it to pool
    // close(Statement st)
    // close(Connection cn)

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // or trace log
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // exception generation because pool working are broke
        }
    }

}
