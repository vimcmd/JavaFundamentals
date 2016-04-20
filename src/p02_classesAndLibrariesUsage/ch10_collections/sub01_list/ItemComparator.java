package p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

import java.util.Comparator;

/* # 9 # ability to sort by all class fields */

public class ItemComparator implements Comparator<Item> {
    private ItemEnum sortingIndex;

    public ItemComparator(ItemEnum sortingIndex) {
        setSortingIndex(sortingIndex);
    }

    public final void setSortingIndex(ItemEnum sortingIndex) {
        if (sortingIndex == null) {
            throw new IllegalArgumentException();
        }
        this.sortingIndex = sortingIndex;
    }

    public ItemEnum getSortingIndex() {
        return sortingIndex;
    }

    @Override
    public int compare(Item one, Item two) {
        switch (sortingIndex) {
            case ITEM_ID:
                return one.getItemId() - two.getItemId(); // subtraction may produce logic error when out of MAX/MIN value bound
            case PRICE:
                return Double.compare(two.getPrice(), one.getPrice());
            case NAME:
                return one.getName().compareTo(two.getName());
            default:
                throw new EnumConstantNotPresentException(ItemEnum.class, sortingIndex.name());
        }
    }
}
