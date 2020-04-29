package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Kitchen extends Area {
    public Kitchen() {
        super("Кухня", LootType.GENERAL, Size.SMALL);
    }
}
