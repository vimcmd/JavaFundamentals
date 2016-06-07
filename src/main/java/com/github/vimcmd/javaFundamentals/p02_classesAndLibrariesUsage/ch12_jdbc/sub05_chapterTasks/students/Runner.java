package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.PersistException;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2.H2DaoFactory;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2.H2GroupDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException, PersistException {

        H2DaoFactory h2DaoFactory = new H2DaoFactory();

        recreateTables(h2DaoFactory.getContext());

        try {
            h2DaoFactory.getContext().setAutoCommit(false);
            // abstract jdbc dao
            H2GroupDao groupDao = (H2GroupDao) h2DaoFactory.getDao(h2DaoFactory.getContext(), Group.class);

            System.out.println(groupDao.getAll());

            Group gr = groupDao.create();
            gr.setDepartment("brand new department for hipsters");
            gr.setNumber(102834);
            groupDao.update(gr);
            System.out.println("Gr id=" + gr.getId());
            groupDao.getByPk(gr.getId());

            System.out.println(groupDao.getAll());
            h2DaoFactory.getContext().rollback();
            h2DaoFactory.getContext().close();

        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    private static void recreateTables(Connection connection) {
        DbHelper dbHelper = new DbHelper(connection);
        try {
            dbHelper.recreateTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
