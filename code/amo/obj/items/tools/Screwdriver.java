package amo.obj.items.tools;

import amo.Amo;
import amo.Size;
import amo.obj.items.Item;
import javafx.scene.image.Image;

public class Screwdriver extends Item {
    public Screwdriver(Amo holder) {
        super("Отвертка", holder);
        setDamage(2);
        setSize(Size.SMALL);
        setDescription("Весьма полезный инструмент, если вам нужно что то взломать или открутить.");
        setIcon(new Image("file:icons/objects/items/tools/screwdriver.png"));
    }
}
