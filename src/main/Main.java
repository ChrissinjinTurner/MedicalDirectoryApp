package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Software Quality Assurance Project");
        showLoginView();
    }

    private void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene/LoginScene.fxml"));
            prepScene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene/DoctorScene.fxml"));
            prepScene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepScene(Parent parent) {
        Scene myScene = new Scene(parent);
        primaryStage.setScene(myScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
