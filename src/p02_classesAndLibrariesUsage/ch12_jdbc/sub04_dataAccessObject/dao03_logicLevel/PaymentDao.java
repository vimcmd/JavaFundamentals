package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao03_logicLevel;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.sql.Connection;
import java.util.List;

/* # 14.2 # approximate DAO realization */

public class PaymentDao extends AbstractDao<Payment> {


    public PaymentDao(Connection connection) {
        super(connection);
    }

    // methods realization

    @Override
    public List<Abonent> findAll() {
        return null;
    }

    @Override
    public Payment findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Payment entity) {
        return false;
    }

    @Override
    public boolean create(Payment entity) {
        return false;
    }

    @Override
    public boolean update(Payment entity) {
        return false;
    }
}
