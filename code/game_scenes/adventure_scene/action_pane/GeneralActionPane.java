package game_scenes.adventure_scene.action_pane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class GeneralActionPane extends TilePane {

    public void addNewActionButton(Button button, EventHandler<ActionEvent> event, String style) {
        if (getChildren().size() >= 16) {
            return;
        }
        button.setOnAction(event);
        button.setStyle(style);
        super.getChildren().add(button);
    }

    public void addNewAttackActionButton(Button button, EventHandler<ActionEvent> event) {
        addNewActionButton(button, event, "-fx-background-color: #200; -fx-text-fill: #fff");
    }

    public void addNewLootActionButton(Button button, EventHandler<ActionEvent> event) {
        addNewActionButton(button, event, "-fx-background-color: #220; -fx-text-fill: #fff");
    }

    public void addNewObjInteractionButton(Button button, EventHandler<ActionEvent> event) {
        addNewActionButton(button, event, "-fx-background-color: #222; -fx-text-fill: #fff");
    }
}
