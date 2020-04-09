package amo.obj.lootable;

import amo.area.Area;
import amo.obj.Obj;
import util.Random;

import java.util.List;

public class GenericCloset extends Obj implements Lootable {

    public GenericCloset(Area newLocation) {
        super(newLocation);
        setName(Random.pick("", "непримечательный ", "серый ", "стальной ", "старый ") +  "шкафчик"); // TODO: generateRandomAdjective() or something like this
    }

    @Override
    public List<Obj> tryToLoot(Area lootingArea) {
        return null;
    }
}
