package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;

/* # 7 # class extends from List */

/**
 * In this case no explicit necessary to override ArrayList methods, because can be simple used standard methods.
 */
public class OrderArrayList extends ArrayList<Item> {
    private int orderId;

    public OrderArrayList(ArrayList<Item> c) {
        super(c);
    }

    public OrderArrayList(int orderId, ArrayList<? extends Item> c) {
        super(c);
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}