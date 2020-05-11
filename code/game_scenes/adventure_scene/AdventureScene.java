package game_scenes.adventure_scene;

import amo.Amo;
import amo.area.Area;
import amo.mob.Mob;
import amo.mob.humanoid.player.Player;
import amo.obj.Obj;
import game_scenes.adventure_scene.action_pane.GeneralActionPane;
import game_scenes.adventure_scene.action_pane.MovementActionHBox;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import org.fxmisc.richtext.InlineCssTextArea;
import util.GlobalVar;

public class AdventureScene extends Scene {
    private Player player;

    private InlineCssTextArea textAreaOutput = new InlineCssTextArea();
    private MovementActionHBox movementActionHBox = new MovementActionHBox();
    private GeneralActionPane generalActionPane = new GeneralActionPane();
    private VBox inventoryVBox = new VBox();
    private VBox playerStatsVBox = new VBox();
    private GridPane paneEnemyIcon = new GridPane();
    private VBox VBoxEnemyStats = new VBox();

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
        int roundedHalfHeight = util.Misc.round((int) (GlobalVar.windowHeight * 0.5), 64);
        mainGridPane.getRowConstraints().addAll(
                new RowConstraints(roundedHalfHeight),
                new RowConstraints(GlobalVar.windowHeight - roundedHalfHeight)
        );

        mainGridPane.setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        // output text
        mainGridPane.add(getTextAreaOutput(), 0, 0);
        getTextAreaOutput().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);
        getTextAreaOutput().setWrapText(true);
        getTextAreaOutput().setEditable(false);

        // movement & action inside the actionVBox
        VBox actionVBox = new VBox();
        getMovementActionHBox().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);
        actionVBox.getChildren().add(movementActionHBox);
        getGeneralActionPane().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);
        actionVBox.getChildren().add(getGeneralActionPane());

        mainGridPane.add(actionVBox, 0, 1);

        // player's inventory
        ScrollPane inventoryScrollPane = new ScrollPane(getInventoryVBox());
        inventoryScrollPane.setStyle("-fx-background: #2A2526; -fx-border-color: #2A2526;");
        mainGridPane.add(inventoryScrollPane, 1, 1);
        getInventoryVBox().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        // player's stats
        mainGridPane.add(getPlayerStatsVBox(), 2, 1);
        getPlayerStatsVBox().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        // enemy grid
        int paneEnemyIconSize = 192;
        getPaneEnemyIcon().setPrefSize(paneEnemyIconSize, paneEnemyIconSize);
        getPaneEnemyIcon().setMaxSize(paneEnemyIconSize, paneEnemyIconSize);
        getPaneEnemyIcon().setMinSize(paneEnemyIconSize, paneEnemyIconSize);
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
        getPaneEnemyIcon().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT + " -fx-border-color: #000;");
        mainGridPane.add(getPaneEnemyIcon(), 1, 0);

        // enemy stats
        mainGridPane.add(getVBoxEnemyStats(), 2, 0);
        getVBoxEnemyStats().setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        GlobalVar.adventureScene = this;
    }

    public void updateGeneralActionPane() {
        getGeneralActionPane().getChildren().clear();
        Amo focusedOn = getPlayer().getFocusedOn();
        if (focusedOn instanceof  Mob) {
            getPlayer().focusOn((Mob) getPlayer().getFocusedOn());
            return;
        }
        if (focusedOn instanceof Obj) {
            getPlayer().focusOn((Obj) getPlayer().getFocusedOn());
            return;
        }
        if (focusedOn instanceof Area) {
            getPlayer().focusOn((Area) getPlayer().getFocusedOn());
        }
    }

    public void updatePaneEnemyIcon() {
        getPaneEnemyIcon().getChildren().clear();
        for (Mob mob : getPlayer().getLocation().getMobs()) {
            if (mob.getAmoAsButton() == null) {
                continue;
            }
            getPaneEnemyIcon().add(mob.getAmoAsButton(), mob.getPosition()[1] - 1, mob.getPosition()[0] - 1);
        }
    }

    public InlineCssTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public MovementActionHBox getMovementActionHBox() {
        return movementActionHBox;
    }

    public VBox getInventoryVBox() {
        return inventoryVBox;
    }

    public VBox getPlayerStatsVBox() {
        return playerStatsVBox;
    }

    public GridPane getPaneEnemyIcon() {
        return paneEnemyIcon;
    }

    public VBox getVBoxEnemyStats() {
        return VBoxEnemyStats;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public GeneralActionPane getGeneralActionPane() {
        return generalActionPane;
    }

}
