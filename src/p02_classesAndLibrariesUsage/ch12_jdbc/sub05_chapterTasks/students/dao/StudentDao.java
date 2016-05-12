package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for manage persistence of {@link Student}. Contains basic CRUD operations.
 */
public interface StudentDao {

    Student create() throws SQLException;

    Student read(int key) throws SQLException;

    void update(Student student) throws SQLException;

    void delete(Student student) throws SQLException;

    List<Student> getAll() throws SQLException;
}
