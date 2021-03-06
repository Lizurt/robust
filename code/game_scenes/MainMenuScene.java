package game_scenes;

import amo.area.Area;
import amo.area.AtmosphereType;
import amo.area.types.engineering.EngineeringLobby;
import amo.mob.humanoid.player.Player;
import game_scenes.adventure_scene.AdventureScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.GlobalVar;

public class MainMenuScene extends Scene {

    public MainMenuScene(VBox mainVBox) {
        super(mainVBox, GlobalVar.windowWidth, GlobalVar.windowHeight);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        Label robustLabel = new Label("ROBUST");
        robustLabel.setStyle("-fx-font-size: 140px; -fx-font-weight: 900; -fx-text-fill: #7f2526");
        mainVBox.getChildren().add(robustLabel);

        initNewMainMenuButton(mainVBox, "Начать игру", e -> {
            GlobalVar.adventureScene = new AdventureScene(new GridPane());
            GlobalVar.mainStage.setScene(GlobalVar.adventureScene);
            Area startArea = new EngineeringLobby();
            startArea.setAtmosphereType(AtmosphereType.NORMAL);
            startArea.getInventory().clear();
            startArea.getMobs().clear();
            GlobalVar.adventureScene.setPlayer(new Player(startArea));
            GlobalVar.adventureScene.getTextAreaOutput().clear();
            util.TextUtils.whiteBoldText(GlobalVar.adventureScene.getPlayer().generateIntroductoryStory().toString());
        });

        initNewMainMenuButton(mainVBox, "Справочник", e -> {

        });

        initNewMainMenuButton(mainVBox, "Настройки игры", e -> {

        });

        initNewMainMenuButton(mainVBox, "Выход", e -> {
            GlobalVar.mainStage.close();
        });

        GlobalVar.mainMenuScene = this;
    }

    private void initNewMainMenuButton(Pane pane, String name, EventHandler<ActionEvent> clickEvent) {
        Button button = new Button(name);
        button.setPrefWidth((int) (GlobalVar.windowWidth * 0.9));
        button.setPrefHeight((int) (GlobalVar.windowHeight * 0.1));
        button.setStyle("-fx-background-color: #223; -fx-text-fill: #FFF; -fx-border-color: #000; -fx-font-size: 30px;");

        button.setOnAction(clickEvent);
        button.setOnMouseEntered(mouseEnteredEvent -> button.setStyle(button.getStyle().replaceAll(GlobalVar.REGEX_BACKGROUND_COLOR, "-fx-background-color: #112;")));
        button.setOnMouseExited(mouseExitedEvent -> button.setStyle(button.getStyle().replaceAll(GlobalVar.REGEX_BACKGROUND_COLOR, "-fx-background-color: #223;")));

        pane.getChildren().add(button);
    }

}
