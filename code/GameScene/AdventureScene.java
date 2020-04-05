package GameScene;

import aom.mob.humanoid.player.Player;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.fxmisc.richtext.InlineCssTextArea;
import util.GlobalVar;
import util.Random;

public class AdventureScene extends Scene {
    private Player player = new Player(Random.pick(GlobalVar.allowedMaleHumanRealName));

    private InlineCssTextArea textAreaOutput = new InlineCssTextArea();
    private FlowPane actionPane = new FlowPane();
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
                new ColumnConstraints(GlobalVar.windowWidth - 250),
                new ColumnConstraints(200, 200, 200),
                new ColumnConstraints(50, 50, 50)
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

        mainGridPane.add(getActionPane(), 0, 1);
        getActionPane().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getInventoryVBox(), 1, 1);
        getInventoryVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle("-fx-background-color: #2A2526");

        mainGridPane.add(getLabelEnemyIcon(), 1, 0);

        mainGridPane.add(getLabelEnemyStats(), 2, 0);
    }

    public InlineCssTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public FlowPane getActionPane() {
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
}
