package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* # 6 # class, aggregated list with Iterable interface implementation */

public class OrderIterable implements Iterable<Item> {
    private int orderId;
    private List<Item> listItems;
    //private float amount; // not needed because can be computed

    public OrderIterable(int orderId, List<Item> listItems) {
        this.orderId = orderId;
        this.listItems = listItems;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Item> getListItems() {
        return Collections.unmodifiableList(listItems);
    }

    // some delegated methods from List and Collections interfaces
    public boolean add(Item item) {
        return listItems.add(item);
    }

    public Item get(int index) {
        return listItems.get(index);
    }

    public Item remove(int index) {
        return listItems.remove(index);
    }

    @Override

    public Iterator<Item> iterator() {
        return listItems.iterator();
    }
}
