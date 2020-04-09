package amo.area.types.engineering;

import amo.area.Area;
import amo.area.LootType;

public class EngineeringLobby extends Area {

    public EngineeringLobby() {
        super();
        setAreaName("Комната отдыха инженерного отдела");
        setLootType(LootType.ENGINEERING);
    }

    @Override
    public void generateEnemies() {

    }

}
