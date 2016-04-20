package p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.Comparator;

/* # 10.1 # ability to sort by each field in ASC/DESC order */

public class ItemComparatorFull implements Comparator<Item> {
    private ItemEnumFull sortingIndex;

    public ItemEnumFull getSortingIndex() {
        return sortingIndex;
    }

    public final void setSortingIndex(ItemEnumFull sortingIndex) {
        if (sortingIndex == null) {
            throw new IllegalArgumentException();
        }
        this.sortingIndex = sortingIndex;
    }

    @Override
    public int compare(Item one, Item two) {
        switch (sortingIndex) {
            case ITEM_ID:
                if (sortingIndex.isAscend()) {
                    return one.getItemId() - two.getItemId();
                } else {
                    return two.getItemId() - one.getItemId();
                }
            case PRICE:
                if (sortingIndex.isAscend()) {
                    return Double.compare(one.getPrice(), two.getPrice());
                } else {
                    return Double.compare(two.getPrice(), one.getPrice());
                }
            case NAME:
                if (sortingIndex.isAscend()) {
                    return two.getName().compareTo(one.getName());
                } else {
                    return one.getName().compareTo(two.getName());
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}
