package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for manage persistence of {@link Group}. Contains basic CRUD operations.
 */
public interface GroupDao {

    Group create() throws SQLException;

    Group read(int key) throws SQLException;

    void update(Group group) throws SQLException;

    void delete(Group group) throws SQLException;

    List<Group> getAll() throws SQLException;

}
