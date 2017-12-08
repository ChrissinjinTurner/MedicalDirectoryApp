package main.type;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class Nurse extends Employee {

    public Nurse(LongProperty id, StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName) {
        super(id, username, password, firstName, lastName);
    }
}
