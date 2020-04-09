import game_scene.AdventureScene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Robust");
        primaryStage.setResizable(false);

        new game_scene.MainMenuScene(new GridPane());
        new game_scene.PauseMenuScene(new GridPane());
        primaryStage.setScene(new game_scene.AdventureScene(new GridPane()));
        AdventureScene.getTextAreaOutput().clear();
        util.TextUtils.neutralEventText(AdventureScene.getTextAreaOutput(), AdventureScene.getPlayer().generateIntroductoryStory().toString());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
