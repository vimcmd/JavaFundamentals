package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/* # 5 # methods of ArrayList class and Iterator interface */

public class RunIterator {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(123, 24.2f));
                add(new Order(234, 14.1f));
                add(new Order(345, 42.f));
            }
        };

        FindOrder fo = new FindOrder();
        List<Order> res = fo.findBiggerAmountOrder(30f, orders);
        System.out.println(res);
    }
}