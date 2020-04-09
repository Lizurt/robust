package amo.area.types.engineering;

import amo.area.Area;
import amo.area.LootType;

public class Engineering extends Area {

    public Engineering() {
        super();
        setAreaName("Инженерный отдел");
        setLootType(LootType.ENGINEERING);
    }

}
