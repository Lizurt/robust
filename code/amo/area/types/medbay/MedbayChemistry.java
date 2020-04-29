package amo.area.types.medbay;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class MedbayChemistry extends Area {
    public MedbayChemistry() {
        super("Химическая лабаратория", LootType.MEDICAL, Size.SMALL);
    }
}
