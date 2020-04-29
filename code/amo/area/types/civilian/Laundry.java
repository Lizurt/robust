package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Laundry extends Area {
    public Laundry() {
        super("Прачечная", LootType.GENERAL, Size.SMALL);
    }
}
