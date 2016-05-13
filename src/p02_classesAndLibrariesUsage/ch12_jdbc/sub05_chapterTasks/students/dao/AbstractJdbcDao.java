package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Abstract class provides basic CRUD operations using JDBC
 *
 * @param <T>  persistence object type
 * @param <PK> primary key type
 */
public abstract class AbstractJdbcDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Connection connection;

    public AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return sql query to retrieve all entries:
     * <p>SELECT * FROM [Table]</p>
     */
    public abstract String getSelectQuery();

    /**
     * @return sql query to insert new entry to database:
     * <p>INSERT INTO [Table]([column, column, ...]) VALUES(?, ?, ...)</p>
     */
    public abstract String getCreateQuery();

    /**
     * @return sql query to update entry in database:
     * <p>UPDATE [Table] SET column=?, column=?... WHERE id=?</p>
     */
    public abstract String getUpdateQuery();

    /**
     * @return sql query to delete entry in database:
     * <p>DELETE FROM [Table] WHERE id=?</p>
     */
    public abstract String getDeleteQuery();

    /**
     * Parses result set to list of domain objects
     *
     * @param rs target result set
     * @return list of domain objects
     */
    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    /**
     * Set prepared (for insert) statement arguments corresponding to domain object
     *
     * @param ps  target prepared statement
     * @param obj target domain object
     * @see #getCreateQuery()
     */
    protected abstract void prepareStatementForInsert(PreparedStatement ps, T obj) throws PersistException;

    /**
     * Set prepared (for update) statement arguments corresponding to domain object
     *
     * @param ps  target prepared statement
     * @param obj target domain object
     * @throws PersistException
     * @see #getUpdateQuery()
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement ps, T obj) throws PersistException;

    /**
     * Set prepared (for delete) statement arguments corresponding to domain object
     *
     * @param ps  target prepared statement
     * @param obj target domain object
     * @throws PersistException
     * @see #getDeleteQuery()
     */
    protected abstract void prepareStatementForDelete(PreparedStatement ps, T obj) throws PersistException;

    @Override
    public T create() throws PersistException {
        // TODO: 12.05.2016 implement method
        // can not implement for now, because T object constructor unknown
        return null;
    }

    @Override
    public T persist(T obj) throws PersistException {
        T persistInstance;
        // add entry
        String sql = getCreateQuery();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            prepareStatementForInsert(ps, obj);
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify more than one record: " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }

        // get entry, which just added
        // last_insert_id() will return the first id from a multi row insert
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<T> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                throw new PersistException("Exception on findByPk new persist data");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return persistInstance; // different from original object (from argument)
    }

    @Override
    public T getByPk(int key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?"; // may be better create separate method?
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException();
        }
        if (list == null || list.size() == 0) {
            throw new PersistException("Record with PK=" + key + " not found");
        }
        if (list.size() > 1) {
            throw new PersistException("Recieved more than one record");
        }
        return list.iterator().next();
    }

    @Override
    public void update(T obj) throws PersistException {
        String sql = getUpdateQuery();
    }

    @Override
    public void delete(T obj) throws PersistException {
        String sql = getDeleteQuery();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            prepareStatementForDelete(ps, obj); // all implementations must have own prepareStatement*() realization
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete more than 1 row affected: " + count);
            }
            ps.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }
}
