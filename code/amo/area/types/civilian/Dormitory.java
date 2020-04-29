package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Dormitory extends Area {
    public Dormitory() {
        super("Спальный отсек", LootType.GENERAL, Size.NORMAL);
    }
}
