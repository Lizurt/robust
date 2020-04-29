package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Library extends Area {
    public Library() {
        super("Библиотека", LootType.NONE, Size.NORMAL);
    }
}
