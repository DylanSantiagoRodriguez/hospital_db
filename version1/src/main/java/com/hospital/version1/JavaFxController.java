package com.hospital.version1;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFxController {

    @FXML
    private Label greetingLabel;

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
        AnchorPane root = loader.load();
        
        JavaFxController controller = loader.getController();
        controller.setGreeting("Bienvenido al sistema de gestión hospitalaria");

        primaryStage.setTitle("Hospital Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setGreeting(String greeting) {
        greetingLabel.setText(greeting);
    }
}