import GameScene.AdventureScene;
import GameScene.MainMenuScene;
import GameScene.PauseMenuScene;
import aom.mob.humanoid.player.Player;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.GlobalVar;
import util.Random;

public class MainStage extends Stage {

    private Stage mainStage;
    private AdventureScene adventureScene;
    private MainMenuScene mainMenuScene;
    private PauseMenuScene pauseMenuScene;

    public MainStage(Stage newMainStage) {
        mainStage = newMainStage;
        initScenes();
        adventureScene.setPlayer(new Player(adventureScene, Random.pick(GlobalVar.allowedMaleHumanRealName)));
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void initScenes() {
        adventureScene = new GameScene.AdventureScene(new GridPane());
        mainMenuScene = new GameScene.MainMenuScene(new GridPane());
        pauseMenuScene = new GameScene.PauseMenuScene(new GridPane());
    }

    public void startAdventureScene() {
        setScene(adventureScene);
        adventureScene.getTextAreaOutput().clear();
        util.TextUtils.neutralEventText(adventureScene.getTextAreaOutput(), adventureScene.getPlayer().generateIntroductoryStory().toString());
    }

}
