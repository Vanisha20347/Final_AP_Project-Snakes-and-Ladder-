package com.example.snakenladders;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage1) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        Scene scene1 = new Scene(root); //(firstnode,stagewidth,stageheight,stage background)
        stage1.setScene(scene1);
        stage1.show();
    }
}