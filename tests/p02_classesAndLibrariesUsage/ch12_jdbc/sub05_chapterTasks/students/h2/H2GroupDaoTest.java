package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import org.junit.Assert;
import org.junit.Test;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.DaoFactory;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.GroupDao;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;

import java.sql.Connection;
import java.util.List;

public class H2GroupDaoTest {

    @Test
    public void testGetAll() throws Exception {
        DaoFactory daoFactory = new H2DaoFactory();
        List<Group> groups;

        try (Connection connection = daoFactory.getConnection()) {
            GroupDao groupDao = daoFactory.getGroupDao(connection);
            groups = groupDao.getAll(); // some data must be filled
        }

        Assert.assertNotNull(groups);
        Assert.assertTrue(groups.size() > 0);
        //System.out.println(groups);
    }
}