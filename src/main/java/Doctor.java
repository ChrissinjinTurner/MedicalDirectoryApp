import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Doctor extends Employee {

    public Doctor() {
        super();
    }

    public Doctor(long id, String username, String password, String firstName, String lastName) {
        super(id, username, password, firstName, lastName);
    }

    public void createPatient(Patient patient) throws SQLException {
        Connection connection = MySqlConnection.getConnection();

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = null;

        try {
            myDate = format.parse(patient.getDob());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO patients (id, ssn, dob, firstName, lastName, gender, weight, height, currentCondition, doctor, reg_date) " +
                        "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)");

        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

        pstmt.setString(2, patient.getSSN());
        pstmt.setDate(3, sqlDate);
        pstmt.setString(4, patient.getFirstName());
        pstmt.setString(5, patient.getLastName());
        pstmt.setString(6, patient.getGender());
        pstmt.setDouble(7, patient.getWeight());
        pstmt.setDouble(8, patient.getHeight());
        pstmt.setString(9, patient.getCurrentCondition());
        pstmt.setLong(10, patient.getDoctor().getId());
    }
}
