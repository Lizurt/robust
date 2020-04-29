package amo.area.types.security;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;

public class SecurityLobby extends Area {
    public SecurityLobby() {
        super("Отдел СБ", LootType.SECURITY, Size.NORMAL);
    }
}
