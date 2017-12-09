package main.type;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Orderly extends Employee {
    public Orderly() {

    }
    public Orderly(IntegerProperty id, IntegerProperty license,  StringProperty username, StringProperty password, StringProperty firstName, StringProperty lastName) {
        super(id, license, username, password, firstName, lastName, new SimpleIntegerProperty(3), new Date());
    }
}
