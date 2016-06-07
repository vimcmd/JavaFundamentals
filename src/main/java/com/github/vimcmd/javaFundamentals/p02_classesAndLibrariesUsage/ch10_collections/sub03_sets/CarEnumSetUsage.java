package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub03_sets;

import java.util.EnumSet;

/* # 16.2 # usage sets of enum types  */

public class CarEnumSetUsage {
    public static void main(String[] args) {
        // japan auto set contains enum types elements from range defined by two elements
        EnumSet<CarManufacturer> japanAuto = EnumSet.range(CarManufacturer.TOYOTA, CarManufacturer.SUZUKI);

        // set will contains all elements without japanAuto
        EnumSet<CarManufacturer> other = EnumSet.complementOf(japanAuto);

        System.out.println(japanAuto);
        System.out.println(other);

        action("audi", japanAuto);
        action("suzuki", japanAuto);
    }

    private static boolean action(String auto, EnumSet<CarManufacturer> set) {
        CarManufacturer cm = CarManufacturer.valueOf(auto.toUpperCase());
        boolean ok = false;
        if (( ok = set.contains(cm) )) {
            // processing
            System.out.println("processing done: " + cm);
        } else {
            System.out.println("processing can not be done: " + cm);
        }
        return ok;
    }
}
