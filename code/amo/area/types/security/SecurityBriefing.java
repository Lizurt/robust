package amo.area.types.security;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class SecurityBriefing extends Area {
    public SecurityBriefing() {
        super("Зал совещаний отдела СБ", LootType.SECURITY, Size.NORMAL);
    }
}
