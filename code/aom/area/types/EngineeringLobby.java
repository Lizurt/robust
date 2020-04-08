package aom.area.types;

import aom.area.Area;
import aom.area.LootType;

public class EngineeringLobby extends Area {

    public EngineeringLobby() {
        super();
        setAreaName("Комната отдыха инженерного отдела");
        setLootType(LootType.ENGINEERING);
    }

}
