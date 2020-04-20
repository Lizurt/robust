package amo.obj.items.tools;

import amo.Amo;
import amo.Size;
import amo.obj.DamageType;
import amo.obj.items.Item;
import javafx.scene.image.Image;

public class Lighter extends Item {

    public Lighter(Amo holder) {
        super("Зажигалка", holder);
        setDamageType(DamageType.BURN);
        setSize(Size.TINY);
        setDescription("Обычная, дешевая пластиковая зажигалка. В ней, кажется, еще осталось топливо.");
        setIcon(new Image(getClass().getResourceAsStream("/icons/objects/items/tools/lighter.png")));
    }
}
