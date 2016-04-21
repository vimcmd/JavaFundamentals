package p02_classesAndLibrariesUsage.ch10_collections.sub02_queueAndLinkedList;

import java.util.PriorityQueue;

/* # 14 # working with priority queue () */

public class OrderPriorityQueueAction {
    public static void main(String[] args) {
        PriorityQueue<Order> orders = new PriorityQueue<>();
        //generic class must implement Comparator or Comparable interface to define priority
        orders.add(new Order(123, 12.f));
        orders.add(new Order(12, 46.f));
        orders.add(new Order(451, 1.f));
        orders.add(new Order(2, 645.f));

        orderProcessing(orders);
        if (orders.isEmpty()) {
            System.out.println("Order queue is empty");
        }
    }

    private static void orderProcessing(PriorityQueue<Order> queue) { // replace void -> boolean
        Order ob = null;

        // replace while -> do-while
        while (( ob = queue.poll() ) != null) { //retrieving with removing
            // some processing logic
            System.out.println("Order #" + ob.getOrderId() + " is processing");
        }
    }
}
