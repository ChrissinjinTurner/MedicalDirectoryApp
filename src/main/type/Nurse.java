package main.type;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Nurse extends Employee {

    public Nurse(IntegerProperty id, StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName) {
        super(id, username, password, firstName, lastName);
    }
}
