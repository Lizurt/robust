package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Latrine extends Area {
    public Latrine() {
        super("Туалет", LootType.NONE, Size.SMALL);
    }
}
