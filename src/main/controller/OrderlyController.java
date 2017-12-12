package main.controller;

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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class OrderlyController {
    @FXML
    private TableView patientTable;
    @FXML
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
    private TableColumn<Patient, String> doctorLicenseTable;
    @FXML
    private TableColumn<Patient, String> nurseIDTable;
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientLastNameSearch;

    //for multithreading
    private Executor executor;

    @FXML
    private void initialize(){
        //For multithreading: Create executor that uses daemon threads:
        executor = Executors.newCachedThreadPool((runnable) -> {
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
    private void searchPatient (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
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


}
