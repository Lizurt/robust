package amo.obj.items.tools;

import amo.Amo;
import amo.Size;
import amo.obj.DamageType;
import amo.obj.items.Item;

public class Lighter extends Item {

    public Lighter(Amo holder) {
        super("Зажигалка", holder);
        setDamageType(DamageType.BURN);
        setSize(Size.TINY);
    }
}