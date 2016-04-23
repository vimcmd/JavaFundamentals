package p02_classesAndLibrariesUsage.ch10_collections.sub06_collectionsStaticMethods;

import p02_classesAndLibrariesUsage.ch10_collections.sub02_queueAndLinkedList.Order;

import java.util.*;

/* # 22 # checked collection */

public class CheckedCollection {
    public static void main(String[] args) {
        Set orders;
        //orders = new HashSet(); // replaceable part for JDK 1.4 and lower
        orders = Collections.checkedSet(new HashSet<Order>(), Order.class); // check type in runtime
        orders.add(new Order(123, 12.f));
        System.out.println(orders);
        // some code here
        orders.add(123); // runtime error: ClassCastException
    }
}