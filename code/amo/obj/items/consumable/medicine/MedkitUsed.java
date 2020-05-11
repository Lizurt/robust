package amo.obj.items.consumable.medicine;

import amo.Amo;
import amo.Size;
import amo.obj.Usable;
import amo.obj.items.Item;

public class MedkitUsed extends Item implements Usable {
    public MedkitUsed(Amo holder) {
        super("Полупустая аптечка", holder);
        setDescription("Маленькая, оранжевая, пластиковая аптечка. Эту аптечку уже явно использовали. Внутри нее всего две высоких банки с таблетками, в которых самих таблеток почти не осталось. Также вы можете заметить здесь кусочек бинта. Всего этого может быть и хватит на обработку раны или болезни, но только на раз.");
        generateAndSetIcon("/icons/objects/items/medicine/medkit_used.png");
        setSize(Size.SMALL);
    }

    @Override
    public void use() {
        util.TextUtils.blueText(getHolder().getName() + " открыл(-а) " + getName() + " и начал(-а) копошиться внутри. Найдя нужные медицинские средства, он(-а) обработал(-а) свои раны и выпил(-а) пару таблеток. Ничегошеньки в аптечке больше не осталось, поэтому он(-а) выбросил(-а) пустую аптечку куда подальше.");
        getHolder().heal(20);
        destroy();
    }
}
