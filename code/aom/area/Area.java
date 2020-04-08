package aom.area;

import aom.Aom;
import aom.area.types.Corridor;
import aom.area.types.EngineeringLobby;
import aom.mob.Mob;
import aom.obj.Obj;
import javafx.scene.image.Image;
import util.Random;

import java.util.ArrayList;
import java.util.List;

public abstract class Area extends Aom {
    private String areaName = "Неопределенная локация";
    private AtmosphereType atmosphereType = AtmosphereType.NORMAL;
    private LootType lootType = LootType.NONE;

    private Image backgroundImage;

    private List<Mob> mobs = new ArrayList<>();
    private List<Obj> objects = new ArrayList<>();
    private List<Area> waysOut = new ArrayList<>();

    public Area() {
        generateAtmosphere();
        generateFeature();
        generateLoot();
        generateEnemies();
    }

    public void generateWaysOut() {
        int waysOutAmount = Random.random(1, 3);
        for (int i = 0; i < waysOutAmount; i++) {
            getWaysOut().add(generateRandomArea());
        }
    }

    public Area generateRandomArea() {
        // I know this is shitty way, but I don't know how to make it better.
        // Maybe it's possible somehow to create a list with classes?
        switch (Random.random(1)) {
            case 0:
                return new EngineeringLobby();
            case 1:
                return new Corridor();
        }
        return null;
    }


    public void generateAtmosphere() {
        atmosphereType = Random.pick(AtmosphereType.values());
    }

    public void generateFeature() {

    }

    public void generateLoot() {
        switch (lootType) {
            case ENGINEERING:
                break;
            case SECURITY:
                break;
            case MEDICAL:
                break;
        }
    }

    public void generateEnemies() {

    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public AtmosphereType getAtmosphereType() {
        return atmosphereType;
    }

    public void setAtmosphereType(AtmosphereType atmosphereType) {
        this.atmosphereType = atmosphereType;
    }

    public LootType getLootType() {
        return lootType;
    }

    public void setLootType(LootType lootType) {
        this.lootType = lootType;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public List<Obj> getObjects() {
        return objects;
    }

    public List<Area> getWaysOut() {
        return waysOut;
    }

}
