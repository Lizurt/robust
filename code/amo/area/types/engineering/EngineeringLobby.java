package amo.area.types.engineering;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class EngineeringLobby extends Area {

    public EngineeringLobby() {
        super("Комната отдыха инженерного отдела", LootType.ENGINEERING, Size.NORMAL);
    }
}
