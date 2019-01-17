package main;

import javafx.application.Application;
<<<<<<< HEAD
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.type.EmployeeDAO;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application{

    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;

    private Stage primaryStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Software Quality Assurance Project");
        this.primaryStage.setResizable(false);
        showView("scene/LoginScene.fxml");
    }

    @FXML
    private void verifyLogin(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (EmployeeDAO.isLoginCorrect(loginUsername.getText(), loginPassword.getText())) {
            int type = EmployeeDAO.getEmployeeType(loginUsername.getText());
            if (type == 1) {
                showView("scene/DoctorScene.fxml");
            } else if (type == 2) {
                showView("scene/NurseScene.fxml");
            } else {
                showView("scene/OrderlyScene.fxml");
            }
        } else {
            System.out.println("Login was incorrect. Try again");
        }
    }

    private void showView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(path));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    }

}
