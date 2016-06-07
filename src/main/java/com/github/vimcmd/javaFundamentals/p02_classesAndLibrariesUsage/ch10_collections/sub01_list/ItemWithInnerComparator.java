package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.Comparator;

/* # 11 # Entity class with inner comparator classes */

public class ItemWithInnerComparator {
    private int itemId;
    private float price;
    private String name;

    public ItemWithInnerComparator(int itemId, float price, String name) {
        super();
        this.itemId = itemId;
        this.price = price;
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static class IdComparator implements Comparator<ItemWithInnerComparator> {
        @Override
        public int compare(ItemWithInnerComparator one, ItemWithInnerComparator two) {
            return one.getItemId() - two.getItemId();
        }
    }

    public static class PriceComparator implements Comparator<ItemWithInnerComparator> {
        @Override
        public int compare(ItemWithInnerComparator one, ItemWithInnerComparator two) {
            return Double.compare(one.getPrice(), two.getPrice());
        }
    }

}
