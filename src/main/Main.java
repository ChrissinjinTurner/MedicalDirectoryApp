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


//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String firstName = "Chris";
//        String lastName = "Carrillo";
//        String gender = "Male";
//        String ssn = "123-45-6789";
//        String dob = "01/23/1997";
//        double weight = 185.0;
//        double height = 69.0;
//        Employee doctor = EmployeeDAO.getEmployee(1);
//        Employee nurse = EmployeeDAO.getEmployee(2);
//        String currentCondition = "Healthy";
//
//        PatientDAO.addPatient(firstName, lastName, gender, ssn, dob, weight, height, 1, 234, currentCondition);
//        PatientDAO.editPatient(1, firstName, lastName, gender, "123-456-7890",
//                dob, weight, height, doctor, nurse, currentCondition);//
// PatientDAO.deletePatient(1);
//    }

    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scene/DoctorScene.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            Scene scene = new Scene(employeeOperationsView);
            primaryStage.setScene(scene);
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
