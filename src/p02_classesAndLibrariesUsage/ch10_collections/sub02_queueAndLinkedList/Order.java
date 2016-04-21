package p02_classesAndLibrariesUsage.ch10_collections.sub02_queueAndLinkedList;

/* # 13 # user defined class, which objects can be added to queue PriorityQueue and set TreeSet */

public class Order implements Comparable<Order> {
    private int orderId;
    private float amount;

    public Order(int orderId, float amount) {
        super();
        this.orderId = orderId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public float getAmount() {
        return amount;
    }

    // comparable interface realisation
    @Override
    public int compareTo(Order o) {
        return this.orderId - o.orderId;
    }

    @Override
    public String toString() {
        return "Order {" +
                "orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}
