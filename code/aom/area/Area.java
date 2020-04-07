package aom.area;

import GameScene.AdventureScene;
import aom.Aom;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import util.Random;
import util.TextUtils;

public abstract class Area extends Aom {
    private String areaName = "Неопределенная локация";
    private AtmosphereType atmosphereType = AtmosphereType.NORMAL;
    private LootType lootType = LootType.NONE;
    private Image backgroundImage;

    public Area(AdventureScene sceneLocation) {
        super(sceneLocation);
        generateAtmosphere();
        generateFeature();
        generateLoot();
        generateEnemies();
    }

    public void onPlayerEntered() {
        TextUtils.neutralEventText(getSceneLocation().getTextAreaOutput(), Random.pick("", "Неужели? ", "А это место сильно поменялось! ") + Random.pick("Кажется это ", "Похоже на ", "Вы давно хотели посетить ") + getAreaName() + Random.pick("!", "...", "."));
    }

    public void onPlayerExited() {
        TextUtils.neutralEventText(getSceneLocation().getTextAreaOutput(), "========== Вы открываете стальные шлюзы и входите внутрь... ==========");
    }

    public void generateWaysOut() {
        int waysOutAmount = Random.random(1, 3);
        Button wayOut;
        for (int i = 0; i < waysOutAmount; i++) {
            wayOut = new Button("Войти в шлюз № " + (i + 1)); // TODO
        }
    }

    public void generateAtmosphere() {

    }

    public void generateFeature() {

    }

    public void generateLoot() {

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
}
