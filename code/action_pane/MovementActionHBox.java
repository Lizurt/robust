package action_pane;

import amo.area.Area;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import util.Random;

public class MovementActionHBox extends TilePane {

    public void addNewActionButton(Button button, EventHandler<ActionEvent> event, String style) {
        if (getChildren().size() >= 4) {
            return;
        }
        button.setStyle(style);
        button.setOnAction(event);
        super.getChildren().add(button);
    }

    public void addNewActionButton(Button button, EventHandler<ActionEvent> event, Area wayOut) {
        String style = "-fx-background-color: #5c5869"; // TODO: unpowered: #3a3637
        switch(wayOut.getAtmosphereType()) {
            case VACUUM:
            case PHORON:
            case EXTREMELY_COLD:
            case EXTREMELY_HOT:
                style = Random.prob(80) ? "-fx-background-color: #5d2526" : "-fx-background-color: #4c4726";
                break;
            case OXYGENOUS:
            case HOT:
            case COLD:
            case UNBREATHABLE:
            case LOW_PRESSURE:
            case HIGH_PRESSURE:
            case SLEEP_GAS:
                style = Random.prob(20) ? "-fx-background-color: #5d2526" : "-fx-background-color: #4c4726";
            default:
                if (Random.prob(3)) {
                    style = "-fx-background-color: #5d2526";
                } else if (Random.prob(6)) {
                    style = "-fx-background-color: #4c4726";
                }
        }
        addNewActionButton(button, event, style);
    }
}
