package amo;

import amo.area.Area;
import amo.obj.Obj;
import game_scene.AdventureScene;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Amo {
    private Gender gender = Gender.MALE;
    private Area location;
    private boolean isDestroyed = false;
    private Image icon;
    private Size size = Size.NORMAL;
    private ArrayList<Obj> inventory = new ArrayList<>();

    public void destroy() {
        gender = null;
        location = null;
        isDestroyed = true;
    }

    public void moveObjToInventory(Obj obj) {
        obj.getHolder().getInventory().remove(obj);
        obj.setHolder(this);
        obj.setLocation(getLocation());
        getInventory().add(obj);
        if (obj.getObjAsButton() != null) {
            AdventureScene.getInventoryVBox().getChildren().remove(obj.getObjAsButton());
        }
    }

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
}
