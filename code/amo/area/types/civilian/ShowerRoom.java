package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class ShowerRoom extends Area {
    public ShowerRoom() {
        super("Душевая", LootType.NONE, Size.SMALL);
    }
}
