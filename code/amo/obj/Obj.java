package amo.obj;

import amo.Amo;

public abstract class Obj extends Amo {
    private String name = "неопределенный объект";
    private Size size = Size.HUGE;
    private int damage = 1;
    private Amo holder = null;
    private boolean droppable = true;
    private DamageType damageType = DamageType.BRUTE;

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


    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
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
        setLocation(holder.getLocation());
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
}
