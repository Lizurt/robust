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
import java.util.List;

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

    @Override
    public void updateHealth() {
        updateHealthIcon();
        super.updateHealth();
    }

    public void updateHealthIcon() {
        healthStatIcon.setImage(new Image("file:icons/stats/health/health" + util.Misc.round(getHealth(), 20) + ".png"));
    }

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

    @Override
    public void attack(Mob attacked, Obj weapon) {
        super.attack(attacked, weapon);
        getLocation().onPlayerAction();
    }

    @Override
    public void entered(Area area) {
        TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), Random.pick("", "Неужели? ", "А это место сильно поменялось! ", "Вау! ", "Ого! ", "Снова? ") + Random.pick("Кажется это ", "Похоже, что это ", "Скорее всего это ", "Однозначно, это ", "Нет сомнений, что это ") + area.getAreaName() + Random.pick("!", "...", "."));
        area.generateWaysOut();
        for (Area wayOut : area.getWaysOut()) {
            Button buttonWayOut = new Button("", new ImageView(wayOut.getWayOutIcon()));
            buttonWayOut.setBackground(null);
            buttonWayOut.setOnAction(e -> {
                getLocation().onPlayerAction();
                for (Mob mob : getLocation().getMobs()) {
                    if (mob.tryToBlockWayOut()) {
                        util.TextUtils.badEventText(AdventureScene.getTextAreaOutput(), mob.getName() + Random.pick(" не позволяет вам пройти через шлюз!", " не дает вам сбежать!", " блокирует вам дорогу к шлюзу!"));
                        return;
                    }
                }
                AdventureScene.getPlayer().moveToArea(wayOut, getLocation());
                List<Mob> mobs = new ArrayList<>();
                mobs = wayOut.getMobs();
                for (Mob mob : mobs) {
                    if (!mob.appear()) {
                        continue;
                    }
                    mob.focusOn(this);
                }
            });
            AdventureScene.getMovementActionHBox().addNewActionButton(buttonWayOut);
        }
    }

    @Override
    public void exited(Area area) {
        TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), "========== Вы открываете стальной шлюз и входите внутрь... ==========");
        AdventureScene.getPaneEnemyIcon().getChildren().clear();
        AdventureScene.getVBoxEnemyStats().getChildren().clear();
        AdventureScene.getMovementActionHBox().getChildren().clear();
        for (Mob mob : area.getMobs()) {
            tryToChase();
        }
        for (Mob mob : area.getMobs()) {
            mob.destroy();
        }
        for (Obj obj : area.getObjects()) {
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
        getLocation().setBackground(null); // TODO
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(0, level);
    }

    @Override
    public void focusOn(Mob mob) {
        super.focusOn(mob);
    }

    @Override
    public Mob getFocusedOn() {
        return super.getFocusedOn();
    }

    @Override
    public void tryToChase() {

    }

    @Override
    public boolean tryToBlockWayOut() {
        return false;
    }

}
