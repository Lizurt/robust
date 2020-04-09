package amo.obj.items.undroppable;

import amo.mob.Mob;
import amo.obj.items.Item;

public class SpiderJaw extends Item {

    public SpiderJaw(Mob holder) {
        super(holder);
        setDroppable(false);
        setName("паучья челюсть");
        setDamage(2);
    }

}
