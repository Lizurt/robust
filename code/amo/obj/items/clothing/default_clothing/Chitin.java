package amo.obj.items.clothing.default_clothing;

import amo.mob.Mob;
import amo.obj.items.clothing.Clothing;

public class Chitin extends Clothing {
    public Chitin(Mob holder) {
        super("Хитиновый покров", holder);
        setDroppable(false);
        setDescription("Тверденький хитиновый покров... Стоп. Как вам удалось его осмотреть? Доложите об этом разработчикам!");
    }
}
