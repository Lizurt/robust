package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Chapel extends Area {
    public Chapel() {
        super("Часовня", LootType.NONE, Size.NORMAL);
    }
}
