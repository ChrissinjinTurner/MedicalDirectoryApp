package main.controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import javax.swing.text.TableView;
import java.awt.*;

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
    private TableColumn<LongProperty, Long> patientIDtable;
    @FXML
    private TableColumn<StringProperty, String> patientFirstNameTable;
    @FXML
    private TableColumn<StringProperty, String> patientLastNameTable;
    @FXML
    private TableColumn<StringProperty, String> patientGenderTable;
    @FXML
    private TableColumn<StringProperty, String> patientDOBTable;
    @FXML
    private TableColumn<DoubleProperty, Double> patientHeightTable;
    @FXML
    private TableColumn<DoubleProperty, Double> patientWeightTable;
    @FXML
    private TableColumn<StringProperty, String> PatientSSNTable;



}
