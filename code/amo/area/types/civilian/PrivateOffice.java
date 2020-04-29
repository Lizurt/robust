package amo.area.types.civilian;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class PrivateOffice extends Area {
    public PrivateOffice() {
        super("Частный офис", LootType.NONE, Size.SMALL);
    }
}
