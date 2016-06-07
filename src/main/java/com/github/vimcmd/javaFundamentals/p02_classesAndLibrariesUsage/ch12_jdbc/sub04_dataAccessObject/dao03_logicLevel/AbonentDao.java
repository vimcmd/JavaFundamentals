package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao03_logicLevel;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* # 14.1 # approximate DAO realization */

public class AbonentDao extends AbstractDao<Abonent> {

    public AbonentDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Abonent> findAll() {
        List<Abonent> abonents = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PHONEBOOK");

            while (rs.next()) {
                abonents.add(new Abonent(rs.getInt("id"), rs.getString("phone"), rs.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonents;
    }


    // other methods realization

    @Override
    public Abonent findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Abonent entity) {
        return false;
    }

    @Override
    public boolean create(Abonent entity) {
        return false;
    }

    @Override
    public boolean update(Abonent entity) {
        return false;
    }
}
