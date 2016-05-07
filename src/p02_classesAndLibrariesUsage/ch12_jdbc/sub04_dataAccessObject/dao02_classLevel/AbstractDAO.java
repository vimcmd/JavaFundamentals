package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao02_classLevel;

import java.sql.Statement;

/* # 10 # DAO with Connection field */

/**
 * Class level DAO means usage one connection to database for invoke few (different) methods in concrete DAO class.
 * In this case abstract DAO class in top of hierarchy besides standard CRUD methods can declare Connection to database
 * or its wrapper.
 */
public abstract class AbstractDAO {
    protected WrapperConnector connector;
    // CRUD methods

    // methods to close connection and statement

    /**
     * closing connection
     */
    public void close() {
        connector.closeConnection();
    }

    protected void closeStatement(Statement statement) {
        connector.closeStatement(statement);
    }
}
