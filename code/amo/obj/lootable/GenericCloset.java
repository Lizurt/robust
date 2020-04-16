package amo.obj.lootable;

import amo.area.Area;
import amo.obj.Obj;
import amo.Size;
import util.Random;

import java.util.List;

public class GenericCloset extends Obj implements Lootable {

    public GenericCloset(Area holder) {
        super(Random.pick("", "непримечательный ", "серый ", "стальной ", "старый ") +  "шкафчик", holder);
        setSize(Size.HUGE);
    }

    @Override
    public List<Obj> tryToLoot(Area lootingArea) {
        return null;
    }
}
