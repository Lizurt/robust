package aom.mob;

import GameScene.AdventureScene;
import aom.Aom;
import aom.Gender;
import aom.area.Area;
import util.Random;

public abstract class Mob extends Aom {

    private String name = "Mob";
    private String realName = "Real Mob";

    private int health = 100;
    private int maxHealth = 100;
    private int minHealth = 0;

    public Mob(AdventureScene sceneLocation) {
        super(sceneLocation);
        setName(generateRandomName());
        setRealName(generateRandomRealName());
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
        util.TextUtils.neutralEventText(getSceneLocation().getTextAreaOutput(), getName() + " умирает!");
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
}
