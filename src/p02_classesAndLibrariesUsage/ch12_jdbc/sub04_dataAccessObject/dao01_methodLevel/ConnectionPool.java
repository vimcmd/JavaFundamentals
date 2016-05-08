package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao01_methodLevel;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/* # 9 # standard connection pool */

/**
 * Features, configuration and usage of standard connection pool will be discussed
 * in the end of chapter 16 (Java Server Pages)
 */
public class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc/phonebook";
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    /**
     * just for explicit visibility
     * will produce NoInitialContextException
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }


    /**
     * just for explicit visibility
     * method to return connection to pool
     * will produce NoInitialContextException
     * @param connection
     */
    public static void close(Connection connection) {
        // close connection and return it to pool
    }
}
