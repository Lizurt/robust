package amo.obj.items.weapons.melee;

import amo.Amo;
import amo.Size;
import amo.area.LootType;
import amo.obj.items.Item;

public class FireAxe extends Item {
    public FireAxe(Amo holder) {
        super("Пожарный топор", holder);
        setDamage(20);
        setSize(Size.BULKY);
    }
}
