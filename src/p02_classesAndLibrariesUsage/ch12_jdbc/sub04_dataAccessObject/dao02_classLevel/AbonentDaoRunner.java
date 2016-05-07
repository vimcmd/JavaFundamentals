package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao02_classLevel;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.util.List;

public class AbonentDaoRunner {
    public static void main(String[] args) {
        AbonentDAO abonentDao = new AbonentDAO(); // connection was created
        List<Abonent> abonents = abonentDao.findAll();

        abonents.forEach(System.out::println);
        abonentDao.close(); // connection must be closed
    }
}
