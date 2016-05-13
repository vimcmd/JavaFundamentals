package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.AbstractJdbcDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.PersistException;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class H2GroupDao extends AbstractJdbcDao<Group, Integer> {

    public H2GroupDao(Connection connection) {
        super(connection);
    }

    @Override
    public Group create() throws PersistException {
        Group g = new Group();
        return persist(g); // update reference to object
    }

    @Override
    public String getSelectQuery() {
        return "SELECT ID, NUMBER, DEPARTMENT FROM `GROUP`";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO `GROUP`(NUMBER, DEPARTMENT) VALUES(?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `GROUP` SET NUMBER=?, DEPARTMENT=? WHERE ID=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `GROUP` WHERE ID=?";
    }

    @Override
    protected List<Group> parseResultSet(ResultSet rs) throws PersistException {
        List<Group> result = new ArrayList<>();
        try {
            while (rs.next()) {
                PersistGroup group = new PersistGroup(); // point of Group implementation substitution (for id injecting)
                group.setId(rs.getInt("id"));
                group.setNumber(rs.getInt("number"));
                group.setDepartment(rs.getString("department"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement ps, Group obj) throws PersistException {
        try {
            ps.setInt(1, obj.getNumber());
            ps.setString(2, obj.getDepartment());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement ps, Group obj) throws PersistException {
        try {
            ps.setInt(1, obj.getNumber());
            ps.setString(2, obj.getDepartment());
            ps.setInt(3, obj.getId()); // responds for 'WHERE id=?' part
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement ps, Group obj) throws PersistException {
        // will be duplicated in every dao implementation, because we can not receive id (PK) in AbstractJdbcDao
        try {
            ps.setInt(1, obj.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    /**
     * Class for substitute implementation of original Group
     */
    private class PersistGroup extends Group {
        @Override
        public void setId(Integer id) {
            super.setId(id);
        }
    }
}
