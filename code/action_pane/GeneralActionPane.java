package action_pane;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class GeneralActionPane extends TilePane {

    public void addNewActionButton(Button button) {
        if (getChildren().size() >= 16) {
            return;
        }
        super.getChildren().add(button);
    }

}
