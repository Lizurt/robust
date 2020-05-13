package amo.mob.humanoid.player;

import amo.Gender;
import amo.area.Area;
import amo.mob.Mob;
import amo.mob.humanoid.Humanoid;
import amo.obj.Obj;
import amo.obj.Usable;
import amo.obj.items.clothing.default_clothing.Skin;
import amo.obj.items.default_weapon.HumanFists;
import game_scenes.misc.AlertBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import util.GlobalVar;
import util.Random;
import util.TextUtils;

import java.util.ArrayList;

/*  Content:

    MOVEMENT
    INVENTORY
    ACTION
    MISC
    GETTERS & SETTERS
 */

public class Player extends Humanoid {

    private ImageView healthStatIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/stats/health/health100.png")));
    private int level = 1;

    public Player(Area newLocation) {
        super(newLocation);
        setRealNameKnownToPlayer(true);
        GlobalVar.adventureScene.getPlayerStatsVBox().getChildren().add(healthStatIcon);
        setWeaponAsDefault(new HumanFists(this));
        setClothingAsDefault(new Skin(this));
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
        TextUtils.whiteBoldText(Random.pick("", "Неужели? ", "А это место сильно поменялось! ", "Вау! ", "Ого! ", "Снова? ") + Random.pick("Кажется это ", "Похоже, что это ", "Скорее всего это ", "Однозначно, это ", "Нет сомнений, что это ") + area.getName() + Random.pick("!", "...", "."));
        area.generateWaysOut();
        for (Area wayOut : area.getWaysOut()) {
            Button buttonWayOut = new Button("", new ImageView(wayOut.getWayOutIcon()));

            GlobalVar.adventureScene.getMovementActionHBox().addNewActionButton(buttonWayOut, e -> {
                getLocation().onPlayerAction();
                for (Mob mob : getLocation().getMobs()) {
                    if (mob.tryToBlockWayOut()) {
                        util.TextUtils.redBoldText(mob.getName() + Random.pick(" не позволяет вам пройти через шлюз!", " не дает вам сбежать!", " блокирует вам дорогу к шлюзу!"));
                        return;
                    }
                }
                GlobalVar.adventureScene.getPlayer().moveToArea(wayOut, getLocation());
                for (Mob mob : wayOut.getMobs()) {
                    if (!mob.appear()) {
                        continue;
                    }
                    mob.focusOn(this);
                }
            }, wayOut);
        }
        focusOn(area);
        GlobalVar.adventureScene.getPaneEnemyIcon().setBackground(new Background(new BackgroundImage(area.getIcon(), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    @Override
    public void exited(Area area) {
        TextUtils.whiteBoldText("========== Вы открываете стальной шлюз и входите внутрь... ==========");
        GlobalVar.adventureScene.getPaneEnemyIcon().getChildren().clear();
        GlobalVar.adventureScene.getVBoxEnemyStats().getChildren().clear();
        GlobalVar.adventureScene.getMovementActionHBox().getChildren().clear();
        GlobalVar.adventureScene.getGeneralActionPane().getChildren().clear();
        for (Mob mob : area.getMobs()) {
            mob.tryToChase();
        }
    }

    @Override
    public boolean appear() {
        return false;
    }

    /////////////////////////////////
    //          INVENTORY          //
    /////////////////////////////////

    @Override
    public void moveObjToInventory(Obj obj) {
        super.moveObjToInventory(obj);
        obj.setAmoAsButton(new Button(obj.getName(), new ImageView(obj.getIcon())));
        obj.getAmoAsButton().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT + " -fx-text-fill: #FFF; -fx-border-color: #000;");
        obj.getAmoAsButton().setOnAction(e -> {
            focusOn(obj);
        });
        GlobalVar.adventureScene.getInventoryVBox().getChildren().add(obj.getAmoAsButton());
    }

    @Override
    public void onEquip(Obj obj) {
        util.TextUtils.whiteText("Вы экипировали " + obj.getName() + "!");
    }

    @Override
    public void onUnequip(Obj obj) {
        util.TextUtils.whiteText("Вы сняли " + obj.getName() + "!");
    }

    /////////////////////////////////
    //            ACTION           //
    /////////////////////////////////

    public void focusOn(Mob mob) {
        GlobalVar.adventureScene.getGeneralActionPane().getChildren().clear();
        GlobalVar.adventureScene.getGeneralActionPane().addNewAttackActionButton(new Button("Атаковать " + mob.tryToGetRealName()), attackEvent -> {
            GlobalVar.adventureScene.getPlayer().attackOrGetCloser(mob, GlobalVar.adventureScene.getPlayer().getActiveWeapon());
            GlobalVar.adventureScene.updateGeneralActionPane();
        });

        if (getFocusedOn() != null && getFocusedOn().getAmoAsButton() != null) {
            getFocusedOn().getAmoAsButton().setStyle(getFocusedOn().getAmoAsButton().getStyle().replaceAll("-fx-border-color: #.{1,6};", "-fx-border-color: #000;"));
        }
        if (mob.getAmoAsButton() != null) {
            mob.getAmoAsButton().setStyle(mob.getAmoAsButton().getStyle().replaceAll("-fx-border-color: #.{1,6};", "-fx-border-color: #700;"));
        }

        super.focusOn(mob);
    }

    public void focusOn(Obj obj) {
        GlobalVar.adventureScene.getGeneralActionPane().getChildren().clear();

        GlobalVar.adventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Осмотреть: " + obj.getName()), examineEvent -> {
            util.TextUtils.whiteText(Random.pick("Да это же ", "Это ", "Похоже, что это ") + obj.getName() + ". " + obj.getDescription());
        });

        if (getActiveWeapon() == obj || getActiveClothing() == obj && obj.isDroppable()) {
            GlobalVar.adventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Снять"), equipEvent -> {
                obj.unequipFrom(this);
                GlobalVar.adventureScene.updateGeneralActionPane();
            });
        } else if (obj.isEquippable()) {
            GlobalVar.adventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Экипировать"), equipEvent -> {
                obj.equipOn(this);
                GlobalVar.adventureScene.updateGeneralActionPane();
            });
        }
        if (obj instanceof Usable) {
            GlobalVar.adventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Использовать"), equipEvent -> {
                ((Usable) obj).use();
                GlobalVar.adventureScene.updateGeneralActionPane();
            });
        }

        GlobalVar.adventureScene.getGeneralActionPane().addNewObjInteractionButton(new Button("Выбросить"), equipEvent -> {
            getLocation().moveObjToInventory(obj);
            util.TextUtils.whiteText("Вы выбросили " + obj.getName() + "!");
            focusOn(getLocation());
        });

        if (getFocusedOn() != null && getFocusedOn().getAmoAsButton() != null) {
            getFocusedOn().getAmoAsButton().setStyle(getFocusedOn().getAmoAsButton().getStyle().replaceAll(GlobalVar.REGEX_BORDER_COLOR, "-fx-border-color: #000;"));
        }
        if (obj.getAmoAsButton() != null) {
            obj.getAmoAsButton().setStyle(obj.getAmoAsButton().getStyle().replaceAll(GlobalVar.REGEX_BORDER_COLOR, "-fx-border-color: #700;"));
        }

        super.focusOn(obj);
    }

    public void focusOn(Area area) {
        GlobalVar.adventureScene.getGeneralActionPane().getChildren().clear();
        GlobalVar.adventureScene.getGeneralActionPane().addNewLootActionButton(new Button("Обыскать " + area.getName()), lootEvent -> {
            getLocation().onPlayerAction();
            // I know this is terrible and inefficient, but ConcurrentModificationException ruins everything!
            ArrayList<Obj> allLoot = area.getInventory();
            if (allLoot.size() < 1) {
                util.TextUtils.whiteText("Ничегошеньки тут нет!");
                return;
            }
            while (allLoot.size() > 0) {
                Obj loot = allLoot.get(0);
                util.TextUtils.greenText(Random.pick("", "", "Ага! ", "О! ", "Ну вот. ") + "Вы нашли " + loot.getName() + ".");
                moveObjToInventory(loot);
            }
            GlobalVar.adventureScene.updateGeneralActionPane();
        });

        if (getFocusedOn() != null && getFocusedOn().getAmoAsButton() != null) {
            getFocusedOn().getAmoAsButton().setStyle(getFocusedOn().getAmoAsButton().getStyle().replaceAll(GlobalVar.REGEX_BORDER_COLOR, "-fx-border-color: #000;"));
        }

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

    @Override
    public boolean die() {
        if (!super.die()) {
            return false;
        }
        AlertBox alertBox = new AlertBox();
        alertBox.display("Ой!", "Вы проиграли!", "Выйти в главное меню.", 300, 200, actionEvent -> {
            GlobalVar.mainStage.setScene(GlobalVar.mainMenuScene);
            alertBox.close();
        });
        return true;
    }

    public void updateHealthIcon() {
        healthStatIcon.setImage(new Image(getClass().getResourceAsStream("/icons/stats/health/health" + util.Misc.round(getHealth() + 9, 20) + ".png")));
    }

    /////////////////////////////////
    //             MISC            //
    /////////////////////////////////

    @Override
    public void reactToTheAtmosphere() {
        switch (getLocation().getAtmosphereType()) {
            case HOT:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Как здесь жарко-то!");
                }
                break;
            case COLD:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Как здесь холодно-то!");
                }
                break;
            case PHORON:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {

                }
                util.TextUtils.redText("Воздух розовенький...");
                break;
            case VACUUM:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Все тело колит, я не могу дышать!");
                }
                break;
            case OXYGENOUS:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Как здесь легко дышать! Только голова кружится немного...");
                }
                break;
            case SLEEP_GAS:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Сегодня был такой сложный день, как же мне хочется отдохнуть...");
                }
                break;
            case LOW_PRESSURE:
                if (!getActiveClothing().protectsFrom(getLocation().getAtmosphereType())) {
                    util.TextUtils.redText("Как здесь СЛОЖНО дышать, а моя голова просто раскалывается!");
                }
                break;
            case UNBREATHABLE:
                util.TextUtils.redText("Здесь же нечем дышать!");
                break;
            case EXTREMELY_HOT:
                util.TextUtils.redText("А-А-А-А-А! МОЯ КОЖА ПРОСТО ГОРИ-И-И-Т!");
                break;
            case HIGH_PRESSURE:
                break;
            case EXTREMELY_COLD:
                util.TextUtils.redText("КАК ЖЕ ЗДЕСЬ ХОЛОДНО! ВСЕ МОЕ ТЕЛО ПОКАЛЫВАЕТ!");
                break;
        }
        super.reactToTheAtmosphere();
    }

    public StringBuilder generateIntroductoryStory() {
        StringBuilder coolStory = new StringBuilder();
        coolStory.append("Вы, ");
        coolStory.append(getAge()).append(" летн").append(getGender() == Gender.FEMALE ? "яя " : "ий ");
        coolStory.append(getName()).append(" по имени ").append(getRealName());
        coolStory.append(", - ");
        coolStory.append("обычный ").append("технический ассистент"); // TODO
        coolStory.append(", работающий в месте под названием \"");
        coolStory.append("Научно-исследовательская станция \"Исход\"\""); // TODO
        coolStory.append(". Сидя в одиночестве на мягком кресле в инженерном отделе, "); // TODO
        coolStory.append("вы осознаете, что этот отсек совсем не похож на тот, где вы привыкли работать. Вы даже не можете вспомнить, как вы сюда попали. Пока вы размышляли, вы кое-что услышали: холодный, женский, машинный, синтезированный голос делает очередное объявление, но вы не можете понять ни слова, хотя они кажутся вам навязчиво знакомыми. Попытки связаться с экипажем через наушник и даже через рацию не увенчались успехом - вас, возможно, попросту игнорируют. Вы решаетесь узнать в чем дело самостоятельно. ");
        coolStory.append("Вы не знаете куда точно направляетесь, но вам определенно стоит найти кого-нибудь для обсуждения ситуации на станции. Быть может, стоит начать с бара? Или с медотсека...");
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
