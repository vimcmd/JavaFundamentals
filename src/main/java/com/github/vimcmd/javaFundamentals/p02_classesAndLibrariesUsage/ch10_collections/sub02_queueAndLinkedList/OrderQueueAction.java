package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub02_queueAndLinkedList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/* # 12 # two-way list and queue */

public class OrderQueueAction {
    public static void main(String[] args) {
        LinkedList<Order> orders = new LinkedList<Order>() {
            {
                add(new Order(123, 12.f));
                add(new Order(389, 2.6f));
                add(new Order(240, 8.9f));
            }
        };

        Queue<Order> orderQueue = orders; // implicit call, but LinkedList already implements Queue interface (FIFO)
        orderQueue.offer(new Order(24, 74.2f));
        orderQueue.offer(new Order(684, 4.2f));
        orderProcessing(orderQueue);
        if (orderQueue.isEmpty()) {
            System.out.println("Order queue is empty");
        }
    }

    private static void orderProcessing(Queue<Order> queue) { // replace void -> boolean
        Order ob = null;

        // replace while -> do-while
        while (( ob = queue.poll() ) != null) { //retrieving with removing
            // some processing logic
            System.out.println("Order #" + ob.getOrderId() + " is processing");
        }
    }
}
