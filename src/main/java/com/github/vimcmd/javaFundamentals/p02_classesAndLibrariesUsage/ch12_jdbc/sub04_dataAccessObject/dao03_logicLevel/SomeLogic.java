package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao03_logicLevel;

import com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao01_methodLevel.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/* # 15 # DAO usage on logic level */

public class SomeLogic {
    public void doLogic(int id) throws SQLException {
        // 1. create pool and retrieve connection
        Connection connection = ConnectionPool.getConnection();

        // 2. open transaction
        connection.setAutoCommit(false);

        // 3. initialize needed DAO
        AbonentDao abonentDao = new AbonentDao(connection);
        PaymentDao paymentDao = new PaymentDao(connection);

        // 4. execute queries
        abonentDao.findAll();
        abonentDao.findEntityById(2);
        paymentDao.delete(17);

        // 5. close transaction
        connection.commit();

        // 6. close statement and return connection to pool
        ConnectionPool.close(connection);
    }
}
