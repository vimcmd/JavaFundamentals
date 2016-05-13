package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.AbstractJdbcDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.PersistException;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class H2StudentDao extends AbstractJdbcDao<Student, Integer> {

    public H2StudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT ID, NAME, SURNAME, ENROLMENT_DATE, GROUP_ID FROM `STUDENT`";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO `STUDENT`(ID, NAME, SURNAME, ENROLMENT_DATE, GROUP_ID) VALUES(?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `STUDENT` SET NAME=?, SURNAME=?, ENROLMENT_DATE=?, GROUP_ID=? WHERE ID=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `STUDENT` WHERE ID=?";
    }

    @Override
    public Student create() throws PersistException {
        Student s = new Student();
        return persist(s);
    }

    @Override
    protected List<Student> parseResultSet(ResultSet rs) throws PersistException {
        List<Student> result = new ArrayList<>();
        try {
            while (rs.next()) {
                PersistStudent student = new PersistStudent();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setEnrolmentDate(rs.getDate("enrolment_date"));
                student.setGroupId(rs.getInt("group_id"));
                result.add(student);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement ps, Student obj) throws PersistException {
        try {
            java.sql.Date sqlDate = convertDate(obj.getEnrolmentDate());
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getSurname());
            ps.setDate(4, sqlDate);
            ps.setInt(5, obj.getGroupId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement ps, Student obj) throws PersistException {
        try {
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setDate(3, convertDate(obj.getEnrolmentDate()));
            ps.setInt(4, obj.getGroupId());
            ps.setInt(5, obj.getId()); // WHERE id=?
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    private java.sql.Date convertDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    private class PersistStudent extends Student {

        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }

}
