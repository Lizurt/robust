package amo.area.types.engineering;

import amo.area.Area;
import amo.area.LootType;

public class EngineeringStorage extends Area {

    public EngineeringStorage() {
        super();
        setAreaName("Склад инженерного отдела");
        setLootType(LootType.ENGINEERING);
    }

}
