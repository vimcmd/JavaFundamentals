package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub03_sets;

import java.util.*;

/* # 15 # creating set from list and its methods */

public class DemoTreeSet {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean b;
        for(int i = 0; i < 8; i++) {
            list.add((int)(Math.random() * 10) + "Y ");
        }

        System.out.println(list + " list");
        TreeSet<String> treeSet = new TreeSet<>(list); // sort on elements adding stage
        System.out.println(treeSet + " set");
        System.out.println(treeSet.comparator() + " comparator"); // null - String implements Comparable

        // extract first and last elements
        System.out.println(treeSet.first() + " first, " + treeSet.last() + " last");

        HashSet<String> hashSet = new HashSet<>(treeSet);
        for ( String el : hashSet )
        {
            System.out.println(el + " hash: " + el.hashCode());
        }
    }
}