import GameScene.AdventureScene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Robust");
        primaryStage.setResizable(false);

        new GameScene.MainMenuScene(new GridPane());
        new GameScene.PauseMenuScene(new GridPane());
        primaryStage.setScene(new GameScene.AdventureScene(new GridPane()));
        AdventureScene.getTextAreaOutput().clear();
        util.TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), AdventureScene.getPlayer().generateIntroductoryStory().toString());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
