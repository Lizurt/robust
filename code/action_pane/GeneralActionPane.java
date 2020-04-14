package action_pane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class GeneralActionPane extends TilePane {

    public void addNewActionButton(Button button, EventHandler<ActionEvent> event, String style) {
        if (getChildren().size() >= 16) {
            return;
        }
        button.setStyle(style);
        super.getChildren().add(button);
    }

    public void addNewAttackActionButton(Button button, EventHandler<ActionEvent> event) {
        addNewActionButton(button, event, "-fx-background-color: #003300");
    }

    public void addNewLootActionButton(Button button, EventHandler<ActionEvent> event) {
        addNewActionButton(button, event, "-fx-background-color: #2b2911");
    }
}
