package amo.area.types.security;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class SecurityStorage extends Area {

    public SecurityStorage() {
        super("Склад отдела СБ", LootType.SECURITY, Size.NORMAL);
    }
}
