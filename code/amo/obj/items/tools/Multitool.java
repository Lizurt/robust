package amo.obj.items.tools;

import amo.Amo;
import amo.Size;
import amo.obj.items.Item;

public class Multitool extends Item {
    public Multitool(Amo holder) {
        super("Мультиинструмент", holder);
        setDescription("Пластиковый и серый мультиинструмент с маленьким, зеленым экранчиком сверху. На его панели вы можете видеть несколько тумблеров и прочих кнопочек, а также пару проводов небольшой длины сбоку. Весьма полезная штука.");
        generateAndSetIcon("/icons/objects/items/tools/multitool.png");
        setSize(Size.SMALL);
    }
}
