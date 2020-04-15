package amo.mob;

import amo.obj.Obj;
import game_scene.AdventureScene;
import amo.Amo;
import amo.Gender;
import amo.area.Area;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import util.Random;

import java.util.ArrayList;
import java.util.List;

/*  Content:

    MOVEMENT
    INVENTORY
    COMBAT
    MISC
    GETTERS & SETTERS
 */

public abstract class Mob extends Amo {

    private String name = "Mob";
    private String realName = "Real Mob";
    private boolean isRealNameKnownToPlayer = false;

    private int health = 100;
    private int maxHealth = 100;
    private int minHealth = 0;
    private Stat stat = Stat.CONSCIOUS;

                        //    ROW  COL  (range: 1-3; 0 - don't have a position)
    private int[] position = { 0,   0 };
    private Mob focusedOn;
    private Button mobAsButton = null;

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

    @Override
    public void destroy() {
        name = null;
        realName = null;
        position = null;
        focusedOn = null;
        mobAsButton = null;
        activeWeapon = null;
        inventory = null;
        super.destroy();
    }

    /////////////////////////////////
    //           MOVEMENT          //
    /////////////////////////////////

    public void moveToArea(Area newArea, Area oldArea) {
        exited(oldArea);
        moveToArea(newArea);
    }

    public void moveToArea(Area newArea) {
        setLocation(newArea);
        entered(newArea);
    }

    public void entered(Area area) {

    }

    public void exited(Area area) {

    }

    public boolean appear(int row, int col) {
        if (moveToPosition(row, col)) {
            util.TextUtils.badEventText(AdventureScene.getTextAreaOutput(), getName() + Random.pick(" предстает перед вами!", " появляется перед вами!", " замечен вами!", " находится здесь!", " обитает здесь!"));
            generateFocusOnButton();
            return true;
        }

        return false;
    }

    public boolean appear(int row) {
        for (int possibleCol = 1; possibleCol <= 3; possibleCol++) {
            if (appear(row, possibleCol)) {
                return true;
            }
        }
        return false;
    }

    public boolean appear() {
        for (int possibleCol = 1; possibleCol <= 3; possibleCol++) {
            if (appear(Random.random(1, 3), possibleCol)) {
                return true;
            }
        }
        return false;
    }

    public void hide() {
        setPosition(0, 0);
    }

    public boolean moveToPosition(int row, int col) {
        // prevents the appearance of an enemy on the enemy icons pane
        if (AdventureScene.getPlayer().getLocation() != getLocation()) {
            return false;
        }
        // prevents multiple enemies from appearing in the same column
        for (Mob mob : getLocation().getMobs()) {
            if (mob != this && mob.getPosition()[1] == col) {
                return false;
            }
        }
        setPosition(Math.max(1, row), Math.max(1, col));
        AdventureScene.updatePaneEnemyIcon();
        return true;
    }
    // \/
    public void goAhead() {
        moveToPosition(position[0] + 1, position[1]);
    }
    // /\
    public void goBack() {
        moveToPosition(position[0] - 1, position[0]);
    }
    // <<
    public void goLeft() {
        moveToPosition(position[1], position[1] - 1);
    }
    // >>
    public void goRight() {
        moveToPosition(position[1], position[1] + 1);
    }

    /////////////////////////////////
    //          INVENTORY          //
    /////////////////////////////////

    public void addToInventory(Obj obj) {
        obj.setHolder(this);
        getInventory().add(obj);
    }

    public void removeFromInventory(Obj obj) {
        if (!obj.isDroppable()) {
            return;
        }
        obj.setHolder(getLocation());
        getInventory().remove(obj);
    }

    /////////////////////////////////
    //            COMBAT           //
    /////////////////////////////////

    public void attackOrGetCloser(Mob attacked, Obj weapon) {
        if (getPosition()[0] < 3) {
            goAhead();
            return;
        }
        attack(attacked, weapon);
    }

    public void attack(Mob attacked, Obj weapon) {
        if (getStat() != Stat.CONSCIOUS) {
            return;
        }
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
        setStat(Stat.DEAD);
    }

    public void tryToChase() {
        destroy();
    }

    public boolean tryToBlockWayOut() {
        return Random.prob(10);
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

    /////////////////////////////////
    //             MISC            //
    /////////////////////////////////

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
        return getGender() == Gender.FEMALE ? "Неопределенная" : "Неопределенный";
    }

    public void generateAttackEventText(Mob attacked, Obj weapon) {
        util.TextUtils.attackEventText(AdventureScene.getTextAreaOutput(), tryToGetRealName() + " бьет " + attacked.tryToGetRealName() + ", используя " + weapon.getName() + "!");
    }

    public void generateFocusOnButton() {
        if (position[0] <= 0 || position[1] <= 0) {
            return;
        }
        Button focusButton = new Button("", new ImageView(getIcon()));
        focusButton.setBackground(null);
        focusButton.setOnAction(focusEvent -> {
            AdventureScene.getPlayer().focusOn(this);
            AdventureScene.getGeneralActionPane().getChildren().clear();
            AdventureScene.getGeneralActionPane().addNewAttackActionButton(new Button("Атаковать " + tryToGetRealName()), attackEvent -> {
                AdventureScene.getPlayer().attackOrGetCloser(this, AdventureScene.getPlayer().getActiveWeapon());
            });
        });
        AdventureScene.getPaneEnemyIcon().add(focusButton, position[1] - 1, position[0] - 1);
    }

    /////////////////////////////////
    //      GETTERS & SETTERS      //
    /////////////////////////////////

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
    public String tryToGetRealName() {
        return isRealNameKnownToPlayer ? getRealName() : getName();
    }


    public List<Obj> getInventory() {
        return inventory;
    }
    public void setInventory(List<Obj> inventory) {
        this.inventory = inventory;
    }


    public void focusOn(Mob mob) {
        focusedOn = mob;
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


    public int[] getPosition() {
        return position;
    }
    public void setPosition(int row, int col) {
        position[0] = Math.max(0, Math.min(3, row));
        position[1] = Math.max(0, Math.min(3, col));
    }


    public Button getMobAsButton() {
        return mobAsButton;
    }
    public void setMobAsButton(Button mobAsButton) {
        this.mobAsButton = mobAsButton;
    }


    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
