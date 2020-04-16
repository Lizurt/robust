package amo.area.types.engineering;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Engineering extends Area {
    public Engineering() {
        super("Инженерный отдел", LootType.ENGINEERING, Size.BULKY);
    }

}
