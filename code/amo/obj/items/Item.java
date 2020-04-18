package amo.obj.items;

import amo.Amo;
import amo.area.Area;
import amo.mob.Mob;
import amo.obj.Obj;

public abstract class Item extends Obj {

    public Item(String newName, Amo holder) {
        super(newName, holder);
        setEquippable(true);
    }

}
