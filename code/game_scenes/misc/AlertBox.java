package game_scenes.misc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.GlobalVar;

public class AlertBox {
    private Stage window = new Stage();

    public void display(String title, String message, String closeButtonText, int width, int height, EventHandler<ActionEvent> actionEvent) {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        window.setHeight(height);
        window.setWidth(width);
        window.setResizable(false);

        Label labelMessage = new Label(message);
        labelMessage.setStyle("-fx-text-fill: #fff; -fx-font-size: 24px;");

        Button buttonOK = new Button(closeButtonText);
        buttonOK.setOnAction(actionEvent);
        buttonOK.setStyle("-fx-background-color: #223; -fx-text-fill: #fff; -fx-border-color: #000; -fx-font-size: 20px;");

        VBox layout = new VBox(32);
        layout.getChildren().addAll(labelMessage, buttonOK);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle(GlobalVar.STYLE_BACKGROUND_COLOR_DEFAULT);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }

    public void display(String title, String message, String closeButtonText, int width, int height) {
        display(title, message, closeButtonText, width, height, actionEvent -> close());
    }

    public void display(String title, String message, String closeButtonText) {
        display(title, message, closeButtonText, 300, 200);
    }

    public void display(String title, String message) {
        display(title, message, "OK");
    }

    public void close() {
        window.close();
        window = null;
    }

}
