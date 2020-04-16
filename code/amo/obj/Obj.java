package amo.obj;

import amo.Amo;
import javafx.scene.control.Button;

public abstract class Obj extends Amo {
    private String name = "неопределенный объект";
    private int damage = 1;
    private Amo holder = null;
    private boolean droppable = true;
    private DamageType damageType = DamageType.BRUTE;
    private Button objAsButton = null;

    public Obj(String newName, Amo holder) {
        setName(newName);
        setHolder(holder);
        setLocation(holder.getLocation());
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
}
