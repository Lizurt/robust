package amo.obj.items.weapons.melee;

import amo.Amo;
import amo.obj.items.Item;

public class MetalRod extends Item {
    public MetalRod(Amo holder) {
        super("Арматура", holder);
        setDescription("Тяжелая и стальная арматура. Немного грязная и потрепанная временем. Вряд ли вы сможете с ней что-либо сделать, зато это неплохое оружие!");
        setDamage(8);
        generateAndSetIcon("/icons/objects/items/metalrod.png");
    }
}
