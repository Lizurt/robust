package amo.area.types.medbay;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class Medbay extends Area {
    public Medbay() {
        super("Медотсек", LootType.MEDICAL, Size.BULKY);
    }
}
