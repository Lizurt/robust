package amo.obj;

import amo.Amo;
import amo.mob.Mob;
import amo.mob.humanoid.player.Player;
import game_scene.AdventureScene;
import javafx.scene.control.Button;
import util.Random;

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

    @Override
    public boolean focusOnPreparationsBy(Amo amo) {
        Player player = AdventureScene.getPlayer();
        if (amo == player) {
            AdventureScene.getGeneralActionPane().getChildren().clear();
            AdventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Осмотреть: " + getName()), examineEvent -> {
                util.TextUtils.whiteText(AdventureScene.getTextAreaOutput(), Random.pick("Да это же ", "Это ", "Похоже, что это ") + getName() + ". " + getDescription());
            });

            if (player.getActiveWeapon() == this || player.getActiveArmor() == this) {
                if (isDroppable()) {
                    AdventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Снять"), equipEvent -> {
                        unequipFrom(player);
                        AdventureScene.updateGeneralActionPane();
                    });
                }
            } else {
                if (isEquippable()) {
                    AdventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Экипировать"), equipEvent -> {
                        equipOn(player);
                        AdventureScene.updateGeneralActionPane();
                    });
                }
            }

            AdventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Выбросить"), equipEvent -> {
                player.getLocation().moveObjToInventory(this);
                util.TextUtils.whiteText(AdventureScene.getTextAreaOutput(), "Вы выбросили " + getName() + "!");
                AdventureScene.updateGeneralActionPane();
            });

            if (player.getFocusedOn() != null && player.getFocusedOn().getAmoAsButton() != null) {
                player.getFocusedOn().getAmoAsButton().setStyle(player.getFocusedOn().getAmoAsButton().getStyle().replaceAll("-fx-border-color: #.{1,6};", "-fx-border-color: #000;"));
            }
            if (getAmoAsButton() != null) {
                getAmoAsButton().setStyle(getAmoAsButton().getStyle().replaceAll("-fx-border-color: #.{1,6};", "-fx-border-color: #700;"));
            }
        }

        return true;
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
