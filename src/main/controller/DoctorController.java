package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import main.type.*;

import javax.swing.text.TableView;
import java.awt.*;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DoctorController {
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
    private TableColumn<Patient, String> PatientSSNTable;
    @FXML
    private TableColumn<Doctor, String> doctorLicenseTable;
    @FXML
    private TableColumn<Nurse, Integer> nurseIDTable;
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
    private TextField patientDOB;
    @FXML
    private TextField patientWeight;
    @FXML
    private TextField patientLicense;
    @FXML
    private TextField nurseID;
    @FXML
    private TextField patientCurrentCondition;
    @FXML
    private TextField patientDateOfRegistration;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField patientLastNameSearch;


    //for multithreading
    private Executor exec;

    @FXML
    private void intitialize(){
        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
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
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asString());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

    }

    //Insert an employee to the DB
    @FXML
    private void insertPatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            PatientDAO.addPatient(patientFirstName.getText(),patientLastName.getText(),patientGender.getText(),PatientSSN.getText(),
                    patientDOB.getText(),weight,height,patientLicense.getText(),nurseID.getText(),patientCurrentCondition.getText());
        } catch (SQLException e) {
            throw e;
        }
    }





}
