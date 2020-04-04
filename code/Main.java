import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainStage mainStage = new MainStage(primaryStage);
        mainStage.setTitle("Robust");
        mainStage.setResizable(false);

        mainStage.startAdventureScene();
        mainStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
