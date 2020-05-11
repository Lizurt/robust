import game_scenes.adventure_scene.AdventureScene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.GlobalVar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GlobalVar.mainStage = primaryStage;
        primaryStage.setTitle("Robust");
        primaryStage.setResizable(false);

        new game_scenes.PauseMenuScene(new GridPane());
        new AdventureScene(new GridPane());
        primaryStage.setScene(new game_scenes.MainMenuScene(new VBox()));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
