package main.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import javafx.collections.FXCollections;
=======
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.Parent;
=======
>>>>>>> 27abdf4... Fixed broken stuff done by Chris
import javafx.scene.control.TableColumn;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import main.type.*;

<<<<<<< HEAD
=======
=======
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
import main.type.Doctor;
import main.type.Nurse;
import main.type.Patient;
import main.type.PatientDAO;

<<<<<<< HEAD
import javax.swing.text.TableView;
import javax.swing.text.View;
import java.awt.*;
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet
=======
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
    private TableColumn<Patient, String> doctorLicenseTable;
=======
    private TableColumn<Doctor, Integer> doctorLicenseTable;
>>>>>>> 27abdf4... Fixed broken stuff done by Chris
=======
    private TableColumn<Patient, String> doctorLicenseTable;
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private DatePicker patientDateOfRegistration;
    @FXML
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
        patientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().getDoctor().lastNameProperty());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().getNurse().lastNameProperty());
=======
        PatientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().licenseProperty().asObject());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
>>>>>>> 27abdf4... Fixed broken stuff done by Chris
=======
        patientSSNTable.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());
        doctorLicenseTable.setCellValueFactory(cellData -> cellData.getValue().getDoctor().lastNameProperty());
        nurseIDTable.setCellValueFactory(cellData -> cellData.getValue().getNurse().lastNameProperty());
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de

            char[] ssnArr = PatientSSN.getText().toCharArray();
            String ssn = formatSSN(ssnArr);

            PatientDAO.addPatient(patientFirstName.getText().toUpperCase(),
                    patientLastName.getText().toUpperCase(),
                    patientGender.getText().toUpperCase(),ssn,
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, doctor,nurse,patientCurrentCondition.getText());
            patientTable.setItems(PatientDAO.getPatients());
<<<<<<< HEAD
=======
            PatientDAO.addPatient(patientFirstName.getText(),patientLastName.getText(),patientGender.getText(),PatientSSN.getText(),
<<<<<<< HEAD
<<<<<<< HEAD
                    patientDOB.getText(),weight,height, doctor,nurse,patientCurrentCondition.getText());
>>>>>>> 27abdf4... Fixed broken stuff done by Chris
=======
                    patientDOB.toString(),weight,height, doctor,nurse,patientCurrentCondition.getText());
>>>>>>> b5d0d58... fixed errors in both our scenese and controllers
=======
                    patientDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),weight,height, doctor,nurse,patientCurrentCondition.getText());
<<<<<<< HEAD
>>>>>>> 8f5abc9... Add now works with Application
=======
            patientTable.setItems(PatientDAO.getPatients());
>>>>>>> a1bcc16... Added functionality to the table (hopefully)
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
<<<<<<< HEAD
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
=======
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

<<<<<<< HEAD
    //Delete an employee with a given employee Id fromd DB
//    @FXML
//    private void deletePatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        try {
//            PatientDAO.deletePatient(patientID.getText());
//        } catch (SQLException e) {
//            throw e;
//        }
//    }

//    @FXML
//    private void updatePatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        try {
//            PatientDAO.editPatient(patientID.getText(), pa);
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
>>>>>>> 0fa1c08... Added the Controllers, have not finished methods yet

            patientTable.setItems(patients);
        } catch (SQLException e) {
            e.printStackTrace();
=======
    @FXML
    private void deletePatient (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(patientID.getText());
            PatientDAO.deletePatient(id);
            patientTable.setItems(PatientDAO.getPatients());
=======
>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
        } catch (SQLException e) {
>>>>>>> 2f36310... Addition of Main, and Controller
            throw e;
        }
    }

    @FXML
<<<<<<< HEAD
<<<<<<< HEAD
    private void searchPatients(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Patient> patients = FXCollections.observableArrayList();
            patients = PatientDAO.getPatients();
            patientTable.setItems(patients);
        } catch (SQLException e) {
            e.printStackTrace();
=======
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
>>>>>>> 2f36310... Addition of Main, and Controller
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

=======
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

>>>>>>> 057759ae22f86f1ee4c6895a5b565f1334b069de
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
