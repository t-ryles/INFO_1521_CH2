package com.example.ch13_ex2_pizzaorder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    // class globals
        
    @Override
    public void start(Stage stage) {
        stage.setTitle("Pizza Price Calculcator");
        GridPane grid = new GridPane();
        VBox appContainer = new VBox(10);
        
        // size
                
        // toppings
        
        // price output
                
        // calculate button
        
        grid.add(appContainer, 0, 5);
        grid.setPadding(new Insets(10, 10, 0, 10));
        Scene scene = new Scene(grid, 225, 250);
        stage.setScene(scene);
        stage.show();
    }

    public void calculatePrice(Stage stage) {
        double price = 0.0;
        // calulation code here
    }

    public static void main(String[] args) {
        launch();
    }

}