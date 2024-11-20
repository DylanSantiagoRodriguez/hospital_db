package com.hospital.version1;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class Version1Application extends Application {

    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        // Usa la nueva clase SpringBootMain para inicializar Spring Boot
        context = new SpringApplicationBuilder(SpringBootMain.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Obtén un controlador gestionado por Spring para iniciar la interfaz
        context.getBean(JavaFxController.class).start(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }
}
