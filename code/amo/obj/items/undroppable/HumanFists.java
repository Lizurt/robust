package amo.obj.items.undroppable;

import amo.mob.Mob;
import amo.obj.items.Item;

public class HumanFists extends Item {

    public HumanFists(Mob holder) {
        super(holder);
        setDroppable(false);
        setName("кулаки");
    }

}
