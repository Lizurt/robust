package amo.obj.items.consumable.medicine;

import amo.Amo;
import amo.obj.Usable;
import amo.obj.items.Item;
import game_scene.AdventureScene;

public class Medkit extends Item implements Usable {
    public Medkit(Amo holder) {
        super("Аптечка", holder);
        setDescription("Маленькая, оранжевая, пластиковая аптечка. Похоже, что она новая и не использованная. Осматривая содержимое, вы находите там упаковку бинта, три высоких, разноцветных банки с какими-то таблетками и маленькую баночку с какой то жидкостью, которая, судя по всему, является антисептиком.");
        generateAndSetIcon("/icons/objects/items/medicine/medkit.png");
    }

    @Override
    public void use() {
        util.TextUtils.blueText(AdventureScene.getTextAreaOutput(), getHolder().getName() + " открыл(-а) " + getName() + " и начал(-а) копошиться внутри. Найдя нужные медицинские средства, он(-а) обработал(-а) свои раны и выпил(-а) пару таблеток. Кажется, в аптечке осталось на следующий раз!");
        getHolder().heal(20);
        new MedkitUsed(getHolder());
        destroy();
    }
}
