package amo.obj.items.default_weapon;

import amo.mob.Mob;
import amo.obj.items.Item;

public class SpiderJaw extends Item {

    public SpiderJaw(Mob holder) {
        super("Паучья челюсть", holder);
        setDroppable(false);
        setDamage(3);
    }

}
