package com.murach.mpg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MpgApp extends Application {

    @Override
    public void start(Stage stage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> buttonClicked());
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }
    
    private void buttonClicked() {
        System.out.println("Hello World!");           
    }

    public static void main(String[] args) {
        launch();
    }

}