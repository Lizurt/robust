package game_scene;

import action_pane.GeneralActionPane;
import action_pane.MovementActionHBox;
import amo.area.types.engineering.EngineeringLobby;
import amo.mob.Mob;
import amo.mob.humanoid.player.Player;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import org.fxmisc.richtext.InlineCssTextArea;
import util.GlobalVar;
import javafx.scene.control.ScrollPane;

public class AdventureScene extends Scene {
    private static Player player;

    private static InlineCssTextArea textAreaOutput = new InlineCssTextArea();
    private static MovementActionHBox movementActionHBox = new MovementActionHBox();
    private static GeneralActionPane generalActionPane = new GeneralActionPane();
    private static VBox inventoryVBox = new VBox();
    private static VBox playerStatsVBox = new VBox();
    private static GridPane paneEnemyIcon = new GridPane();
    private static VBox VBoxEnemyStats = new VBox();

    public AdventureScene(GridPane mainGridPane) {
        super(mainGridPane, GlobalVar.windowWidth, GlobalVar.windowHeight);
        /*

            textAreaOutput    | paneEnemyIcon | VBoxEnemyStats
            action & movement | inventoryVBox | playerStatsVBox

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

        mainGridPane.setStyle("-fx-background-color: #2A2526;");

        // output text
        mainGridPane.add(getTextAreaOutput(), 0, 0);
        getTextAreaOutput().setStyle("-fx-background-color: #2A2526;");
        getTextAreaOutput().setWrapText(true);
        getTextAreaOutput().setEditable(false);

        // movement & action inside the actionVBox
        VBox actionVBox = new VBox();
        getMovementActionHBox().setStyle("-fx-background-color: #2A2526;");
        actionVBox.getChildren().add(movementActionHBox);
        getGeneralActionPane().setStyle("-fx-background-color: #2A2526;");
        actionVBox.getChildren().add(getGeneralActionPane());

        mainGridPane.add(actionVBox, 0, 1);

        // player's inventory
        ScrollPane inventoryScrollPane = new ScrollPane(getInventoryVBox());
        inventoryScrollPane.setStyle("-fx-background: #2A2526; -fx-border-color: #2A2526;");
        mainGridPane.add(inventoryScrollPane, 1, 1);
        getInventoryVBox().setStyle("-fx-background-color: #2A2526;");

        // player's stats
        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle("-fx-background-color: #2A2526;");

        // enemy grid
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
        getPaneEnemyIcon().setStyle("-fx-background-color: #2A2526;");

        // enemy stats
        mainGridPane.add(getVBoxEnemyStats(), 2, 0);
        getVBoxEnemyStats().setStyle("-fx-background-color: #2A2526;");

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

    public static GeneralActionPane getGeneralActionPane() {
        return generalActionPane;
    }
}
