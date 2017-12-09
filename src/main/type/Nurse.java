package main.type;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Nurse extends Employee {
    public Nurse() {
        super();
    }

    public Nurse(IntegerProperty id, IntegerProperty license, StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName) {
        super(id, license, username, password, firstName, lastName, new SimpleIntegerProperty(2), new Date());
    }
}
