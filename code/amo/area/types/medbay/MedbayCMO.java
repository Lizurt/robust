package amo.area.types.medbay;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class MedbayCMO extends Area {
    public MedbayCMO() {
        super("Офис главврача", LootType.MEDICAL, Size.SMALL);
    }
}
