package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao02_classLevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* # 12 # connection wrapper class */

public class WrapperConnector {
    private Connection connection;

    public WrapperConnector() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("properties.database-phonebook");
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (MissingResourceException e) {
            System.err.println("properties file is missing " + e);
        } catch (SQLException e) {
            System.err.println("SQL exception (connection not obtained): " + e);
        }
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("statement closing error");
            }
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("connection closing error");
            }
        }
    }

    // other necessary delegated methods from Connection interface
}
