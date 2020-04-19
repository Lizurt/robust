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

        new game_scene.PauseMenuScene(new GridPane());
        new game_scene.AdventureScene(new GridPane());
        primaryStage.setScene(new game_scene.MainMenuScene(new VBox()));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
