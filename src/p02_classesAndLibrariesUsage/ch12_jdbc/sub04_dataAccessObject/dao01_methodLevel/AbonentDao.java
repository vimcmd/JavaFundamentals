package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao01_methodLevel;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* # 8 # concrete realization of interaction with data model */

/**
 * DAO realization for concrete business object may be look like this. Part of methods may be unrealized, besides
 * may be added own methods, which definition in parent (common) class was impossible in case of highly specialization.
 * (In this case findAbonentByName() method)
 */
public class AbonentDao extends AbstractDao<Integer, Abonent> {
    public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM phonebook";
    public static final String SQL_SELECT_ABONENT_BY_NAME = "SELECT * FROM phonebook WHERE name=?";

    @Override
    public List<Abonent> findAll() {
        List<Abonent> abonents = new ArrayList<>();
        Connection cn = null;
        Statement st = null;

        try {
            //cn = ConnectionPool.getConnection(); // will produce NoInitialContextException
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (rs.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(rs.getInt("id"));
                abonent.setPhone(rs.getString("phone"));
                abonent.setName(rs.getString("name"));
                abonents.add(abonent);
            }
        } catch (SQLException e) {
            System.err.println("SQLException (request or table error): " + e);
        } finally {
            //close(st);
            close(cn);
            // code to return connection to pool
        }
        return abonents;
    }

    @Override
    public Abonent findEntityById(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Abonent entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Abonent entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Abonent update(Abonent entity) {
        throw new UnsupportedOperationException();
    }

    // own DAO method (found only first occurrence)
    public Abonent findAbonentByName(String name) {
        Abonent abonent = new Abonent();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            //cn = ConnectionPool.getConnection(); // wil produce NoInitialContextException
            cn = ConnectorDB.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ABONENT_BY_NAME);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            rs.next();
            abonent.setId(rs.getInt("id"));
            abonent.setPhone(rs.getString("phone"));
            abonent.setName(rs.getString("name"));
        } catch (SQLException e) {
            System.err.println("SQLException (request or table error): " + e);
        } finally {
            //close(st);
            close(cn);
            // code to return connection to pool
        }
        return abonent;
    }
}
