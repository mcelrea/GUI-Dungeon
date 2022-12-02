package com.example.gui22022;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);

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

    public static void main(String[] args) {
        launch();
    }
}