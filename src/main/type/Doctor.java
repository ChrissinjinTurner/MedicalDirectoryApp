package main.type;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Doctor extends Employee {

    public Doctor() {

    }

    public Doctor(IntegerProperty id, IntegerProperty license, StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName) {
        super(id, license, username, password, firstName, lastName, new SimpleIntegerProperty(1), new Date());
    }

}
