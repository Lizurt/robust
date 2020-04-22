package amo.area;

import amo.Amo;
import amo.Size;
import amo.area.ObjectGenerators.LootGenerator;
import amo.area.types.common.Corridor;
import amo.area.types.engineering.Engineering;
import amo.area.types.engineering.EngineeringChiefEngineerOffice;
import amo.area.types.engineering.EngineeringLobby;
import amo.area.types.engineering.EngineeringStorage;
import amo.mob.Mob;
import amo.mob.animal.GiantSpider;
import amo.obj.Obj;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import util.GlobalVar;
import util.Random;

import java.util.ArrayList;
import java.util.List;

/*  Content:

    MISC
    ACTION
    GETTERS & SETTERS
 */

public class Area extends Amo {
    private String areaName = "Неопределенная локация";
    private AtmosphereType atmosphereType = AtmosphereType.NORMAL;
    private LootType lootType = LootType.GENERAL;

    private Image backgroundImage;

    private List<Mob> mobs = new ArrayList<>();
    private List<Area> waysOut = new ArrayList<>();

    public Area(String newName, LootType newLootType, Size areaSize) {
        setAreaName(newName);
        setSize(areaSize);
        lootType = newLootType;

        generateAtmosphere();
        generateFeature();
        generateLoot();
        generateEnemies();
    }

    public void destroy() {
        areaName = null;
        atmosphereType = null;
        lootType = null;
        backgroundImage = null;
        mobs.clear();
        mobs = null;
        waysOut.clear();
        waysOut = null;
        super.destroy();
    }

    /////////////////////////////////
    //             MISC            //
    /////////////////////////////////

    public void generateWaysOut() {
        int waysOutAmount = Random.random(1, 3);
        for (int i = 0; i < waysOutAmount; i++) {
            getWaysOut().add(generateRandomArea());
        }
    }

    public Area generateRandomArea() {
        // I know this is shitty way, but I don't know how to make it better.
        // Maybe it's possible somehow to create a list with classes?
        switch (Random.random(5)) {
            case 0:
                return new EngineeringLobby();
            case 1:
                return new Engineering();
            case 2:
                return new EngineeringChiefEngineerOffice();
            case 3:
                return new EngineeringStorage();
            default:
                return new Corridor();
        }
    }


    public void generateAtmosphere() {
        if (Random.prob(66)) {
            setAtmosphereType(AtmosphereType.NORMAL);
            return;
        }
        atmosphereType = Random.pick(AtmosphereType.values());
    }

    public void generateFeature() {

    }

    public void generateLoot() {
        try {
            for (Obj obj : LootGenerator.getGeneratedLoot(this)) {
                moveObjToInventory(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateEnemies() {
        for (int i = 0; i < 3; i++) {
            switch (GlobalVar.difficulty) { // TODO: random enemies
                case EASY:
                    if (Random.prob(66)) {
                        return;
                    }
                    getMobs().add(new GiantSpider(this));
                    break;
                case MEDIUM:
                    if (Random.prob(40)) {
                        return;
                    }
                    getMobs().add(new GiantSpider(this));
                    break;
                case HARD:
                    if (Random.prob(25)) {
                        return;
                    }
                    getMobs().add(new GiantSpider(this));
                    break;
            }
        }
    }

    public Image getWayOutIcon() {
        return new Image(getClass().getResourceAsStream("/icons/area/doors/airlock.png"));
    }

    /////////////////////////////////
    //            ACTION           //
    /////////////////////////////////

    public void onPlayerAction() {
        for (Mob mob : getMobs()) {
            if (!(mob.getFocusedOn() instanceof Mob)) {
                continue;
            }
            mob.attackOrGetCloser((Mob) mob.getFocusedOn(), mob.getActiveWeapon());
        }
    }

    /////////////////////////////////
    //      GETTERS & SETTERS      //
    /////////////////////////////////

    @Override
    public void setAmoAsButton(Button button) {

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


    public Image getBackgroundImage() {
        return backgroundImage;
    }
    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }


    public List<Mob> getMobs() {
        return mobs;
    }


    public List<Area> getWaysOut() {
        return waysOut;
    }
}
