package amo.obj.items.tools;

import amo.Amo;
import amo.obj.DamageType;
import amo.obj.items.Item;

public class Welder extends Item {
    public Welder(Amo holder) {
        super("Сварочный аппарат", holder);
        setDamageType(DamageType.BURN);
    }
}
