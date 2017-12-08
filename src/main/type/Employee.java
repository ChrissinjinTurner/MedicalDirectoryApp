package main.type;

import java.util.Date;

public class Employee {

    private int id;
    private int license;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int type;
    private Date registrationDate;

    public Employee() {
        new Employee(0, 0, "", "", "", "", 3, new Date()); // change 0 later after DB is done
    }

    public Employee(int id, int license, String username, String password, String firstName, String lastName, int type, Date registrationDate) {
        this.id = id;
        this.license = license;
        this.type = type;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void viewPatient(Patient patient) {
        System.out.println(patient);
    }
}
