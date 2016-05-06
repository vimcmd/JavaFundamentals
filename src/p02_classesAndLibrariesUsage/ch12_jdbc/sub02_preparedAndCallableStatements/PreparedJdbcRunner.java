package p02_classesAndLibrariesUsage.ch12_jdbc.sub02_preparedAndCallableStatements;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* # 5 # adding few records to DB */

public class PreparedJdbcRunner {
    public static void main(String[] args) {
        List<Abonent> abonents = new ArrayList<Abonent>();
        List<String> names = Arrays.asList("Phyliss Havener", "Anisha Mannella", "Dawn Mcafee", "Tyson Harbor", "Thurman Hokanson", "Davis Janelle", "Man Graeber", "Elba Trull", "Nereida Kutcher", "Shela Sabatini", "Dania Faucette", "Willow Woodcock", "Morton Suther", "Sherrill Clower", "Wesley Tostado", "Hye Strand", "Carie Knight", "Darci Ranger", "Homer Hesler", "Krystle Harnage");
        for(int i = 1; i < 100; i++) {
            String phone = String.valueOf(new Random().nextInt(Integer.MAX_VALUE));
            String name = names.get(new Random().nextInt(names.size()));
            abonents.add(new Abonent(i, phone, name));
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
