package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection
{
    private static String dbUrl = "jdbc:mysql://107.170.201.221:3306/MedicalDirectory";
    private static String dbUsername = "chris";
    private static String dbPassword = "Egr320ChrisCubed";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}