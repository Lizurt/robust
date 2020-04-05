package aom.mob;

public abstract class Mob {

    int health = 100;
    int maxHealth = 100;
    int minHealth = 0;

    void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    void hurt(int amount) {
        health = Math.max(minHealth, health - amount);
    }

}
