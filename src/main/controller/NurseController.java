package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import main.type.Doctor;
import main.type.Nurse;
import main.type.Patient;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NurseController {

    @FXML
    private TextField patientFirstName;
    @FXML
    private TextField patientHeight;
    @FXML
    private TextField patientGender;
    @FXML
    private TextField PatientSSN;
    @FXML
    private TextField patientLastName;
    @FXML
    private TableView table;
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
    private TableColumn<Patient, String> PatientSSNTable;
    @FXML
    private TableColumn<Doctor, Integer> doctorLicenseTable;
    @FXML
    private TableColumn<Nurse, Integer> nurseIDTable;
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
    private DatePicker patientDOB;
    @FXML
    private TextField patientWeight;
    @FXML
    private TextField patientCurrentCondition;
    @FXML
    private DatePicker patientDateOfRegistration;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField patientLastNameSearch;

    //for multithreading
    private Executor execute;

    @FXML
    private void intitialize(){
        //For multithreading: Create executor that uses daemon threads:
        execute = Executors.newCachedThreadPool((runnable) -> {
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
        PatientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asObject());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

    }
}
