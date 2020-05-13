package amo.obj.items.clothing;

import amo.Amo;
import amo.Size;
import util.GlobalVar;

public class BasicSpacesuit extends Clothing {
    public BasicSpacesuit(Amo holder) {
        super("Дешевый скафандр", holder);
        setDescription("Дешевый, неудобный, серый и скучный скафандр с двумя кислородными баллонами на спине. Такой вряд ли защитит от ударов, но зато он может защитить вас при низком давлении или при наличии вредных веществ в воздухе.");
        generateAndSetIcon("/icons/objects/items/clothing/spacesuit.png");
        setSize(Size.BULKY);
        setEnvironmentProtectionLevel(GlobalVar.ENV_PROT_VACUUM);
    }
}
