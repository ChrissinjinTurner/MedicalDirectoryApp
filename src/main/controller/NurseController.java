package main.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import main.type.Patient;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import main.type.PatientDAO;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
<<<<<<< HEAD
=======
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import main.type.Doctor;
import main.type.Nurse;
import main.type.Patient;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

<<<<<<< HEAD
import javax.swing.text.TableView;
import java.awt.*;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
    private TableColumn<Patient, Integer> patientIDTable;
=======
    private TableColumn<Patient, Integer> patientIDtable;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
    private TableColumn<Patient, Integer> patientIDTable;
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    private TableColumn<Patient, String> doctorLicenseTable;
    @FXML
    private TableColumn<Patient, String> nurseIDTable;
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
    private DatePicker patientDOB;
<<<<<<< HEAD
=======
    private TableColumn<Doctor, Integer> doctorLicenseTable;
    @FXML
    private TableColumn<Nurse, Integer> nurseIDTable;
    @FXML
    private TableColumn<Patient, String> conditionTable;
    @FXML
<<<<<<< HEAD
    private TextField patientDOB;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
    private DatePicker patientDOB;
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    @FXML
    private TextField patientWeight;
    @FXML
    private TextField patientCurrentCondition;
    @FXML
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private TextField patientDateOfRegistration;
=======
    private DatePicker patientDateOfRegistration;
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
    @FXML
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField patientLastNameSearch;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    @FXML
    private TextField patientUpdateID;

    //for multithreading
    private Executor executor;

    @FXML
    private void initialize(){
        //For multithreading: Create executor that uses daemon threads:
        executor = Executors.newCachedThreadPool((runnable) -> {
<<<<<<< HEAD
=======

    //for multithreading
    private Executor execute;

    @FXML
    private void intitialize(){
        //For multithreading: Create executor that uses daemon threads:
        execute = Executors.newCachedThreadPool((runnable) -> {
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

<<<<<<< HEAD
<<<<<<< HEAD
        patientIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
=======
        patientIDtable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
        patientIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
        patientFirstNameTable.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        patientLastNameTable.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        patientGenderTable.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        patientDOBTable.setCellValueFactory(cellData -> cellData.getValue().dobProperty());
        patientHeightTable.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        patientWeightTable.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
        PatientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().getDoctor().lastNameProperty());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().getNurse().lastNameProperty());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

        try {
            table.setItems(PatientDAO.getPatients());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void insertPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            char[] ssnArr = PatientSSN.getText().toCharArray();
            PatientDAO.addPatient(patientFirstName.getText().toUpperCase(),patientLastName.getText().toUpperCase(),
                    patientGender.getText().toUpperCase(),formatSSN(ssnArr),
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, 1,2,patientCurrentCondition.getText());
            table.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void searchPatient(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Patient information
            ObservableList<Patient> patients = FXCollections.observableArrayList();
            if (patientFirstNameSearch.getText().trim().length() == 0 && patientLastNameSearch.getText().trim().length() == 0
                    && patientSSNSearch.getText().trim().length() == 0) {
                patients = PatientDAO.getPatients();
            } else if (patientFirstNameSearch.getText().trim().length() == 0 && patientLastNameSearch.getText().trim().length() == 0) {
                patients.add(PatientDAO.getPatientBySSN(patientSSNSearch.getText()));
            } else if (patientLastNameSearch.getText().trim().length() == 0 && patientSSNSearch.getText().trim().length() == 0) {
                patients = PatientDAO.getPatientByFirstName(patientFirstNameSearch.getText());
            } else if (patientFirstNameSearch.getText().trim().length() == 0 && patientSSNSearch.getText().trim().length() == 0){
                patients = PatientDAO.getPatientByLastName(patientLastNameSearch.getText());
            } else if (patientSSNSearch.getText().trim().length() == 0) {
                patients = PatientDAO.getPatientByFirstAndLastName(patientFirstNameSearch.getText(), patientLastNameSearch.getText());
            } else {
                patients = PatientDAO.getPatient(patientFirstNameSearch.getText(), patientLastNameSearch.getText(), patientSSNSearch.getText());
            }

            table.setItems(patients);
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
            table.setItems(patients);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deletePatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(patientUpdateID.getText());
            PatientDAO.deletePatient(id);
            table.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void updatePatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            Integer id = Integer.parseInt(patientUpdateID.getText());
            char[] ssnArr = PatientSSN.getText().toCharArray();
            PatientDAO.editPatient(id,patientFirstName.getText().toUpperCase(),patientLastName.getText().toUpperCase(),
                    patientGender.getText().toUpperCase(),formatSSN(ssnArr),
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, 1,2,patientCurrentCondition.getText());
            table.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    private String formatSSN(char[] array) {
        StringBuilder ssn = new StringBuilder();
        int index = 0;
        for (int i = 0; i < array.length + 2; i++) {
            if (i == 3 || i == 6) {
                ssn.append("-");
            } else {
                ssn.append(array[index]);
                index++;
            }
        }
        return ssn.toString();
<<<<<<< HEAD
=======
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asObject());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
    }
}
