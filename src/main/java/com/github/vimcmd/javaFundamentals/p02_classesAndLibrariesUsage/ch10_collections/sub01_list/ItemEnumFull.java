package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub01_list;

/* # 10 # enum, which provides ability to sort ASC/DESC for all class fields */

public enum ItemEnumFull {
    ITEM_ID(true), PRICE(false), NAME(true);
    private boolean ascend;

    private ItemEnumFull(boolean ascend) {
        this.ascend = ascend;
    }

    public boolean isAscend() {
        return ascend;
    }

    public void setAscend(boolean ascend) {
        this.ascend = ascend;
    }
}
