package com.hospital.version1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFxTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("¡JavaFX está funcionando!");
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prueba JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
