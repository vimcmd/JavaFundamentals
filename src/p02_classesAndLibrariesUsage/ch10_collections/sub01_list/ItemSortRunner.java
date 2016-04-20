package p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* # 8 # Sort list by field, defined in Comparator class */

public class ItemSortRunner {
    public static void main(String[] args) {
        ArrayList<Item> p = new ArrayList<Item>(){
            {
                add(new Item(123, 123.f, "T-Shirt"));
                add(new Item(52345, 323.f, "Dress"));
                add(new Item(2354, 43.f, "Tie"));
                add(new Item(4562, 213.f, "Jeans"));
                add(new Item(13456, 63.245f, "Gloves"));
            }
        };

        // create anonymous comparator
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item one, Item two) {
                // descending sort
                return Double.compare(two.getPrice(), one.getPrice());
            }
            // public boolean equals(Object ob) { /* implementation */ }
        };

        Comparator<Item> comparatorLambda = (one, two) -> Double.compare(two.getPrice(), one.getPrice());

        // sorting list
        Collections.sort(p, comparator);
        System.out.println(p);
    }
}
