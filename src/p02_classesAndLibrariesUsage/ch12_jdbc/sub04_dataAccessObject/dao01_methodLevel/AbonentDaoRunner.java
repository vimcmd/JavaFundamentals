package p02_classesAndLibrariesUsage.ch12_jdbc.sub04_dataAccessObject.dao01_methodLevel;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub01_simpleConnectionAndQuery.Abonent;

import java.util.List;

public class AbonentDaoRunner {
    public static void main(String[] args) {
        final String name = "Shela Sabatini";

        AbonentDao abonentDao = new AbonentDao();
        Abonent abonentByName = abonentDao.findAbonentByName(name);
        List<Abonent> allAbonents = abonentDao.findAll();

        System.out.println("Found abonent with name " + name + " (first occurrence): \n" + abonentByName);
        System.out.println();
        allAbonents.forEach(System.out::println);
    }
}
