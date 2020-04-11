package game_scene;

import action_pane.GeneralActionPane;
import action_pane.MovementActionHBox;
import amo.area.types.engineering.EngineeringLobby;
import amo.mob.Mob;
import amo.mob.humanoid.player.Player;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.fxmisc.richtext.InlineCssTextArea;
import util.GlobalVar;

public class AdventureScene extends Scene {
    private static Player player;

    private static InlineCssTextArea textAreaOutput = new InlineCssTextArea();
    private static MovementActionHBox movementActionHBox = new MovementActionHBox();
    private static GeneralActionPane actionPane = new GeneralActionPane();
    private static VBox inventoryVBox = new VBox();
    private static VBox playerStatsVBox = new VBox();
    private static GridPane paneEnemyIcon = new GridPane();
    private static VBox VBoxEnemyStats = new VBox();

    public AdventureScene(GridPane mainGridPane) {
        super(mainGridPane, GlobalVar.windowWidth, GlobalVar.windowHeight);
        /*
            textAreaOutput  labelEnemyIcon  labelEnemyStats
            actionPane      inventoryVBox   playerStatsVBox
         */
        mainGridPane.getColumnConstraints().addAll(
                new ColumnConstraints(GlobalVar.windowWidth - 224),
                new ColumnConstraints(192, 192, 192),
                new ColumnConstraints(32, 32, 32)
        );
        mainGridPane.getRowConstraints().addAll(
                new RowConstraints(util.Misc.round(GlobalVar.windowHeight * 0.5, 64)),
                new RowConstraints(util.Misc.round(GlobalVar.windowHeight * 0.5, 64))
        );

        mainGridPane.setStyle("-fx-background-color: #2A2526");
        mainGridPane.setGridLinesVisible(true);

        mainGridPane.add(getTextAreaOutput(), 0, 0);
        getTextAreaOutput().setStyle("-fx-background-color: #2A2526");
        getTextAreaOutput().setWrapText(true);
        getTextAreaOutput().setEditable(false);

        VBox actionVBox = new VBox();
        movementActionHBox.setStyle("-fx-background-color: #2A2526");
        actionVBox.getChildren().add(movementActionHBox);
        getActionPane().setStyle("-fx-background-color: #2A2526");
        actionVBox.getChildren().add(getActionPane());

        mainGridPane.add(actionVBox, 0, 1);
        getMovementActionHBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getInventoryVBox(), 1, 1);
        getInventoryVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle("-fx-background-color: #2A2526");

        getPaneEnemyIcon().getColumnConstraints().addAll(
                new ColumnConstraints(64, 64, 64),
                new ColumnConstraints(64, 64, 64),
                new ColumnConstraints(64, 64, 64)
        );
        getPaneEnemyIcon().getRowConstraints().addAll(
                new RowConstraints(64, 64, 64),
                new RowConstraints(64, 64, 64),
                new RowConstraints(64, 64, 64)
        );

        mainGridPane.add(getPaneEnemyIcon(), 1, 0);

        mainGridPane.add(getVBoxEnemyStats(), 2, 0);

        player = new Player(new EngineeringLobby());
    }

    public static void updatePaneEnemyIcon() {
        getPaneEnemyIcon().getChildren().clear();
        for (Mob mob : getPlayer().getLocation().getMobs()) {
            mob.generateFocusOnButton();
        }
    }

    public static InlineCssTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public static MovementActionHBox getMovementActionHBox() {
        return movementActionHBox;
    }

    public static VBox getInventoryVBox() {
        return inventoryVBox;
    }

    public static VBox getPlayerStatsVBox() {
        return playerStatsVBox;
    }

    public static GridPane getPaneEnemyIcon() {
        return paneEnemyIcon;
    }

    public static VBox getVBoxEnemyStats() {
        return VBoxEnemyStats;
    }

    public static Player getPlayer() {
        return player;
    }

    public static GeneralActionPane getActionPane() {
        return actionPane;
    }
}
