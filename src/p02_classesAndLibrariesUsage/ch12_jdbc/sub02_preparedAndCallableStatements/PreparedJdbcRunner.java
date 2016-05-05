package p02_classesAndLibrariesUsage.ch12_jdbc.sub02_preparedAndCallableStatements;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* # 5 # adding few records to DB */

public class PreparedJdbcRunner {
    public static void main(String[] args) {
        List<Abonent> abonents = new ArrayList<Abonent>();
        for(int i = 1; i < 100; i++) {
            abonents.add(new Abonent(i, String.valueOf(new Random().nextInt(99999999)), UUID.randomUUID().toString()));
        }

        DBHelper helper = null;
        PreparedStatement preparedStatement = null;

        try {
            helper = new DBHelper();
            preparedStatement = helper.getPreparedStatement();
            for(Abonent abonent : abonents) {
                helper.insertAbonent(preparedStatement, abonent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeStatement(preparedStatement);
        }
    }
}
