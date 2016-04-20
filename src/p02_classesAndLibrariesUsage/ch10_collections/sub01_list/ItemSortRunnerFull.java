package p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;
import java.util.Collections;

/* # 10.2 # sort item by field and order (ASC/DESC), defined in comparator */

public class ItemSortRunnerFull {
    public static void main(String[] args) {
        ArrayList<Item> p = new ArrayList<Item>() {
            {
                add(new Item(123, 123.f, "T-Shirt"));
                add(new Item(52345, 323.f, "Dress"));
                add(new Item(2354, 43.f, "Tie"));
                add(new Item(4562, 213.f, "Jeans"));
                add(new Item(13456, 63.245f, "Gloves"));
                add(new Item(11454, 124.45f, "Shirt"));
            }
        };

        System.out.println("--- list without sorting");
        for(Item item : p) {
            System.out.println(item);
        }

        ItemComparatorFull comparator = new ItemComparatorFull();

        System.out.println("--- sort by id in desc order");
        ItemEnumFull itemEnumFull = ItemEnumFull.ITEM_ID;
        itemEnumFull.setAscend(false);
        comparator.setSortingIndex(itemEnumFull);
        Collections.sort(p, comparator);
        for(Item item : p) {
            System.out.println(item);
        }

        System.out.println("--- sort by price in asc order");
        itemEnumFull = ItemEnumFull.PRICE;
        itemEnumFull.setAscend(true);
        comparator.setSortingIndex(itemEnumFull);
        Collections.sort(p, comparator);
        for(Item item : p) {
            System.out.println(item);
        }

        System.out.println("--- sort by name in default order");
        itemEnumFull = ItemEnumFull.NAME;
        //itemEnumFull.setAscend(false);
        comparator.setSortingIndex(itemEnumFull);
        Collections.sort(p, comparator);
        for(Item item : p) {
            System.out.println(item);
        }
    }
}
