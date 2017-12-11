package main.type;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Employee {

    private IntegerProperty id;
    private IntegerProperty license;
    private StringProperty username;
    private StringProperty password;
    private StringProperty firstName;
    private StringProperty lastName;
    private IntegerProperty type;
    private Date registrationDate;

    public Employee() {
        this.id = new SimpleIntegerProperty();
        this.license = new SimpleIntegerProperty();
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.type = new SimpleIntegerProperty();
        this.registrationDate = new Date();
    }

    public Employee(IntegerProperty id, IntegerProperty license,  StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName, IntegerProperty type, Date registrationDate) {
        this.id = id;
        this.license = license;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }

    public int getLicense() {
        return license.get();
    }
    public IntegerProperty licenseProperty() {
        return license;
    }
    public void setLicense(int license) {
        this.license.set(license);
    }

    //username
    public String getUsername() {
        return username.get();
    }
    public StringProperty usernameProperty() {
        return username;
    }
    public void setUsername(String username) {
        this.username.set(username);
    }

    //password
    public String getPassword() {
        return password.get();
    }
    public StringProperty passwordProperty() {
        return password;
    }
    public void setPassword(String password) {
        this.password.set(password);
    }

    //firstname
    public String getFirstName() {
        return firstName.get();
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    //lastname
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getType() {
        return type.get();
    }
    public IntegerProperty typeProperty() {
        return type;
    }
    public void setType(int type) {
        this.type.set(type);
    }

    /**
     * I think this is fixed...
     * @return
     */
    public Date getRegistrationDate() {
        return new Date(registrationDate.getTime());
    }
    public Date dateProperty() {
        return registrationDate;
    }
    public void setRegistrationDate(Date date) {
       this.registrationDate.setTime(date.getTime());
    }

}
