package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub04_maps;

/* # 18.1 # preparing enum for working with EnumMap */

public enum GasStation {
    DT(50), A80(31), A92(30), A95(50), GAS(40);

    private Integer maxVolume;

    private GasStation(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Integer getMaxVolume() {
        return maxVolume;
    }
}
