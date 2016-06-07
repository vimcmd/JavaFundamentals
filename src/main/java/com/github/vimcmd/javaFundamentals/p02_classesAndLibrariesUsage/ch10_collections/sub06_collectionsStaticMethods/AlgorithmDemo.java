package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub06_collectionsStaticMethods;

import java.util.*;

/* # 23 # some algorithms usage */

public class AlgorithmDemo {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };

        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 2, 3, 4, 5, 6);
        Collections.shuffle(list);
        System.out.println(list + " shuffled");
        Collections.sort(list);
        System.out.println(list + " sorted");
        Collections.reverse(list);
        System.out.println(list + " reversed");
        Collections.rotate(list, 3);
        System.out.println(list + " rotated by 3");
        System.out.println(Collections.min(list, comparator) + ": min");
        System.out.println(Collections.max(list, comparator) + ": max");

        List<Integer> singletoneList = Collections.singletonList(71);
        System.out.println(singletoneList);
        //singletoneList.add(84); // runtime error

    }
}
