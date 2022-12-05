package com.example.gui22022;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene scene;

    public static HashSet<String> currentlyActiveKeys;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        prepareActionHandlers();

        stage.show();
    }

    public static File openSaveDialog() {
        File recordsDir = new File(System.getProperty("user.home"), "/DungeonJavaFX/records");
        if (!recordsDir.exists()) {
            recordsDir.mkdirs();
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(recordsDir);
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All File", "*.*"));
        File file = fileChooser.showSaveDialog(stage);
        return file;
    }

    public static File openLoadDialog() {
        File recordsDir = new File(System.getProperty("user.home"), "/DungeonJavaFX/records");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(recordsDir);
        fileChooser.setTitle("Open");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All File", "*.deg"));
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }

    private static void prepareActionHandlers() {
        currentlyActiveKeys = new HashSet<String>();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                currentlyActiveKeys.add(event.getCode().toString());

            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                currentlyActiveKeys.remove(event.getCode().toString());

            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}