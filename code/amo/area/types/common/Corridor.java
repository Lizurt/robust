package amo.area.types.common;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Corridor extends Area {

    public Corridor() {
        super("Длинный коридор", LootType.NONE, Size.HUGE);
    }

}
