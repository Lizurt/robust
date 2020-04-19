package game_scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.GlobalVar;

public class MainMenuScene extends Scene {

    public MainMenuScene(VBox mainVBox) {
        super(mainVBox, GlobalVar.windowWidth, GlobalVar.windowHeight);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setStyle("-fx-background-color: #2A2526;");

        Label robustLabel = new Label("ROBUST");
        robustLabel.setStyle("-fx-font-size: 140px; -fx-font-weight: 900; -fx-text-fill: #7f2526");
        mainVBox.getChildren().add(robustLabel);

        initNewMainMenuButton(mainVBox , "Начать игру", e -> {
            GlobalVar.mainStage.setScene(GlobalVar.adventureScene);
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

    private void initNewMainMenuButton(Pane pane, String name, EventHandler<ActionEvent> event) {
        Button button = new Button(name);
        button.setPrefWidth((int) (GlobalVar.windowWidth * 0.9));
        button.setPrefHeight((int) (GlobalVar.windowHeight * 0.1));
        button.setStyle("-fx-background-color: #223; -fx-text-fill: #FFF; -fx-border-color: #000; -fx-font-size: 30px;");
        button.setOnAction(event);
        pane.getChildren().add(button);
    }

}
