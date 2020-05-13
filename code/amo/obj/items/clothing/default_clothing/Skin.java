package amo.obj.items.clothing.default_clothing;

import amo.mob.Mob;
import amo.obj.items.clothing.Clothing;

public class Skin extends Clothing {
    public Skin(Mob holder) {
        super("Кожа", holder);
        setDroppable(false);
        setDescription("Обычная, гладенькая кожа гуманоида, которая не защитит вас ни от чего. Стоп. Как вам удалось ее осмотреть? Доложите об этом разработчикам!");
    }
}
