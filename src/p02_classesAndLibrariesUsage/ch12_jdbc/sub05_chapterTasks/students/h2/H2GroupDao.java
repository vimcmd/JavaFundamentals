package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.GroupDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2GroupDao implements GroupDao {
    private final Connection connection;

    public H2GroupDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group create() throws SQLException {
        return null; // not yet implemented
    }

    @Override
    public Group read(int key) throws SQLException {
        final String SQL = "SELECT * FROM `GROUP` WHERE ID=?;";
        PreparedStatement ps = connection.prepareStatement(SQL);

        ps.setInt(1, key);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Group g = new Group();
        g.setId(rs.getInt("id"));
        g.setNumber(rs.getInt("number"));
        g.setDepartment(rs.getString("department"));

        return g;
    }

    @Override
    public void update(Group group) throws SQLException {
        // not yet implemented
    }

    @Override
    public void delete(Group group) throws SQLException {
        // not yet implemented
    }

    @Override
    public List<Group> getAll() throws SQLException {
        final String SQL = "SELECT * FROM `Group`;";
        PreparedStatement ps = connection.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        List<Group> groups = new ArrayList<>();

        while (rs.next()) {
            Group g = new Group();
            g.setId(rs.getInt("id"));
            g.setNumber(rs.getInt("number"));
            g.setDepartment(rs.getString("department"));
            groups.add(g);
        }

        return groups;
    }
}
