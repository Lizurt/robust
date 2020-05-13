package amo.obj.items.clothing;

import amo.Amo;
import amo.area.AtmosphereType;
import amo.mob.Mob;
import amo.obj.items.Item;
import util.GlobalVar;
import util.Misc;

public abstract class Clothing extends Item {

    private int environmentProtectionLevel = GlobalVar.ENV_PROT_NONE;

    public Clothing(String newName, Amo holder) {
        super(newName, holder);
    }

    public boolean protectsFrom(AtmosphereType atmosphereType) {
        switch (atmosphereType) {
            case HOT:
            case COLD:
            case OXYGENOUS:
            case SLEEP_GAS:
            case LOW_PRESSURE:
            case UNBREATHABLE:
            case HIGH_PRESSURE:
            case PHORON:
                return environmentProtectionLevel >= GlobalVar.ENV_PROT_THRESHOLD_GAS;
            case VACUUM:
                return environmentProtectionLevel >= GlobalVar.ENV_PROT_THRESHOLD_VACUUM;
            case EXTREMELY_HOT:
            case EXTREMELY_COLD:
                return environmentProtectionLevel >= GlobalVar.ENV_PROT_EXTREME;
        }
        return false;
    }


    public int getEnvironmentProtectionLevel() {
        return environmentProtectionLevel;
    }

    public void setEnvironmentProtectionLevel(int environmentProtectionLevel) {
        this.environmentProtectionLevel = Misc.clamp(environmentProtectionLevel, 0, 100);
    }

    @Override
    public void equipOn(Mob mob) {
        if (!isEquippable() || getEquippedOn() != null) {
            return;
        }
        setEquippedOn(mob);
        mob.setActiveClothing(this);
        mob.onEquip(this);
    }

    @Override
    public void unequipFrom(Mob mob) {
        if (!isDroppable() || getEquippedOn() != mob || getEquippedOn() == null) {
            return;
        }
        setEquippedOn(null);
        mob.setActiveClothing(mob.getClothingAsDefault());
        mob.onUnequip(this);
    }
}
