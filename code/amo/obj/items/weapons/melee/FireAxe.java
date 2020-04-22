package amo.obj.items.weapons.melee;

import amo.Amo;
import amo.Size;
import amo.obj.items.Item;
import javafx.scene.image.Image;

public class FireAxe extends Item {
    public FireAxe(Amo holder) {
        super("Пожарный топор", holder);
        setDamage(20);
        setSize(Size.BULKY);
        setDescription("Красный, изящный и острый топор. Таким можно рубить не только дерево, но и чьи то конечности! К сожалению, он достаточно тяжелый и большой, но... Такой красивый!");
        generateAndSetIcon("/icons/objects/items/guns/melee/fireaxe.png");
    }
}
