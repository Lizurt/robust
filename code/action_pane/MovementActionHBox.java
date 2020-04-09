package action_pane;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class MovementActionHBox extends TilePane {

    public void addNewActionButton(Button button) {
        if (getChildren().size() >= 4) {
            return;
        }
        super.getChildren().add(button);
    }
}
