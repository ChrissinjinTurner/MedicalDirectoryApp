import java.util.Date;
import java.util.HashMap;

public class Patient {

    long id = 0;
    String firstName = "";
    String lastName = "";
    String gender = "";
    String ssn = "";
    double weight = 0.0;
    double height = 0.0;
    Doctor doctor = null;
    Nurse nurse = null;
    String currentCondition = "";
    HashMap<String, Date> conditionMap = null;
    Date dateRegistered = null;

    public Patient(long id, String firstName, String lastName, String gender, String ssn, double weight, double height, Doctor doctor, Nurse nurse, String currentCondition, HashMap<String, Date> conditionMap, Date dateRegistered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssn = ssn;
        this.weight = weight;
        this.height = height;
        this.doctor = doctor;
        this.nurse = nurse;
        this.currentCondition = currentCondition;
        this.conditionMap = conditionMap;
        this.dateRegistered = dateRegistered;
    }

    /**
     * Getters
     */

    public String getCurrentCondition() {
        return currentCondition;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public long getId() {
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

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public HashMap<String, Date> getConditionMap() {
        return conditionMap;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Setters
     */

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public void setId(long id) {
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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setCurrentCondition(String condition) {
        this.currentCondition = condition;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
