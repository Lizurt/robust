package amo.obj;

import amo.Amo;
import amo.mob.Mob;
import javafx.scene.control.Button;

public abstract class Obj extends Amo {
    private String name = "неопределенный объект";
    private int damage = 1;
    private Amo holder = null;
    private boolean droppable = true;
    private DamageType damageType = DamageType.BRUTE;
    private Button objAsButton = null;
    private boolean isEquippable = false;
    private Mob equippedOn;

    public Obj(String newName, Amo holder) {
        setName(newName);
        setHolder(holder);
        setLocation(holder.getLocation());
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return droppable;
    }
    public void setDroppable(boolean droppable) {
        this.droppable = droppable;
    }


    public DamageType getDamageType() {
        return damageType;
    }
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Button getObjAsButton() {
        return objAsButton;
    }

    public void setObjAsButton(Button objAsButton) {
        this.objAsButton = objAsButton;
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
