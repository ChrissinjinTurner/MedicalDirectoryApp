package main;

import main.type.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String firstName = "Chris";
        String lastName = "Carrillo";
        String gender = "Male";
        String ssn = "123-45-6789";
        String dob = "01/23/1997";
        double weight = 185.0;
        double height = 69.0;
        Employee doctor = EmployeeDAO.getEmployee(1);
        Employee nurse = EmployeeDAO.getEmployee(2);
        String currentCondition = "Healthy";

        //PatientDAO.addPatient(firstName, lastName, gender, ssn, dob, weight, height, doctor, nurse, currentCondition);
//        PatientDAO.editPatient(1, firstName, lastName, gender, "123-456-7890",
//                dob, weight, height, doctor, nurse, currentCondition);
        PatientDAO.deletePatient(1);
    }

}
