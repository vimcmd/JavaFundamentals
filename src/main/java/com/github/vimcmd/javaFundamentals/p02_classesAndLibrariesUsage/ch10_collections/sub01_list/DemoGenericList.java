package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;

/* # 1 # create generic collection*/

public class DemoGenericList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //ArrayList<int> list1 = new ArrayList<>(); // compilation error: type argument can not be primitive
        list.add("Java"); // compiler knows permissible type
        list.add("Java FX 2");

        String res = list.get(0); // compiler also knows type
        //list.add(new StringBuilder("C#")); // compilation error
        System.out.println(list);
    }

}
