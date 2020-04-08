package aom.mob.humanoid.player;

import GameScene.AdventureScene;
import aom.Gender;
import aom.area.Area;
import aom.mob.humanoid.Humanoid;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.GlobalVar;
import util.Random;
import util.TextUtils;

public class Player extends Humanoid {

    private ImageView healthStatIcon = new ImageView(new Image("file:icons/stats/health/health100.png"));

    public Player(Area newLocation) {
        super(newLocation);
        setRealName(Random.pick(GlobalVar.allowedMaleHumanRealName));
        AdventureScene.getPlayerStatsVBox().getChildren().add(healthStatIcon);
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
    public void entered(Area area) {
        TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), Random.pick("", "Неужели? ", "А это место сильно поменялось! ", "Вау! ", "Ого! ", "Снова? ") + Random.pick("Кажется это ", "Похоже, что это ", "Скорее всего это ", "Однозначно, это ", "Нет сомнений, что это ") + area.getAreaName() + Random.pick("!", "...", "."));
        area.generateWaysOut();
        for (Area wayOut : area.getWaysOut()) {
            Button buttonWayOut = new Button("Войти в шлюз №" + (AdventureScene.getMovementActionHBox().getChildren().size() + 1));
            buttonWayOut.setOnAction(e -> {
                AdventureScene.getPlayer().moveToArea(wayOut, getLocation());
            });
            AdventureScene.getMovementActionHBox().addNewActionButton(buttonWayOut);
        }
    }

    @Override
    public void exited(Area area) {
        TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), "========== Вы открываете стальные шлюзы и входите внутрь... ==========");
        AdventureScene.getMovementActionHBox().getChildren().clear();
    }

}
