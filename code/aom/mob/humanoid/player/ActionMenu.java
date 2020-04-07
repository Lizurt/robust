package aom.mob.humanoid.player;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class ActionMenu extends TilePane {

    private int buttonsAmount = 0;
    private final int maxButtonsAmount = 16;

    public void addNewActionButton(Button button) {
        if (buttonsAmount >= maxButtonsAmount) {
            return;
        }
        super.getChildren().add(button);
    }

}
