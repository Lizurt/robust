package GameScene;

import aom.area.Area;
import aom.area.types.EngineeringLobby;
import aom.mob.humanoid.player.ActionMenu;
import aom.mob.humanoid.player.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.fxmisc.richtext.InlineCssTextArea;
import util.GlobalVar;

public class AdventureScene extends Scene {
    private Player player;
    private Area currentArea;

    private InlineCssTextArea textAreaOutput = new InlineCssTextArea();
    private ActionMenu actionPane = new ActionMenu();
    private VBox inventoryVBox = new VBox();
    private VBox playerStatsVBox = new VBox();
    private Label labelEnemyIcon = new Label();
    private Label labelEnemyStats = new Label();

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

        mainGridPane.add(getActionPane(), 0, 1);
        getActionPane().setStyle("-fx-background-color: #2A2526");
        Button TodoDeleteThisButton = new Button("Бить себя");
        TodoDeleteThisButton.setOnAction(e -> player.hurt(100));
        getActionPane().getChildren().add(TodoDeleteThisButton);


        mainGridPane.add(getInventoryVBox(), 1, 1);
        getInventoryVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getLabelEnemyIcon(), 1, 0);

        mainGridPane.add(getLabelEnemyStats(), 2, 0);

        setCurrentArea(new EngineeringLobby(this));
    }

    public InlineCssTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public ActionMenu getActionPane() {
        return actionPane;
    }

    public VBox getInventoryVBox() {
        return inventoryVBox;
    }

    public VBox getPlayerStatsVBox() {
        return playerStatsVBox;
    }

    public Label getLabelEnemyIcon() {
        return labelEnemyIcon;
    }

    public Label getLabelEnemyStats() {
        return labelEnemyStats;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }
}
