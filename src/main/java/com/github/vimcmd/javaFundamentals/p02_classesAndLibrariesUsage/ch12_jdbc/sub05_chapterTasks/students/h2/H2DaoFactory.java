package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.h2;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.DaoFactory;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.GenericDao;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao.PersistException;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Group;
import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.domain.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class H2DaoFactory implements DaoFactory<Connection> {


    private Map<Class, DaoCreator> creators;
    private String url;
    private String user;
    private String pass;
    private String driver;


    public H2DaoFactory() {
        ResourceBundle resource = ResourceBundle.getBundle("properties.database_students");
        url = resource.getString("db.url");
        user = resource.getString("db.user");
        pass = resource.getString("db.password");
        driver = resource.getString("db.Driver");

        try {
            Class.forName(driver); // driver registration
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();

        creators.put(Group.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new H2GroupDao(connection);
            }
        });

        creators.put(Student.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new H2StudentDao(connection);
            }
        });
    }

    @Override
    public Connection getContext() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("DAO object for dto class '" + dtoClass + "' not found");
        }
        return creator.create(connection);
    }

    private interface DaoCreator {
        GenericDao create(Connection connection);
    }
}
