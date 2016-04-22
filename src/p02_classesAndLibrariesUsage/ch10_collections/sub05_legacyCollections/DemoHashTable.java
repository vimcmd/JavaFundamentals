package p02_classesAndLibrariesUsage.ch10_collections.sub05_legacyCollections;

import java.util.*;

/* # 19 # creating HashTable and search element by key */

public class DemoHashTable {
    public static void main(String[] args) {
        Hashtable<Integer, Double> hashtable = new Hashtable<Integer, Double>(){
            {
                for(int i = 0; i < 5; i++) {
                    this.put(i, Math.atan(i));
                }
            }
        };

        Enumeration<Integer> enumKeys = hashtable.keys();
        int key;
        while (enumKeys.hasMoreElements()) {
            key = enumKeys.nextElement();
            System.out.printf("%4d  ", key);
        }
        System.out.println();

        Enumeration<Double> enumValues = hashtable.elements();
        double value;
        while (enumValues.hasMoreElements()) {
            value = enumValues.nextElement();
            System.out.printf("%.2f  ", value);
        }


    }
}
