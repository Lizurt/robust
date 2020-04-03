import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainStage extends Stage {

    private Stage mainStage;

    public MainStage(Stage newMainStage) {
        mainStage = newMainStage;
        initScenes();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void initScenes() {
        createAdventureScene();
    }

    public void createAdventureScene() {
        GridPane mainGridPane = new GridPane();
        mainGridPane.setGridLinesVisible(true);
        /*
            Output  EnemyIcon   ENEMYSTATS
            Input   Inventory   PlayerStats
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

        TextArea textAreaOutput = new TextArea();
        textAreaOutput.setEditable(false);
        mainGridPane.add(textAreaOutput, 0, 0);

        FlowPane inputPane = new FlowPane();
        mainGridPane.add(inputPane, 0, 1);

        VBox inventoryVBox = new VBox();
        mainGridPane.add(inventoryVBox, 1, 1);

        VBox playerStatsVBox = new VBox();
        mainGridPane.add(playerStatsVBox, 2, 1);

        Label labelEnemyIcon = new Label();
        mainGridPane.add(labelEnemyIcon, 1, 0);

        Label labelEnemyStats = new Label();
        mainGridPane.add(labelEnemyStats, 2, 0);

        GlobalVar.adventureScene = new Scene(mainGridPane, GlobalVar.windowWidth, GlobalVar.windowHeight);

    }
}
