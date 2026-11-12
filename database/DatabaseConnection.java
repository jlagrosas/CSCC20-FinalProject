package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:database/hris.db";

    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(URL);

        try {

            // DatabaseInitializer.resetDatabase(conn);
            DatabaseInitializer.initialize(conn);
            return conn;

        } catch (SQLException e) {
            conn.close();
            throw e;
        }
    }
}