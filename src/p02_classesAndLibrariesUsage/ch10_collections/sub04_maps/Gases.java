package p02_classesAndLibrariesUsage.ch10_collections.sub04_maps;

import java.util.EnumMap;

/* # 18.2 # example of usage EnumMap */

public class Gases {
    public static void main(String[] args) {
        EnumMap<GasStation, Integer> station1 = new EnumMap<>(GasStation.class);
        station1.put(GasStation.DT, 10);
        station1.put(GasStation.A80, 5);
        station1.put(GasStation.A92, 30);

        EnumMap<GasStation, Integer> station2 = new EnumMap<>(GasStation.class);
        station2.put(GasStation.DT, 24);
        station2.put(GasStation.A95, 35);

        System.out.println(station1);
        System.out.println(station2);
    }
}
