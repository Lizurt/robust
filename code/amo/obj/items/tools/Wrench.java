package amo.obj.items.tools;

import amo.Amo;
import amo.Size;
import amo.obj.items.Item;

public class Wrench extends Item {
    public Wrench(Amo holder) {
        super("Гаечный ключ", holder);
        setDescription("Обычный, стальной гаечный ключ. Выглядит достаточно новым по сравнению со всем тем, что вы видели на этой станции. В качестве оружия он не самый удобный и опасный, но лучше, чем ваши кулаки.");
        setDamage(4);
        generateAndSetIcon("/icons/objects/items/tools/wrench.png");
        setSize(Size.SMALL);
    }
}
