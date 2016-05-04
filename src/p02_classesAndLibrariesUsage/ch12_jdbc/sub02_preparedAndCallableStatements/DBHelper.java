package p02_classesAndLibrariesUsage.ch12_jdbc.sub02_preparedAndCallableStatements;

/* # 4 # prepare query for adding information to database */

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    private static final String SQL_INSERT = "INSERT INTO phonebook(idphonebook, phone, name) VALUES(?, ?, ?)";
    private Connection connection;

    public DBHelper() throws SQLException {
        connection = ConnectorDB.getConnection();
    }

    public PreparedStatement getPreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public boolean insertAbonent(PreparedStatement preparedStatement, Abonent abonent) {
        boolean flag = false;
        try {
            preparedStatement.setInt(1, abonent.getId());
            preparedStatement.setInt(2, abonent.getPhone());
            preparedStatement.setString(3, abonent.getName());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void closeStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
