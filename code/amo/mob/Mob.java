package amo.mob;

import amo.Amo;
import amo.Gender;
import amo.area.Area;
import amo.obj.Obj;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import util.GlobalVar;
import util.Random;

/*  Content:

    MOVEMENT
    INVENTORY
    ACTION
    MISC
    GETTERS & SETTERS
 */

public abstract class Mob extends Amo {

    private String realName = "Real Mob";
    private boolean isRealNameKnownToPlayer = false;

    private int health = 100;
    private int maxHealth = 100;
    private int minHealth = 0;
    private Stat stat = Stat.CONSCIOUS;

                        //    ROW  COL  (range: 1-3; 0 - don't have a position)
    private int[] position = { 0,   0 };
    private Amo focusedOn;

    private Obj weaponAsDefault;
    private Obj activeWeapon;
    private Obj activeArmor;

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
        realName = null;
        stat = null;
        position = null;
        focusedOn = null;
        weaponAsDefault = null;
        activeWeapon = null;
        activeArmor = null;
        if (getAmoAsButton() != null) {
            GlobalVar.adventureScene.getPaneEnemyIcon().getChildren().remove(getAmoAsButton());
        }
        if (getLocation() != null) {
            getLocation().getMobs().remove(this);
        }
        super.destroy();
    }

    /////////////////////////////////
    //           MOVEMENT          //
    /////////////////////////////////

    public void moveToArea(Area newArea, Area oldArea) {
        exited(oldArea);
        moveToArea(newArea);
        oldArea.destroy();
    }

    private void moveToArea(Area newArea) {
        setLocation(newArea);
        entered(newArea);
    }

    public void entered(Area area) {

    }

    public void exited(Area area) {

    }

    public boolean appear(int row, int col) {
        if (moveToPosition(row, col)) {
            util.TextUtils.redBoldText(tryToGetRealName() + Random.pick(" предстает перед вами!", " появляется перед вами!", " замечен вами!", " находится здесь!", " обитает здесь!"));
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
        if (GlobalVar.adventureScene.getPlayer().getLocation() != getLocation()) {
            return false;
        }
        // prevents multiple enemies from appearing in the same column
        for (Mob mob : getLocation().getMobs()) {
            if (mob != this && mob.getPosition()[1] == col) {
                return false;
            }
        }
        setPosition(Math.max(1, row), Math.max(1, col));
        GlobalVar.adventureScene.updatePaneEnemyIcon();
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

    public void onEquip(Obj obj) {

    }

    public void onUnequip(Obj obj) {

    }

    /////////////////////////////////
    //            ACTION           //
    /////////////////////////////////

    public void focusOn(Amo amo) {
        focusedOn = amo;
    }

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

    @Override
    public void heal(int amount) {
        setHealth(Math.min(getMaxHealth(), getHealth() + amount));
    }

    @Override
    public void hurt(int amount) {
        setHealth(Math.max(getMinHealth(), getHealth() - amount));
        updateHealth();
    }

    public void updateHealth() {
        if (getHealth() == getMinHealth()) {
            die();
        }
    }

    public boolean die() {
        if (getStat() == Stat.DEAD) {
            return false;
        }
        util.TextUtils.whiteBoldText(tryToGetRealName() + " умирает!");
        setStat(Stat.DEAD);
        return true;
    }

    public void tryToChase() {

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
        util.TextUtils.redText(tryToGetRealName() + " бьет " + attacked.tryToGetRealName() + ", используя " + weapon.getName() + "!");
    }

    public void generateFocusOnButton() {
        if (position[0] <= 0 || position[1] <= 0) {
            return;
        }
        setAmoAsButton(new Button("", new ImageView(getIcon())));
        getAmoAsButton().setBackground(null);
        getAmoAsButton().setStyle("-fx-padding: 0; -fx-border-color: #000; -fx-border-width: 0 0 6 0;");
        getAmoAsButton().setOnAction(focusEvent -> {
            if (GlobalVar.adventureScene.getPlayer().getFocusedOn() == this) {
                GlobalVar.adventureScene.getPlayer().focusOn(GlobalVar.adventureScene.getPlayer().getLocation());
            } else {
                GlobalVar.adventureScene.getPlayer().focusOn(this);
            }
        });
        GlobalVar.adventureScene.updatePaneEnemyIcon();
    }

    public void reactToTheAtmosphere() {
        switch (getLocation().getAtmosphereType()) {
            case HOT:
                break;
            case COLD:
                break;
            case PHORON:
                hurt(5);
                break;
            case VACUUM:
                hurt(20);
                break;
            case OXYGENOUS:
                break;
            case SLEEP_GAS:
                break;
            case LOW_PRESSURE:
                break;
            case UNBREATHABLE:
                hurt(2);
                break;
            case EXTREMELY_HOT:
                hurt(10);
                break;
            case HIGH_PRESSURE:
                break;
            case EXTREMELY_COLD:
                hurt(10);
                break;
        }
    }

    @Override
    public void generateAndSetIcon(String pathToIcon) {
        generateAndSetIcon(pathToIcon, 64, 64);
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


    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String tryToGetRealName() {
        return isRealNameKnownToPlayer ? getRealName() : getName();
    }


    public Amo getFocusedOn() {
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


    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }


    public Obj getActiveArmor() {
        return activeArmor;
    }
    public void setActiveArmor(Obj activeArmor) {
        this.activeArmor = activeArmor;
    }


    public Obj getWeaponAsDefault() {
        return weaponAsDefault;
    }
    public void setWeaponAsDefault(Obj weaponAsDefault) {
        this.weaponAsDefault = weaponAsDefault;
    }
}
