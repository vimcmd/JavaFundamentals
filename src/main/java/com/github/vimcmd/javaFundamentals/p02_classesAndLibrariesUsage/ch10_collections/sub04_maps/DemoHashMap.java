package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub04_maps;

import java.util.*;

/* # 17 # creating hash map and updating its value by key */

public class DemoHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {
            {
                this.put("Cheese", 5);
                this.put("Cake", 12);
                this.put("Milk", 8);
                this.put("Bread", 3);
            }
        };

        System.out.println(hashMap);
        hashMap.put("Cake", 9); // replace (without alert) or add if key not exists
        System.out.println(hashMap + " after element replacing");
        Integer a = hashMap.get("Bread");
        System.out.println(a + " found by key 'Bread'");

        // output hash map using methods of Map.Entry<K, V> interface
        Set<Map.Entry<String, Integer>> setV = hashMap.entrySet();
        System.out.println(setV + " using Map.Entry");

        Iterator<Map.Entry<String, Integer>> iterator = setV.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> me = iterator.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
        Set<Integer> val = new HashSet<>(hashMap.values());
        System.out.println(val + " all values using HashSet");

    }
}
