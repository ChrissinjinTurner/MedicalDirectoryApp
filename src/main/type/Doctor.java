package main.type;

import java.util.Date;

public class Doctor extends Employee {

    public Doctor() {
        super();
    }

    public Doctor(int id, int license, String username, String password, String firstName, String lastName) {
        super(id, license, username, password, firstName, lastName, 1, new Date());
    }
}
