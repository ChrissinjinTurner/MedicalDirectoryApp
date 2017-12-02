import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        /*int rowsAffected = statement.executeUpdate(
                "insert into employees (id, username, password, firstName, lastName, employeeType, reg_date) " +
                        "values (null, 'chriscarrillo', 'password', 'Chris', 'Carrillo', 1, null)");*/

        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date myDate = format.parse("01/23/1997");

            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO patients (id, ssn, dob, firstName, lastName, gender, weight, height, currentCondition, doctor, reg_date) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

            pstmt.setInt(1, 0);
            pstmt.setString(2, "123-45-6789");
            pstmt.setDate(3, sqlDate);
            pstmt.setString(4, "Chris");
            pstmt.setString(5, "Fernandes");
            pstmt.setString(6, "Male");
            pstmt.setDouble(7, 150.0);
            pstmt.setDouble(8, 73.0);
            pstmt.setString(9, "Healthy");
            pstmt.setInt(10, 1);
            pstmt.setDate(11, null);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*int rowsAffected = statement.executeUpdate(
                "insert into patients " +
                        "(id, ssn, dob, firstName, lastName, gender, weight, height, currentCondition, doctor," +
                        "reg_date) " +
                        "values " +
                        "(null,'123-45-6789', 'Chris', 'Carrillo', 'Male', 185.0, 69.0, 'Healthy'," +
                        "1, null)");*/
    }
}
