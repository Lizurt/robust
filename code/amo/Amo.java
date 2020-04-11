package amo;

import amo.area.Area;

public abstract class Amo {
    private Gender gender = Gender.MALE;
    private Area location;
    private boolean isDestroyed = false;

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
}
