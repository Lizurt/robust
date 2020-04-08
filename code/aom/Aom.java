package aom;

import GameScene.AdventureScene;
import aom.area.Area;

public abstract class Aom {
    private Gender gender = Gender.MALE;
    private Area location;

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
}
