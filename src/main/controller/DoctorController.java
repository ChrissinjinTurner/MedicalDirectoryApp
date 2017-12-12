package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
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
    private TableColumn<Patient, Integer> patientIDTable;
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
    private TableColumn<Patient, String> patientSSNTable;
    @FXML
    private TableColumn<Patient, String> doctorLicenseTable;
    @FXML
    private TableColumn<Patient, String> nurseIDTable;
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
    private Executor executor;

    @FXML
    private void initialize(){
        //For multithreading: Create executor that uses daemon threads:
        executor = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

        patientIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        patientFirstNameTable.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        patientLastNameTable.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        patientGenderTable.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        patientDOBTable.setCellValueFactory(cellData -> cellData.getValue().dobProperty());
        patientHeightTable.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        patientWeightTable.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
        patientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().getDoctor().lastNameProperty());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().getNurse().lastNameProperty());
        conditionTable.setCellValueFactory(cellData -> cellData.getValue().currentConditionProperty());

        try {
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Insert an employee to the DB
    @FXML
    private void insertPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            Integer doctor = Integer.parseInt(doctorLicense.getText());
            Integer nurse = Integer.parseInt(nurseID.getText());

            char[] ssnArr = PatientSSN.getText().toCharArray();
            String ssn = formatSSN(ssnArr);

            PatientDAO.addPatient(patientFirstName.getText().toUpperCase(),
                    patientLastName.getText().toUpperCase(),
                    patientGender.getText().toUpperCase(),ssn,
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, doctor,nurse,patientCurrentCondition.getText());
            patientTable.setItems(PatientDAO.getPatients());
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

    @FXML
    private void deletePatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(patientID.getText());
            PatientDAO.deletePatient(id);
            patientTable.setItems(PatientDAO.getPatients());
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void updatePatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {

            Double weight = Double.parseDouble(patientWeight.getText());
            Double height = Double.parseDouble(patientHeight.getText());
            Integer doctor = Integer.parseInt(doctorLicense.getText());
            Integer nurse = Integer.parseInt(nurseID.getText());
            Integer id = Integer.parseInt(patientUpdateID.getText());

            char[] ssnArr = PatientSSN.getText().toCharArray();
            String ssn = formatSSN(ssnArr);

            PatientDAO.editPatient(id, patientFirstName.getText().toUpperCase(),
                    patientLastName.getText().toUpperCase(),
                    patientGender.getText().toUpperCase(),ssn,
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, doctor,nurse,patientCurrentCondition.getText());
            patientTable.setItems(PatientDAO.getPatients());
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
    }
}
