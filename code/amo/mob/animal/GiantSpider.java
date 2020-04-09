package amo.mob.animal;

import amo.area.Area;
import amo.mob.Mob;
import amo.mob.SkillLevel;
import amo.obj.items.undroppable.SpiderJaw;
import util.Random;

public class GiantSpider extends Mob {

    public GiantSpider(Area newLocation) {
        super(newLocation);
        setStrengthLevel(SkillLevel.LOW);
        setActiveWeapon(new SpiderJaw(this));
        setName(Random.pick("Отвратительный", "Мерзкий", "Гигантский", "Большой") + " паук");
    }
}
