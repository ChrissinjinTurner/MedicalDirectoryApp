package main.type;

import main.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Get employee
    public static Employee getEmployee(int id) throws SQLException, ClassNotFoundException {
        // MySQL query for SELECT
        String getEmployeeQuery = "SELECT * FROM employees WHERE id=" + id;

        // Attempt to get the employee
        try {
            ResultSet resultSet = DBUtil.executeQuery(getEmployeeQuery);
            return getEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println("Failed to find an employee with id = " + id + ": ");
            throw e;
        }
    }

    /**
     * @ToDO
     * @param resultSet
     * @return
     * @throws SQLException
     */
    // Used for getEmployee to get employee information
    private static Employee getEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = null;
        if (resultSet.next()) {
            employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setLicense(resultSet.getInt("license"));
            employee.setUsername(resultSet.getString("username"));
            employee.setPassword(resultSet.getString("password"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setType(resultSet.getInt("employeeType"));
            //employee.setRegistrationDate(resultSet.getDate("reg_date"));
        }
        return employee;
    }
}
