package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Canteen extends Area {
    public Canteen() {
        super("Столовая", LootType.NONE, Size.SMALL);
    }
}
