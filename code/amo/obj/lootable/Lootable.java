package amo.obj.lootable;

import amo.area.Area;
import amo.obj.Obj;

import java.util.List;

public interface Lootable {

    List<Obj> tryToLoot(Area lootingArea);

}
