package p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* # 5 # helper class FindOrder */
public class FindOrder {
    public List<Order> findBiggerAmountOrder(float bigAmount, ArrayList<Order> orders) {
        ArrayList<Order> bigPrices = new ArrayList<>();
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) { // replaceable with foreach loop (inside it uses same iterator)
            Order current = iterator.next();
            if (current.getAmount() >= bigAmount) {
                bigPrices.add(current);
            }
        }
        return bigPrices;
    }
}
