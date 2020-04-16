package amo.area.types.engineering;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class EngineeringStorage extends Area {

    public EngineeringStorage() {
        super("Склад инженерного отдела", LootType.ENGINEERING, Size.NORMAL);
    }

}
