package p02_classesAndLibrariesUsage.ch08_exceptions.sub07_exceptionsAndPolymorphism;

import java.text.ParseException;

/* # 10 # polymorphism and exceptions */

public class StoneAction { // early created class
    public void buildHouse(Stone stone) {
        try {
            stone.build("some info");
        } catch (ParseException e) { // provided handling ParseException
            e.printStackTrace();
        }
    }
}