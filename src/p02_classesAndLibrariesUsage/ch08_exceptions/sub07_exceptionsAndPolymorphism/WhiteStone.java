package p02_classesAndLibrariesUsage.ch08_exceptions.sub07_exceptionsAndPolymorphism;

/* # 10 # polymorphism and exceptions */

public class WhiteStone extends Stone {
    @Override
    public void build(String data) {
        /* realization */
        System.out.println("white stone sphere");
    }
}