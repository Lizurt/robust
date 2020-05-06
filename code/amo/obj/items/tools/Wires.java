package amo.obj.items.tools;

import amo.Amo;
import amo.obj.items.Item;

public class Wires extends Item {
    public Wires(Amo holder) {
        super("Моток проводов", holder);
        generateAndSetIcon("/icons/objects/items/tools/wires.png");
    }
}
