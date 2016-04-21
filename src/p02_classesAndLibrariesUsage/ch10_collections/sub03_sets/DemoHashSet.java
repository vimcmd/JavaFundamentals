package p02_classesAndLibrariesUsage.ch10_collections.sub03_sets;

import p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks.FileFiller;

import java.io.*;
import java.util.*;

/* # 14 # output all unique words in file using sets */

public class DemoHashSet {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(100);
        Scanner scanner = null;
        long callTime = System.nanoTime();

        try {
            File file = new File("texts\\nabokov.txt");
            FileFiller fileFiller = new FileFiller(file); // using filling class from previous tasks
            fileFiller.fillNabokov();
            scanner = new Scanner(file);
            scanner.useDelimiter("[^А-я]+");
            while (scanner.hasNext()) {
                words.add(scanner.next().toLowerCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //words.forEach(System.out::println); // using foreach with method reference

        TreeSet<String> treeSet = new TreeSet<>(words); // implements SortedSet, where sorting rule implemented by Comparable interface
        System.out.println(treeSet);
        long totalTime = System.nanoTime() - callTime;
        System.out.println("different words: " + words.size() + ", " + totalTime + " nanoseconds");
    }
}
