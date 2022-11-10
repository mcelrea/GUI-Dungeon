package com.example.gui22022;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button editNameButton;
    @FXML
    private TextField nameField;
    @FXML
    private Canvas gameCanvas;
    @FXML
    private Label nameLabel;
    @FXML
    private Button strengthRollButton, dexterityRollButton, intelligenceRollButton, constitutionRollButton, charismaRollButton, wisdomRollButton;
    @FXML
    private Label strengthValueLabel, dexterityValueLabel, intelligenceValueLabel, constitutionValueLabel, charismaValueLabel, wisdomValueLabel;

    int x=100, y=100;

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        nameField.setEditable(false);
        nameField.setVisible(false);

        AnimationTimer anim = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.clearRect(0,0,800,600);
                gc.setFill( Color.RED );
                gc.setStroke( Color.BLACK );
                gc.setLineWidth(2);
                gc.fillText( "No Character", x, y );
                gc.fillText( "Create Character", x, y+100 );
            }
        };

        anim.start();

    }

    @FXML
    protected void setEditNameButtonClick() {
        String buttonText = editNameButton.getText();
        if(buttonText.equals("Edit")) {
            editNameButton.setText("Save");
            editNameButton.setLayoutX(300);
            nameLabel.setVisible(false);
            nameField.setVisible(true);
            nameField.setEditable(true);
        }
        else if(buttonText.equals("Save")) {
            editNameButton.setText("Edit");
            editNameButton.setLayoutX(175);
            nameLabel.setVisible(true);
            nameField.setVisible(false);
            nameField.setEditable(false);
            nameLabel.setText(nameField.getText());
        }
    }

    protected int rolld20() {
        return (int)(1 + Math.random() * 20);
    }

    @FXML
    protected void onRollButton(ActionEvent event) {
        Button b = (Button)event.getSource();

        if(b == strengthRollButton) {
            strengthValueLabel.setText("" + rolld20());
        }
        else if(b == dexterityRollButton) {
            dexterityValueLabel.setText("" + rolld20());
        }
        else if(b == constitutionRollButton) {
            constitutionValueLabel.setText("" + rolld20());
        }
        else if(b == intelligenceRollButton) {
            intelligenceValueLabel.setText("" + rolld20());
        }
        else if(b == wisdomRollButton) {
            wisdomValueLabel.setText("" + rolld20());
        }
        else if(b == charismaRollButton) {
            charismaValueLabel.setText("" + rolld20());
        }
    }//end onRollButton

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}