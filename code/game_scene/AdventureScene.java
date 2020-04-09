package game_scene;

import action_pane.GeneralActionPane;
import action_pane.MovementActionHBox;
import amo.area.types.engineering.EngineeringLobby;
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
    private static Label labelEnemyIcon = new Label();
    private static Label labelEnemyStats = new Label();

    public AdventureScene(GridPane mainGridPane) {
        super(mainGridPane, GlobalVar.windowWidth, GlobalVar.windowHeight);
        /*
            textAreaOutput  labelEnemyIcon  labelEnemyStats
            actionPane      inventoryVBox   playerStatsVBox
         */
        mainGridPane.getColumnConstraints().addAll(
                new ColumnConstraints(GlobalVar.windowWidth - 160),
                new ColumnConstraints(128, 128, 128),
                new ColumnConstraints(32, 32, 32)
        );
        mainGridPane.getRowConstraints().addAll(
                new RowConstraints(Math.round(GlobalVar.windowHeight * 0.5)),
                new RowConstraints(Math.round(GlobalVar.windowHeight * 0.5))
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
        actionPane.setStyle("-fx-background-color: #2A2526");
        actionVBox.getChildren().add(actionPane);

        mainGridPane.add(actionVBox, 0, 1);
        getMovementActionHBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getInventoryVBox(), 1, 1);
        getInventoryVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getLabelEnemyIcon(), 1, 0);

        mainGridPane.add(getLabelEnemyStats(), 2, 0);

        player = new Player(new EngineeringLobby());
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

    public static Label getLabelEnemyIcon() {
        return labelEnemyIcon;
    }

    public static Label getLabelEnemyStats() {
        return labelEnemyStats;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        AdventureScene.player = player;
    }
}
