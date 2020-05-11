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
        setDescription("Обычная, дешевая пластиковая зажигалка. В ней, кажется, еще осталось топливо.");
        generateAndSetIcon("/icons/objects/items/tools/lighter.png");
    }
}
