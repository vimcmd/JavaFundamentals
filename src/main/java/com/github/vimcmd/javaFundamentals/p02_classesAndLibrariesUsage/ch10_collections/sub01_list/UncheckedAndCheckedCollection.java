package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;

/* # 2 # Incorrect (raw objects) and correct collections */

public class UncheckedAndCheckedCollection {
    public static void main(String[] args) {
        ArrayList raw = new ArrayList(){ // raw type collection
            { // logic block of anonymous class with unchecked call
                add(new Order(231, 12.f));
                add(new Item(5465, 120.0f, "Xerox"));
                add(new Order(321, 10.f));
            }
        };

        // on data extraction type casting required
        Order or1 = (Order) raw.get(0);
        Item or2 = (Item) raw.get(1);
        Order or3 = (Order) raw.get(2);

        for(Object ob : raw) {
            System.out.println("raw: " + ob);
        }

        ArrayList<Order> orders = new ArrayList<Order>(){
            {
                add(new Order(231, 12.f));
                add(new Order(513, 11.f));
                add(new Order(123, 21.f));
                //add(new Item(234, 11.2f, "Xerox")); // compilation error: incompatible types
            }
        };

        for(Order order : orders) {
            System.out.println("order: " + order);
        }
    }
}