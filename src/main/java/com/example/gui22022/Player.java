package com.example.gui22022;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Player {
    private int x, y;
    Image image;

    public Player(String path, int x, int y) {
        this.x = x;
        this.y = y;

        //load and/or create character data file
        File imageFile = new File(path);
        if(!imageFile.exists()) {
            try {
                imageFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //load external resources
        try {
            image = new Image(new FileInputStream("src/main/resources/com/example/gui22022/guy.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not load player Image");
        }
    }

    public void moveUp(){
        y -= 1;
    }

    public void moveDown(){
        y += 1;
    }

    public void moveRight(){
        x += 1;
    }

    public void moveLeft(){
        x -= 1;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,x,y);
    }


}
