package amo.mob.animal;

import amo.area.Area;
import amo.mob.Mob;
import amo.mob.SkillLevel;
import amo.obj.items.clothing.default_clothing.Chitin;
import amo.obj.items.default_weapon.SpiderJaw;
import util.Random;

public class GiantSpider extends Mob {

    public GiantSpider(Area newLocation) {
        super(newLocation);
        setStrengthLevel(SkillLevel.LOW);
        setWeaponAsDefault(new SpiderJaw(this));
        setClothingAsDefault(new Chitin(this));
        setName(Random.pick("Отвратительный", "Мерзкий", "Гигантский", "Большой") + " паук");
        generateAndSetIcon("/icons/mobs/animals/spiders/spider_1.png");
    }
}
