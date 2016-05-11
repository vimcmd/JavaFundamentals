package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld;

import java.sql.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class WrapperConnector {

    private Connection connection;

    public WrapperConnector() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("properties.database-fileSystem");
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

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
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

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.connection.setAutoCommit(autoCommit);
    }

    public void commit() throws SQLException {
        this.connection.commit();
    }
}
