package main.type;

import java.util.Date;

public class Nurse extends Employee {

    public Nurse() {
        super();
    }

    public Nurse(int id, int license, String username, String password, String firstName, String lastName) {
        super(id, license, username, password, firstName, lastName, 2, new Date());
    }
}
