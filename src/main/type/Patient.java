package main.type;

import javafx.beans.property.*;

import java.util.Date;
import java.util.HashMap;

public class Patient {

    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty gender;
    private StringProperty ssn;
    private StringProperty dob;
    private DoubleProperty weight;
    private DoubleProperty height;
    private Employee doctor;
    private Employee nurse;
    private StringProperty currentCondition;
    private Date dateRegistered;

    public Patient() {
        this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.ssn = new SimpleStringProperty();
        this.dob = new SimpleStringProperty();
        this.weight = new SimpleDoubleProperty();
        this.height = new SimpleDoubleProperty();
        this.doctor = new Employee();
        this.nurse = new Employee();
        this.currentCondition = new SimpleStringProperty();
        this.dateRegistered = new Date();
    }

    public Patient(int id, String firstName, String lastName, String gender, String ssn, String dob, double weight, double height, Employee doctor, Employee nurse, String currentCondition, Date dateRegistered) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.ssn = new SimpleStringProperty(ssn);
        this.dob = new SimpleStringProperty(dob);
        this.weight = new SimpleDoubleProperty(weight);
        this.height = new SimpleDoubleProperty(height);
        this.doctor = doctor;
        this.nurse = nurse;
        this.currentCondition = new SimpleStringProperty(currentCondition);
        this.dateRegistered = dateRegistered;
    }

    public long getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }


    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }


    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }


    public String getSSN() {
        return ssn.get();
    }

    public StringProperty ssnProperty() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn.set(ssn);
    }


    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }


    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }


    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }


    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }


    public Employee getNurse() {
        return nurse;
    }

    public void setNurse(Employee nurse) {
        this.nurse = nurse;
    }


    public String getCurrentCondition() {
        return currentCondition.get();
    }

    public StringProperty currentConditionProperty() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition.set(currentCondition);
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
