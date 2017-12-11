package main.type;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {

    // Add a patient to the database (CREATE)
    public static void addPatient(String firstName, String lastName, String gender, String ssn, String dob,
                                  double weight, double height, int doctor,
                                  int nurse, String currentCondition) throws SQLException, ClassNotFoundException {
        // SQL query to add the patient
        String addQuery =
                "INSERT INTO patients (id, ssn, dob, firstName, lastName, gender, weight, height, currentCondition," +
                        " doctor, nurse, reg_date) VALUES (null, '" + ssn + "', '" + dob + "', '" + firstName +
                        "', '" + lastName + "', '" + gender + "', " + weight + ", " + height + ", '"
                        + currentCondition + "', " + doctor + ", " + nurse + ", null)";
        // Attempt to add the patient
        try {
            DBUtil.executeUpdate(addQuery);
        } catch (SQLException e) {
            System.out.println("An error occurred with adding: " + e);
            throw e;
        }
    }

    // Get all patients from the database (READ)
    public static ObservableList<Patient> getPatients() throws SQLException, ClassNotFoundException {
        String getQuery = "SELECT * FROM patients";
        // Attempt to get the patients
        try {
            ResultSet resultSet = DBUtil.executeQuery(getQuery);
            return getPatientList(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find any patients in the table: ");
            throw e;
        }
    }

    // Get a patient from the database (READ)
    public static ObservableList<Patient> getPatient(String firstName, String lastName, String ssn) throws SQLException, ClassNotFoundException {
        String getQuery = "SELECT * FROM patients WHERE firstName = '" + firstName + "', lastName = '" + lastName + "'," +
                " ssn = '" + ssn;

        // Attempt to get the patient
        try {
            ResultSet resultSet = DBUtil.executeQuery(getQuery);
            return getPatientList(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find an patient with firstName = " + firstName + ", lastName = " + lastName + ", and" +
                    " SSN = " + ssn + ": ");
            throw e;
        }
    }

    // Get a patient from the database (READ)
    public static ObservableList<Patient> getPatientByFirstName(String firstName) throws SQLException, ClassNotFoundException {
        String getQuery = "SELECT * FROM patients WHERE firstName = '" + firstName + "'";

        // Attempt to get the patient
        try {
            ResultSet resultSet = DBUtil.executeQuery(getQuery);
            return getPatientList(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find an patient with firstName = " + firstName + ": ");
            throw e;
        }
    }

    // Get a patient from the database (READ)
    public static ObservableList<Patient> getPatientByLastName(String lastName) throws SQLException, ClassNotFoundException {
        String getQuery = "SELECT * FROM patients WHERE lastName = '" + lastName + "'";

        // Attempt to get the patient
        try {
            ResultSet resultSet = DBUtil.executeQuery(getQuery);
            return getPatientList(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find an patient with lastName = " + lastName + ": ");
            throw e;
        }
    }

    public static Patient getPatientBySSN(String ssn) throws SQLException, ClassNotFoundException {
        String getQuery = "SELECT * FROM patients WHERE ssn = '" + ssn + "'";

        // Attempt to get the patient
        try {
            ResultSet resultSet = DBUtil.executeQuery(getQuery);
            return getPatientFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find an patient with ssn = " + ssn + ": ");
            throw e;
        }
    }

    private static Patient getPatientFromResultSet(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        Patient patient = null;
        if (resultSet.next()) {
            patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setSSN(resultSet.getString("ssn"));
            patient.setDob(resultSet.getString("dob"));
            patient.setFirstName(resultSet.getString("firstName"));
            patient.setLastName(resultSet.getString("lastName"));
            patient.setGender(resultSet.getString("gender"));
            patient.setWeight(resultSet.getDouble("weight"));
            patient.setHeight(resultSet.getDouble("height"));
            patient.setCurrentCondition(resultSet.getString("currentCondition"));
            patient.setDoctor(EmployeeDAO.getEmployee(resultSet.getInt("doctor")));
            patient.setNurse(EmployeeDAO.getEmployee(resultSet.getInt("nurse")));
            patient.setDateRegistered(resultSet.getDate("reg_date"));
        }
        return patient;
    }

    private static ObservableList<Patient> getPatientList(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        ObservableList<Patient> patients = FXCollections.observableArrayList();

        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setSSN(resultSet.getString("ssn"));
            patient.setDob(resultSet.getString("dob"));
            patient.setFirstName(resultSet.getString("firstName"));
            patient.setLastName(resultSet.getString("lastName"));
            patient.setGender(resultSet.getString("gender"));
            patient.setWeight(resultSet.getDouble("weight"));
            patient.setHeight(resultSet.getDouble("height"));
            patient.setCurrentCondition(resultSet.getString("currentCondition"));
            patient.setDoctor(EmployeeDAO.getEmployee(resultSet.getInt("doctor")));
            patient.setNurse(EmployeeDAO.getEmployee(resultSet.getInt("nurse")));
            patient.setDateRegistered(resultSet.getDate("reg_date"));
            patients.add(patient);
        }
        return patients;
    }

    // Edit a patient in the database (UPDATE)
    public static void editPatient(int id, String firstName, String lastName, String gender, String ssn, String dob,
                                  double weight, double height, int doctor,
                                  int nurse, String currentCondition) throws SQLException, ClassNotFoundException {
        // SQL query to edit the patient
        String editQuery =
                "UPDATE patients SET firstName = '" + firstName + "', lastName = '" + lastName +
                "', gender = '" + gender + "', ssn = '" + ssn + "', dob = '" + dob + "', weight = " + weight + ", " +
                        "height = " + height + ", doctor = " + doctor + ", nurse = " + nurse + ", " +
                        "currentCondition = '" + currentCondition + "' WHERE id = " + id;
        // Attempt to edit the patient
        try {
            DBUtil.executeUpdate(editQuery);
        } catch (SQLException e) {
            System.out.println("An error occurred with editing: " + e);
            throw e;
        }
    }

    // Delete a patient from the database (DELETE)
    public static void deletePatient(int id) throws SQLException, ClassNotFoundException {
        String deleteQuery = "DELETE FROM patients WHERE id = " + id;
        // Attempt to delete the patient
        try {
            DBUtil.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            System.out.println("An error occurred with deleting: " + e);
            throw e;
        }
    }

}
