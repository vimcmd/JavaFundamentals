package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub03_transactions;

import java.sql.*;

/* # 6 # money transfer (from one account to another) transaction */

public class SingletonEngine {

    // tables already created via H2 Console with (table_from example):
    // create table table_from(balance int primary key);
    // insert into table_from values(500);

    private static Connection connectionTo;
    private static Connection connectionFrom;
    private static SingletonEngine instance = null;

    // make sure embedded H2 created files with extension *.h2.db (older driver version makes *.mv.db)
    public synchronized static SingletonEngine getInstance() {
        if (instance == null) {
            instance = new SingletonEngine();
            connectionTo = instance.getConnectionTo();
            connectionFrom = instance.getConnectionFrom();
        }
        return instance;
    }

    private Connection getConnectionFrom() {
        final String urlFrom = "jdbc:h2:~/testFrom";
        try {
            //Class.forName("org.h2.Driver"); // or use DriverManager.registerDriver(), or since JDBC 4.0 supported auto-loading
            connectionFrom = DriverManager.getConnection(urlFrom, "root", "pass");
            connectionFrom.setAutoCommit(false); // group queries, and only after make operation COMMIT
        } catch (SQLException e) {
            System.err.println("SQLException (connFrom): " + e.getMessage() + "\nSQLState: " + e.getSQLState());
        }
        return connectionFrom;
    }

    private Connection getConnectionTo() {
        final String urlTo = "jdbc:h2:~/testTo";
        try {
            //Class.forName("org.h2.Driver");
            connectionTo = DriverManager.getConnection(urlTo, "root", "pass");
            connectionTo.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("SQLException (connTo): " + e.getMessage() + "\nSQLState: " + e.getSQLState());
        }
        return connectionTo;
    }

    public void transfer(String amount) throws SQLException {
        Statement stFrom = null;
        Statement stTo = null;
        try {
            int sum = Integer.parseInt(amount);
            if (sum <= 0) {
                throw new NumberFormatException("Less or equal zero");
            }

            stFrom = connectionFrom.createStatement();
            stTo = connectionTo.createStatement();

            // transaction contains 4 queries
            ResultSet rsFrom = stFrom.executeQuery("SELECT balance FROM table_from");
            ResultSet rsTo = stTo.executeQuery("SELECT balance FROM table_to");

            int accountFrom = 0;
            while (rsFrom.next()) {
                accountFrom = rsFrom.getInt(1);
            }

            int resultFrom = 0;
            if (accountFrom >= sum) {
                resultFrom = accountFrom - sum;
            } else {
                throw new SQLException("Invalid balance");
            }

            int accountTo = 0;
            while (rsTo.next()) {
                accountTo = rsTo.getInt(1);
            }

            int resultTo = accountTo + sum;

            stFrom.executeUpdate("UPDATE table_from SET balance=" + resultFrom);
            stTo.executeUpdate("UPDATE table_to SET balance=" + resultTo);

            // end of transaction
            connectionFrom.commit();
            connectionTo.commit();
            System.out.println("Remaining on: " + resultFrom + " rub");
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState() + "\nError message: " + e.getMessage());
            // rollback transaction if errors occurred
            connectionFrom.rollback();
            connectionTo.rollback();
        } catch (NumberFormatException e) {
            System.err.println("Invalid sum: " + amount);
        } finally {
            if (stFrom != null) {
                try {
                    stFrom.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stTo != null) {
                try {
                    stTo.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
