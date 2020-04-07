package aom;

import GameScene.AdventureScene;

public abstract class Aom {
    private AdventureScene sceneLocation;
    private Gender gender = Gender.MALE;

    public Aom(AdventureScene sceneLocation) {
        setSceneLocation(sceneLocation);
    }

    public AdventureScene getSceneLocation() {
        return sceneLocation;
    }

    public void setSceneLocation(AdventureScene sceneLocation) {
        this.sceneLocation = sceneLocation;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
