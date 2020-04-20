package amo.obj.items.tools;

import amo.Amo;
import amo.obj.DamageType;
import amo.obj.items.Item;
import javafx.scene.image.Image;

public class Welder extends Item {
    public Welder(Amo holder) {
        super("Сварочный аппарат", holder);
        setDamageType(DamageType.BURN);
        setDescription("Полный топлива, удобный и мобильный сварочный аппарат сравнительно небольших размеров. Логично, что его используют при сварке, но при желании, может использовать как резак.");
        setIcon(new Image(getClass().getResourceAsStream("/icons/objects/items/tools/welder.png")));
    }
}
