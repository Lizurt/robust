package amo.obj.items.default_weapon;

import amo.mob.Mob;
import amo.obj.items.Item;

public class HumanFists extends Item {

    public HumanFists(Mob holder) {
        super("Кулаки", holder);
        setDroppable(false);
    }

}
