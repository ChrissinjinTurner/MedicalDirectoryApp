package main.type;

import java.util.Date;
import java.util.HashMap;

public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String ssn;
    private String dob;
    private double weight;
    private double height;
    private Employee doctor;
    private Employee nurse;
    private String currentCondition;
    private HashMap<String, Date> conditionMap;
    private Date dateRegistered;

    public Patient() {
    }

    public Patient(int id, String firstName, String lastName, String gender, String ssn, String dob, double weight, double height, Doctor doctor, Nurse nurse, String currentCondition, HashMap<String, Date> conditionMap, Date dateRegistered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssn = ssn;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.doctor = doctor;
        this.nurse = nurse;
        this.conditionMap = conditionMap;
        this.currentCondition = currentCondition;
        this.dateRegistered = dateRegistered;
    }

    /**
     * Getters
     */

    public String getCurrentCondition() {
        return currentCondition;
    }

    public Employee getNurse() {
        return nurse;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getSSN() {
        return ssn;
    }

    public String getDob() {return dob;}

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public HashMap<String, Date> getConditionMap() { return conditionMap; }

    public Employee getDoctor() {
        return doctor;
    }

    /**
     * Setters
     */

    public void setNurse(Employee nurse) {
        this.nurse = nurse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public void setDob(String date) { this.dob = dob; }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public void setCurrentCondition(String condition) {
        this.currentCondition = condition;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
