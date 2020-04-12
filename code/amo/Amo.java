package amo;

import amo.area.Area;
import javafx.scene.image.Image;

public abstract class Amo {
    private Gender gender = Gender.MALE;
    private Area location;
    private boolean isDestroyed = false;
    private Image icon;

    public void destroy() {
        gender = null;
        location = null;
        isDestroyed = true;
    }

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
}
