package amo.area.types.medbay;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class MedbaySurgery extends Area {
    public MedbaySurgery() {
        super("Хирургический отсек", LootType.MEDICAL, Size.SMALL);
    }
}
