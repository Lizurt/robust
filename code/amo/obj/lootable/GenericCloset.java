package amo.obj.lootable;

import amo.area.Area;
import amo.obj.Obj;
import amo.obj.Size;
import util.Random;

import java.util.List;

public class GenericCloset extends Obj implements Lootable {

    public GenericCloset(Area holder) {
        super(holder);
        setName(Random.pick("", "непримечательный ", "серый ", "стальной ", "старый ") +  "шкафчик"); // TODO: generateRandomAdjective() or something like this
        setSize(Size.HUGE);
    }

    @Override
    public List<Obj> tryToLoot(Area lootingArea) {
        return null;
    }
}
