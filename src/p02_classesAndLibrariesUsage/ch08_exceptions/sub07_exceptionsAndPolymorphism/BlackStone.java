package p02_classesAndLibrariesUsage.ch08_exceptions.sub07_exceptionsAndPolymorphism;

/* # 10 # polymorphism and exceptions */

public class BlackStone extends Stone {
    @Override
    public void build(String data) { //throws Exception { // compilation error
        System.out.println("black stone sphere");
    }
}