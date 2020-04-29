package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Bar extends Area {
    public Bar() {
        super("Бар", LootType.GENERAL, Size.SMALL);
    }
}
