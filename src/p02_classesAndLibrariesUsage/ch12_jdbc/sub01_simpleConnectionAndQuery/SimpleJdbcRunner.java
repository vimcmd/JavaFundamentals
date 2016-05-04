package p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery;

import java.sql.*;
import java.util.ArrayList;

/* # 1 # simple connection with DB and simple query */

public class SimpleJdbcRunner {

    /*
    Steps for execute first query:
    1. Add driver library to project (H2 in this case) and register it (DriverManager.registerDriver())
    2. Establish connection with database (DriverManager.getConnection())
        - in the JDBC 4.1 loading the database driver class in the absence of a reference to an instance of this class
            is done automatically when connecting instance via DriverManager
        - before JDBC 4.0 driver must be specified explicitly:
            Class.forName("org.h2.Driver()") or DriverManager.registerDriver(new org.h2.Driver())
    3. Create an object for request transmission (class Statement/PreparedStatement/CallableStatement)
    4. Execute query (Statement.execute*()) and put result to ResultSet
    5. Processing results of the query (using methods of interface ResultSet)
        - navigating through result table via next(), previous(), etc.
        - accessing data via getString(), getInt(), etc.
            (also getClob() and getBlob() - allow extract specific data (Character Large Object and Binary Large Object)
            from fields - for ex. image or archive)
    6. Close connection, Statement
        After the database is no longer needed, connection is closed:
        - statement.close() - also closes resultSet
        - connection.close()
     */

    public static void main(String[] args) {

        // IMPORTANT: do not forget run H2 Console (embedded DB)
        // h2-1.3.176 lib used
        Connection cn = null;
        try { // 1st block: Connection
            //DriverManager.registerDriver(new org.h2.Driver());  // JDBC 4.0 auto-loading driver class
            cn = ConnectorDB.getConnection();
            Statement st = null;

            try { // 2nd block: Statement and ResultSet
                st = cn.createStatement();
                ResultSet rs = null;
                ResultSetMetaData resultSetMetaData = null;
                DatabaseMetaData databaseMetaData = null;

                try { //3rd block: query
                    // some data already added to db via H2 console
                    rs = st.executeQuery("SELECT * FROM phonebook");

                    // example of DatabaseMetaData
                    databaseMetaData = cn.getMetaData();
                    System.out.println("-- Database metadata:");
                    System.out.println("DB name: " + databaseMetaData.getDatabaseProductName());
                    System.out.println("DB version: " + databaseMetaData.getDatabaseProductVersion());
                    System.out.println("DB driver: " + databaseMetaData.getDriverName());
                    System.out.println("DB user: " + databaseMetaData.getUserName());
                    System.out.println("DB url: " + databaseMetaData.getURL());

                    // example of ResultSetMetaData
                    resultSetMetaData = rs.getMetaData();
                    System.out.println("-- ResultSet metadata:");
                    System.out.println("Columns: " + resultSetMetaData.getColumnCount());
                    if (resultSetMetaData.getColumnCount() > 0) {
                        for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                            System.out.println("Column " + i + ": " + resultSetMetaData.getColumnLabel(i) + "(" + resultSetMetaData.getColumnTypeName(i) + ")");
                        }
                    }

                    // get data from table
                    ArrayList<Abonent> list = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int phone = rs.getInt(2);
                        String name = rs.getString(3);
                        list.add(new Abonent(id, phone, name));
                    }

                    if (list.size() > 0) {
                        System.out.println("-- Values:");
                        list.forEach(System.out::println);
                    } else {
                        System.out.println("Not found or empty");
                    }

                } finally { // for 3rd block
                    // close ResultSet if it opened or error occurred when reading data
                    if (rs != null) {
                        rs.close();
                    } else {
                        System.err.println("Error occurred while reading from DB");
                    }
                }
            } finally { // for 2nd block
                // close statement
                if (st != null) {
                    st.close();
                } else {
                    System.err.println("Statement not created");
                }
            }

        } catch (SQLException e) { // for 1st block
            System.err.println("DB connection error: " + e); // print all SQLException errors
            //e.printStackTrace();
        } finally {
            // close connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Connection close error: " + e);
                }
            }
        }

    }
}
