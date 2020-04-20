package amo.mob.animal;

import amo.area.Area;
import amo.mob.Mob;
import amo.mob.SkillLevel;
import amo.obj.items.default_weapon.SpiderJaw;
import javafx.scene.image.Image;
import util.Random;

public class GiantSpider extends Mob {

    public GiantSpider(Area newLocation) {
        super(newLocation);
        setStrengthLevel(SkillLevel.LOW);
        setActiveWeapon(new SpiderJaw(this));
        setName(Random.pick("Отвратительный", "Мерзкий", "Гигантский", "Большой") + " паук");
        setIcon(new Image(getClass().getResourceAsStream("/icons/mobs/animals/spiders/spider_1.png")));
    }
}
