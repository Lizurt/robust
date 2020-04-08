package aom.obj.lootable;

import aom.area.Area;
import aom.obj.Obj;

import java.util.List;

public interface Lootable {

    List<Obj> tryToLoot(Area lootingArea);

}
