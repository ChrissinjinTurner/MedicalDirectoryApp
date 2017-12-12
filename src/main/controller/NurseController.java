package main.controller;

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
    private TableColumn<Patient, String> PatientSSNTable;
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
    private TextField patientCurrentCondition;
    @FXML
    private TextField patientFirstNameSearch;
    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField patientLastNameSearch;
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
        PatientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
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
    }
}
