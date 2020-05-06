package amo.obj.items.clothing;

import amo.Amo;

public class BreathMask extends Clothing {
    public BreathMask(Amo holder) {
        super("Баллон и маска", holder);
        setDescription("Голубоватая дыхательная маска с трубкой, подсоединенной к холодному, стальному баллону. Осматривая баллон со всех сторон, вы можете заметить гравировку на его дне: О2.");
        setDamage(6);
        generateAndSetIcon("/icons/objects/items/oxygen.png");
    }
}
