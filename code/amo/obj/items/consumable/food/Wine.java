package amo.obj.items.consumable.food;

import amo.Amo;
import amo.obj.Usable;
import amo.obj.items.Item;

public class Wine extends Item implements Usable {
    public Wine(Amo holder) {
        super("Вино", holder);
        setDescription("Обычная, зеленая бутылка вина. Кажется, ее еще даже не открывали. Кроме названия на ней ничего нет, но даже его вы не можете разобрать. Может быть, это гаттер?");
        generateAndSetIcon("/icons/objects/items/food/wine.png");
        setDamage(3);
    }

    @Override
    public void use() {
        util.TextUtils.blueText(getHolder().tryToGetRealName() + " выпил(-а) " + getName() + "!");
        getHolder().heal(5);
        destroy();
    }
}
