package amo.mob;

import amo.obj.Obj;
import game_scene.AdventureScene;
import amo.Amo;
import amo.Gender;
import amo.area.Area;
import util.Random;

import java.util.ArrayList;
import java.util.List;

public abstract class Mob extends Amo {

    private String name = "Mob";
    private String realName = "Real Mob";

    private int health = 100;
    private int maxHealth = 100;
    private int minHealth = 0;

    private boolean isRealNameKnownToPlayer = false;

    private Mob focusedOn;

    private Obj activeWeapon;

    private List<Obj> inventory = new ArrayList<>();

    /*
        1 - SkillLevel.NONE(powerless)
        2 - SkillLevel.LOW(weak)
        3 - SkillLevel.MEDIUM(normal)
        4 - SkillLevel.HIGH(strong)
        5 - SkillLevel.INSANE(insanely strong)
     */
    private int strengthLevel = 3;

    public Mob(Area newLocation) {
        moveToArea(newLocation);
    }

    public void addToInventory(Obj obj) {
        obj.setHolder(this);
        getInventory().add(obj);
    }

    public void removeFromInventory(Obj obj) {
        obj.setHolder(getLocation());
        getInventory().remove(obj);
    }

    public String tryToGetRealName() {
        return isRealNameKnownToPlayer ? getRealName() : getName();
    }

    public void generateAttackEventText(Mob attacked, Obj weapon) {
        if(attacked == AdventureScene.getPlayer()) {

        }
        util.TextUtils.attackEventText(AdventureScene.getTextAreaOutput(), tryToGetRealName() + " бьет " + attacked.tryToGetRealName() + ", используя " + weapon.getName() + "!");
    }

    public void attack(Mob attacked, Obj weapon) {
        attacked.hurt(getStrengthLevel() * weapon.getDamage() + Random.random(getStrengthLevel()));
        generateAttackEventText(attacked, weapon);
    }

    public void heal(int amount) {
        setHealth(Math.min(getMaxHealth(), getHealth() + amount));
    }

    public void hurt(int amount) {
        setHealth(Math.max(getMinHealth(), getHealth() - amount));
        updateHealth();
    }

    public void updateHealth() {
        if (getHealth() == getMinHealth()) {
            die();
        }
    }

    public void die() { // TODO
        util.TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), getName() + " умирает!");
    }

    public void generateRandomMob() {
        setGender(Random.pick(Gender.MALE, Gender.FEMALE));
        setName(generateRandomName());
        setRealName(generateRandomRealName());
    }

    public String generateRandomName() {
        return getGender() == Gender.FEMALE ? "Женственный Моб" : "Мужественный Моб";
    }

    public String generateRandomRealName() {
        return getGender() == Gender.FEMALE ? "Моб Аомская" : "Моб Аомский";
    }

    public String generateNameAdjective() {
        return  getGender() == Gender.FEMALE ? "Неопределенная" : "Неопределенный";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void moveToArea(Area newArea, Area oldArea) {
        exited(oldArea);
        moveToArea(newArea);
    }

    @Override
    public void onPlayerAction() {
        if (this == AdventureScene.getPlayer() || getFocusedOn() == null || getLocation() != AdventureScene.getPlayer().getLocation()) {
            return;
        }
        attack(getFocusedOn(), getActiveWeapon());
    }

    public void moveToArea(Area newArea) {
        setLocation(newArea);
        entered(newArea);
    }

    public void entered(Area area) {

    }

    public void exited(Area area) {

    }

    public void focusOn(Mob mob) {
        focusedOn = mob;
    }

    public void tryToChase() {

    }

    public boolean tryToBlockWayOut() {
        return Random.prob(90);
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(SkillLevel skillLevel) {
        switch (skillLevel) {
            case NONE:
                strengthLevel = 1;
                break;
            case LOW:
                strengthLevel = 2;
                break;
            case MEDIUM:
                strengthLevel = 3;
                break;
            case HIGH:
                strengthLevel = 4;
                break;
            case INSANE:
                strengthLevel = 5;
                break;
        }
    }

    public List<Obj> getInventory() {
        return inventory;
    }

    public void setInventory(List<Obj> inventory) {
        this.inventory = inventory;
    }

    public Mob getFocusedOn() {
        return focusedOn;
    }

    public Obj getActiveWeapon() {
        return activeWeapon;
    }

    public void setActiveWeapon(Obj activeWeapon) {
        this.activeWeapon = activeWeapon;
    }

    public boolean isRealNameKnownToPlayer() {
        return isRealNameKnownToPlayer;
    }

    public void setRealNameKnownToPlayer(boolean realNameKnownToPlayer) {
        isRealNameKnownToPlayer = realNameKnownToPlayer;
    }
}
