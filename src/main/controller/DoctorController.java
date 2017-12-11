package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import main.type.*;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
    private TextField doctorLicense;
    @FXML
    private TextField nurseID;
    @FXML
    private TextField patientCurrentCondition;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField patientLastNameSearch;
    @FXML
    private TextField patientID;
    @FXML
    private TextField patientUpdateID;


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
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asObject());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

    }

    //Insert an employee to the DB
    @FXML
    private void insertPatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            Integer doctor = Integer.parseInt(doctorLicense.getText());
            Integer nurse = Integer.parseInt(nurseID.getText());
            PatientDAO.addPatient(patientFirstName.getText(),patientLastName.getText(),patientGender.getText(),PatientSSN.getText(),
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, doctor,nurse,patientCurrentCondition.getText());
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void searchPatient (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            ObservableList patient = null;
            if (patientFirstNameSearch == null && patientLastNameSearch == null) {
                patient = PatientDAO.getPatient(patientFirstNameSearch.getText(), patientLastNameSearch.getText(), patientSSNSearch.getText());
            } else if (patientLastNameSearch == null && patientSSNSearch == null) {
                patient = PatientDAO.getPatientByFirstName(patientFirstNameSearch.getText());
            } else if (patientFirstNameSearch == null && patientSSNSearch == null){
                patient = PatientDAO.getPatientByLastName(patientLastNameSearch.getText());
            } else {
                patient = (ObservableList) PatientDAO.getPatientBySSN(patientSSNSearch.getText());
            }

            patientTable.setItems(patient);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void patientTable(Patient patient) {
        ObservableList<Patient> patientData = FXCollections.observableArrayList();

        patientData.add(patient);

        patientTable.setItems(patientData);
    }

    @FXML
    private void populatePatientTable(Patient patient) throws ClassNotFoundException {
        if (patient != null) {
            patientTable(patient);
        }
    }

    @FXML
    private void deletePatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(patientID.getText());
            PatientDAO.deletePatient(id);
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void updatePatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            Integer doctor = Integer.parseInt(doctorLicense.getText());
            Integer nurse = Integer.parseInt(nurseID.getText());
            Integer id = Integer.parseInt(patientUpdateID.getText());
            PatientDAO.editPatient(id,patientFirstName.getText(),patientLastName.getText(),patientGender.getText(),PatientSSN.getText(),
                    patientDOB.toString(),weight,height, doctor,nurse,patientCurrentCondition.getText());
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }




}
