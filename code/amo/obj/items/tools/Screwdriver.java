package amo.obj.items.tools;

import amo.Amo;
import amo.obj.Size;
import amo.obj.items.Item;

public class Screwdriver extends Item {
    public Screwdriver(Amo holder) {
        super("Отвертка", holder);
        setDamage(2);
        setSize(Size.SMALL);
    }
}
