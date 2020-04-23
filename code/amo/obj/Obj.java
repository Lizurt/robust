package amo.obj;

import amo.Amo;
import amo.mob.Mob;

public abstract class Obj extends Amo {
    private int damage = 1;
    private DamageType damageType = DamageType.BRUTE;
    private boolean isDroppable = true;
    private boolean isEquippable = false;
    private Mob equippedOn;
    private Amo holder = null;

    public Obj(String newName, Amo holder) {
        setName(newName);
        setHolder(holder);
        setLocation(holder.getLocation());
    }

    public void destroy() {
        damageType = null;
        equippedOn = null;
        holder = null;
        super.destroy();
    }

    public void equipOn(Mob mob) {
        if (!isEquippable() || getEquippedOn() != null) {
            return;
        }
        setEquippedOn(mob);
        mob.setActiveWeapon(this);
        mob.onEquip(this);
    }

    public void unequipFrom(Mob mob) {
        if (!isDroppable() || getEquippedOn() != mob || getEquippedOn() == null) {
            return;
        }
        setEquippedOn(null);
        mob.setActiveWeapon(mob.getWeaponAsDefault());
        mob.onUnequip(this);
    }


    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }


    public Amo getHolder() {
        return holder;
    }
    public void setHolder(Amo holder) {
        this.holder = holder;
    }


    public boolean isDroppable() {
        return isDroppable;
    }
    public void setDroppable(boolean droppable) {
        this.isDroppable = droppable;
    }


    public DamageType getDamageType() {
        return damageType;
    }
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }


    public boolean isEquippable() {
        return isEquippable;
    }
    public void setEquippable(boolean equippable) {
        isEquippable = equippable;
    }


    public Mob getEquippedOn() {
        return equippedOn;
    }
    public void setEquippedOn(Mob equippedOn) {
        this.equippedOn = equippedOn;
    }
}
