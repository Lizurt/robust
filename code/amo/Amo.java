package amo;

import amo.area.Area;
import amo.mob.Mob;
import amo.obj.Obj;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import util.GlobalVar;

import java.util.ArrayList;

public abstract class Amo {
    private String name = "Нечто Неопределенное";
    private String realName = "Real Mob";
    private boolean isRealNameKnownToPlayer = false;
    private Gender gender = Gender.MALE;
    private String description = "";
    private Size size = Size.NORMAL;
    private Area location;

    private boolean isDestroyed = false;

    private ArrayList<Obj> inventory = new ArrayList<>();

    private Button amoAsButton;
    private Image icon;
    private String amoButtonStyle = "";

    public void destroy() {
        if (GlobalVar.adventureScene.getPlayer().getFocusedOn() == this) {
            GlobalVar.adventureScene.getPlayer().focusOn((GlobalVar.adventureScene.getPlayer().getLocation()));
        }
        name = null;
        realName = null;
        gender = null;
        location = null;
        amoAsButton = null;
        isDestroyed = true;
        inventory.clear();
        inventory = null;
        System.gc();
    }

    public void removeObjFromInventory(Obj obj) {
        obj.unequipFrom(obj.getEquippedOn());
        obj.getHolder().getInventory().remove(obj);
        if (obj.getAmoAsButton() != null) {
            GlobalVar.adventureScene.getInventoryVBox().getChildren().remove(obj.getAmoAsButton());
        }
    }

    public void moveObjToInventory(Obj obj) {
        removeObjFromInventory(obj);
        obj.setHolder(this);
        obj.setLocation(getLocation());
        getInventory().add(obj);
    }

    public String getExamineText() {
        return description;
    }

    public void generateAndSetIcon(String pathToIcon) {
        generateAndSetIcon(pathToIcon, 0, 0);
    }

    public void generateAndSetIcon(String pathToIcon, int width, int height) {
        setIcon(new Image(getClass().getResourceAsStream(pathToIcon), width, height, false, false));
    }


    public void heal(int amount) {}

    public void hurt(int amount) {}

    /////////////////////////////////
    //      GETTERS & SETTERS      //
    /////////////////////////////////

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Area getLocation() {
        return location;
    }
    public void setLocation(Area location) {
        this.location = location;
    }


    public boolean isDestroyed() {
        return isDestroyed;
    }


    public Image getIcon() {
        return icon;
    }
    public void setIcon(Image icon) {
        this.icon = icon;
    }


    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public ArrayList<Obj> getInventory() {
        return inventory;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public Button getAmoAsButton() {
        return amoAsButton;
    }
    public void setAmoAsButton(Button amoAsButton) {
        this.amoAsButton = amoAsButton;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getAmoButtonStyle() {
        return amoButtonStyle;
    }
    public void setAmoButtonStyle(String amoButtonStyle) {
        this.amoButtonStyle = amoButtonStyle;
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

    public boolean isRealNameKnownToPlayer() {
        return isRealNameKnownToPlayer;
    }
    public void setRealNameKnownToPlayer(boolean realNameKnownToPlayer) {
        isRealNameKnownToPlayer = realNameKnownToPlayer;
    }
}
