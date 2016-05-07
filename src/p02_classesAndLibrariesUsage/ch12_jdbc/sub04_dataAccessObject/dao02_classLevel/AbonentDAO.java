package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao02_classLevel;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* # 11 # DAO on class level */

/**
 * Concrete DAO realization in this interaction way (class level), all methods must never close connection.
 * Connection must be closed in the part of business-logic, from which DAO was called (invoked).
 */
public class AbonentDao extends AbstractDao {
    public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM phonebook";

    public AbonentDao() {
        this.connector = new WrapperConnector();
    }

    public List<Abonent> findAll() {
        List<Abonent> abonents = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connector.getStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (rs.next()) {
                abonents.add(new Abonent(rs.getInt("id"), rs.getString("phone"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            this.closeStatement(statement);
        }
        return abonents;
    }

    // other methods
}
