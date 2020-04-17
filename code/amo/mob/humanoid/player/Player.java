package amo.mob.humanoid.player;

import amo.mob.Mob;
import amo.obj.Obj;
import amo.obj.items.undroppable.HumanFists;
import game_scene.AdventureScene;
import amo.Gender;
import amo.area.Area;
import amo.mob.humanoid.Humanoid;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.GlobalVar;
import util.Random;
import util.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;

/*  Content:

    MOVEMENT
    INVENTORY
    ACTION
    MISC
    GETTERS & SETTERS
 */

public class Player extends Humanoid {

    private ImageView healthStatIcon = new ImageView(new Image("file:icons/stats/health/health100.png"));
    private int level = 1;

    public Player(Area newLocation) {
        super(newLocation);
        setRealNameKnownToPlayer(true);
        setRealName(Random.pick(GlobalVar.allowedMaleHumanRealName));
        AdventureScene.getPlayerStatsVBox().getChildren().add(healthStatIcon);
        setActiveWeapon(new HumanFists(this));
    }

    /////////////////////////////////
    //           MOVEMENT          //
    /////////////////////////////////

    @Override
    public void tryToChase() {

    }

    @Override
    public boolean tryToBlockWayOut() {
        return false;
    }

    @Override
    public void entered(Area area) {
        TextUtils.whiteBoldText(AdventureScene.getTextAreaOutput(), Random.pick("", "Неужели? ", "А это место сильно поменялось! ", "Вау! ", "Ого! ", "Снова? ") + Random.pick("Кажется это ", "Похоже, что это ", "Скорее всего это ", "Однозначно, это ", "Нет сомнений, что это ") + area.getAreaName() + Random.pick("!", "...", "."));
        area.generateWaysOut();
        for (Area wayOut : area.getWaysOut()) {
            Button buttonWayOut = new Button("", new ImageView(wayOut.getWayOutIcon()));

            AdventureScene.getMovementActionHBox().addNewActionButton(buttonWayOut, e -> {
                getLocation().onPlayerAction();
                for (Mob mob : getLocation().getMobs()) {
                    if (mob.tryToBlockWayOut()) {
                        util.TextUtils.redBoldText(AdventureScene.getTextAreaOutput(), mob.getName() + Random.pick(" не позволяет вам пройти через шлюз!", " не дает вам сбежать!", " блокирует вам дорогу к шлюзу!"));
                        return;
                    }
                }
                AdventureScene.getPlayer().moveToArea(wayOut, getLocation());
                for (Mob mob : wayOut.getMobs()) {
                    if (!mob.appear()) {
                        continue;
                    }
                    mob.focusOn(this);
                }
            }, wayOut);
        }
    }

    @Override
    public void exited(Area area) {
        TextUtils.whiteBoldText(AdventureScene.getTextAreaOutput(), "========== Вы открываете стальной шлюз и входите внутрь... ==========");
        AdventureScene.getPaneEnemyIcon().getChildren().clear();
        AdventureScene.getVBoxEnemyStats().getChildren().clear();
        AdventureScene.getMovementActionHBox().getChildren().clear();
        AdventureScene.getGeneralActionPane().getChildren().clear();
        for (Mob mob : area.getMobs()) {
            mob.tryToChase();
        }
        for (Mob mob : area.getMobs()) {
            mob.destroy();
        }
        for (Obj obj : area.getInventory()) {
            obj.destroy();
        }
        for (Area wayOut : area.getWaysOut()) {
            wayOut.destroy();
        }
        area.getMobs().clear();
    }

    @Override
    public void moveToArea(Area newArea, Area oldArea) {
        super.moveToArea(newArea, oldArea);
        getLocation().setBackgroundImage(null); // TODO
    }

    /////////////////////////////////
    //          INVENTORY          //
    /////////////////////////////////

    @Override
    public void moveObjToInventory(Obj obj) {
        super.moveObjToInventory(obj);
        Button objInInventoryButton = new Button(obj.getName());
        obj.setObjAsButton(objInInventoryButton);
        AdventureScene.getInventoryVBox().getChildren().add(objInInventoryButton);
    }

    /////////////////////////////////
    //            ACTION           //
    /////////////////////////////////

    @Override
    public void focusOn(Mob mob) {
        AdventureScene.getGeneralActionPane().getChildren().clear();
        AdventureScene.getGeneralActionPane().addNewAttackActionButton(new Button("Атаковать " + tryToGetRealName()), attackEvent -> {
            AdventureScene.getPlayer().attackOrGetCloser(this, AdventureScene.getPlayer().getActiveWeapon());
        });
        super.focusOn(mob);
    }

    @Override
    public void focusOn(Obj obj) {
        AdventureScene.getGeneralActionPane().getChildren().clear();
        super.focusOn(obj);
    }

    @Override
    public void focusOn(Area area) {
        AdventureScene.getGeneralActionPane().getChildren().clear();
        AdventureScene.getGeneralActionPane().addNewLootActionButton(new Button("Обыскать " + area.getAreaName()), lootEvent -> {
            // I know this is terrible and inefficient, but ConcurrentModificationException ruins everything!
            ArrayList<Obj> allLoot = area.getInventory();
            if (allLoot.size() < 1) {
                return;
            }
            Obj loot =  allLoot.get(0);
            for (int i = 1; i < allLoot.size(); i++) {
                util.TextUtils.greenText(AdventureScene.getTextAreaOutput(), Random.pick("", "", "Ага! ", "О! ", "Ну вот. ") + "Вы нашли " + loot.getName() + ".");
                moveObjToInventory(loot);
                loot = allLoot.get(i);
            }
        });
        super.focusOn(area);
    }

    @Override
    public void attackOrGetCloser(Mob attacked, Obj weapon) {
        attack(attacked, weapon);
    }

    @Override
    public void attack(Mob attacked, Obj weapon) {
        super.attack(attacked, weapon);
        getLocation().onPlayerAction();
    }

    @Override
    public void updateHealth() {
        updateHealthIcon();
        super.updateHealth();
    }

    public void updateHealthIcon() {
        healthStatIcon.setImage(new Image("file:icons/stats/health/health" + util.Misc.round(getHealth(), 20) + ".png"));
    }

    /////////////////////////////////
    //             MISC            //
    /////////////////////////////////

    public StringBuilder generateIntroductoryStory() {
        StringBuilder coolStory = new StringBuilder();
        coolStory.append("Вы, ");
        coolStory.append(getAge()).append(" летн").append(getGender() == Gender.FEMALE ? "яя " : "ий ");
        coolStory.append(getRealName());
        coolStory.append(", - ");
        coolStory.append("обычный ").append("технический ассистент"); // TODO
        coolStory.append(", работающий в месте под названием \"");
        coolStory.append("Научно-исследовательская станция \"Исход\"\""); // TODO
        coolStory.append(". Эта смена была и остается необычной для вас. Вами было пережито много проишествий всего за несколько часов. ");
        coolStory.append("Сидя в одиночестве на мягком кресле в инженерном отделе, "); // TODO
        coolStory.append("вы слышите еще одно объявление о новой проблеме. Холодный, женский, синтезированный голос доносит до ваших ушей, что");
        coolStory.append("на станции обнаружена неизвестная форма жизни"); // TODO
        coolStory.append(". В объявлении также говорится, что ");
        coolStory.append("вам стоит оставаться в своем отсеке, а в случае обнаружения неизвестных существ доложить об этом службе безопасности"); // TODO
        coolStory.append(". Осознавая, что вы давно не видели никаких сотрудников службы безопасности, как и, в прочем, членов экипажа, вы решаете проигнорировать рекомендации руководства. Несмотря на их слова на протяжении всей смены о том, что в скором времени ситуация взята в руки, вы больше не можете терпеть и ждать помощи. ");
        coolStory.append("Переполняющие вас чувства страха и одиночества заставляют"); // TODO
        coolStory.append(" вас начать искать спасение самому - вы хотите сбежать, не дожидаясь помощи!\n\nВаша задача - выжить, а самый надежный, на ваш взгляд, способ - сбежать отсюда. Ожидание помощи даже более рискованно, чем спасение самому. Попытайтесь найти способ сбежать. Удачи!");
        return coolStory;
    }

    /////////////////////////////////
    //      GETTERS & SETTERS      //
    /////////////////////////////////

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(0, level);
    }
}
