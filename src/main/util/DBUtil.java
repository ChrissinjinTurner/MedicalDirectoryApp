package main.util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

/**
 * DBUtil contains methods to access the MySQL database
 * Methods will be called with the DAO
 */
public class DBUtil {

    // JDBC driver
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static Connection conn = null;

    // Connection URL, username, and password to DB
    private static final String connStr = "jdbc:mysql://107.170.201.221:3306/MedicalDirectory";
    private static final String username = "chris";
    private static final String password = "Egr320ChrisCubed";

    /**
     * Connects to the Oracle JDBC Driver
     * @throws SQLException if connection fails
     * @throws ClassNotFoundException if DBUtil cannot be found
     */
    public static void connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("The Oracle JDBC Driver was not found!");
            e.printStackTrace();
            throw e;
        }

        System.out.println("The Oracle JDBC Driver was found!");

        // Attempt to connect to the database
        try {
            conn = DriverManager.getConnection(connStr, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Disconnect from the database
     * @throws SQLException if connection fails to close
     */
    public static void disconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e){
            throw e;
        }
    }

    /**
     * Attempts to execute the given query statement
     * @param queryStatement the query to be executed
     * @return ResultSet of the results of the query
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet executeQuery(String queryStatement) throws SQLException, ClassNotFoundException {
        // Declare original objects as null to be initialized later
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSet = null;
        try {
            // Attempt to connect to the database
            connect();
            System.out.println("Select statement: " + queryStatement + "\n");

            // Set the statement
            statement = conn.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(queryStatement);

            // Use a CacheRowSet
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("An error has occurred with the executeQuery operation: " + e);
            throw e;
        } finally {
            // Close result set if it's not null
            if (resultSet != null) {
                resultSet.close();
            }

            // Close the statement if it is not null
            if (statement != null) {
                statement.close();
            }

            // Disconnect from the database
            disconnect();
        }

        // Return the CacheRowSet
        return cachedRowSet;
    }

    /**
     * Used for updating, inserting, and deleting in the database
     * @param sqlStatement SQL statement to be ran
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void executeUpdate(String sqlStatement) throws SQLException, ClassNotFoundException {
        // Statement will initially be null
        Statement stmt = null;
        try {
            // Attempt to connect to the database
            connect();

            // Set the statement
            stmt = conn.createStatement();

            // Attempt to execute the statement
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            System.out.println("An error has occurred with the executeUpdate operation: " + e);
            throw e;
        } finally {
            // Close the statement if it is not null
            if (stmt != null) {
                stmt.close();
            }

            // Disconnect from the database
            disconnect();
        }
    }
}