package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene/DoctorScene.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            Scene scene = new Scene(employeeOperationsView);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Software Quality Assurance Project");

        //2) Display the EmployeeOperations View
        showEmployeeView();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
