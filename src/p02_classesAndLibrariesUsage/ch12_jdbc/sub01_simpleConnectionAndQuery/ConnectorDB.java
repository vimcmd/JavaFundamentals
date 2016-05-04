package p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("properties.database-phonebook");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass); // JDBC 4.0 auto-loading driver class
    }
}
