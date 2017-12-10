package main.controller;

<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.type.Doctor;
import main.type.Nurse;
import main.type.Patient;
import main.type.PatientDAO;

import java.sql.SQLException;
=======
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import main.type.Doctor;
import main.type.Nurse;
import main.type.Patient;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

<<<<<<< HEAD
import java.awt.*;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class OrderlyController {
    @FXML
<<<<<<< HEAD
    private TableView patientTable;
    @FXML
=======
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
    private TableColumn<Patient, Integer> patientIDtable;
    @FXML
    private TableColumn<Patient, String> patientFirstNameTable;
    @FXML
    private TableColumn<Patient, String> patientLastNameTable;
    @FXML
    private TableColumn<Patient, String> patientGenderTable;
    @FXML
    private TableColumn<Patient, String> patientDOBTable;
    @FXML
    private TableColumn<Patient, Double> patientHeightTable;
    @FXML
    private TableColumn<Patient, Double> patientWeightTable;
    @FXML
<<<<<<< HEAD
    private TableColumn<Patient, String> doctorLicenseTable;
    @FXML
    private TableColumn<Patient, String> nurseIDTable;
=======
    private TableColumn<Doctor, Integer> doctorLicenseTable;
    @FXML
    private TableColumn<Nurse, Integer> nurseIDTable;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientLastNameSearch;

    //for multithreading
<<<<<<< HEAD
    private Executor executor;

    @FXML
    private void initialize() {
        //For multithreading: Create executor that uses daemon threads:
        executor = Executors.newCachedThreadPool((runnable) -> {
=======
    private Executor execute;

    @FXML
    private void intitialize(){
        //For multithreading: Create executor that uses daemon threads:
        execute = Executors.newCachedThreadPool((runnable) -> {
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

        patientIDtable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        patientFirstNameTable.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        patientLastNameTable.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        patientGenderTable.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        patientDOBTable.setCellValueFactory(cellData -> cellData.getValue().dobProperty());
        patientHeightTable.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        patientWeightTable.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
<<<<<<< HEAD
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().getDoctor().lastNameProperty());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().getNurse().lastNameProperty());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

        try {
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void searchPatient(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Patient information
            ObservableList<Patient> patients = FXCollections.observableArrayList();
            if (patientFirstNameSearch.getText().trim().length() == 0 && patientLastNameSearch.getText().trim().length() == 0) {
                patients = PatientDAO.getPatients();
            }else if (patientLastNameSearch.getText().trim().length() == 0) {
                patients = PatientDAO.getPatientByFirstName(patientFirstNameSearch.getText());
            } else if (patientFirstNameSearch.getText().trim().length() == 0){
                patients = PatientDAO.getPatientByLastName(patientLastNameSearch.getText());
            } else {
                patients = PatientDAO.getPatientByFirstAndLastName(patientFirstNameSearch.getText(), patientLastNameSearch.getText());
            }

            patientTable.setItems(patients);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void searchPatients(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Patient> patients = FXCollections.observableArrayList();
            patients = PatientDAO.getPatients();
            patientTable.setItems(patients);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


=======
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asObject());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

    }
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
}
