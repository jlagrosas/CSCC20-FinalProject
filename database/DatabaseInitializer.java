package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Initializes the SQLite database schema for the Human Resource Information System (HRIS).
 *
 * <p>
 * Based on the current Person and Personnel classes.
 * </p>
 *
 * @author CSCC 20 class of 2026-2027
 * @version 1.0
 */
public class DatabaseInitializer {

    /**
     * Initializes the database by creating the required tables and indexes, if they don't already exist.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void initialize(Connection conn) throws SQLException {

        // SQL statement to create the personnel table
        String createPersonnelTable = """
            CREATE TABLE IF NOT EXISTS personnel (
                -- Primary Key
                id INTEGER PRIMARY KEY AUTOINCREMENT,

                -- Employment Information (from Personnel)
                employee_number TEXT NOT NULL UNIQUE,
                position TEXT NOT NULL,
                department TEXT NOT NULL,
                hire_date TEXT NOT NULL,
                employment_status TEXT NOT NULL,

                -- Personal Information (inherited from Person)
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                middle_name TEXT,
                suffix TEXT,
                prefix TEXT,
                sex TEXT NOT NULL,
                birth_date TEXT NOT NULL,
                civil_status TEXT NOT NULL,

                -- Contact Information (inherited from Person)
                email TEXT,
                primary_contact_number TEXT NOT NULL,
                secondary_contact_number TEXT,
                address1 TEXT NOT NULL,
                address2 TEXT,
                city_municipality TEXT NOT NULL,

                -- Government Identification (from Personnel)
                sss_number TEXT,
                tin_number TEXT,
                philhealth_number TEXT,
                pagibig_number TEXT,
                government_id_number TEXT,

                -- Emergency Contact (from Personnel)
                emergency_contact_name TEXT,
                emergency_contact_relationship TEXT,
                emergency_contact_number TEXT,

                -- Employee Status (from Personnel)
                is_active INTEGER NOT NULL DEFAULT 1,
                last_active_date TEXT,

                -- Additional Notes (from Personnel)
                notes TEXT,

                -- Metadata / Timestamps
                created_at TEXT DEFAULT CURRENT_TIMESTAMP
            );
        """;

        // Indexes for frequently queried columns
        String createIndexes = """
            CREATE INDEX IF NOT EXISTS idx_personnel_employee_number ON personnel(employee_number);
            CREATE INDEX IF NOT EXISTS idx_personnel_department ON personnel(department);
            CREATE INDEX IF NOT EXISTS idx_personnel_last_name ON personnel(last_name);
        """;

        try (
                // Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()
            ) {

                // Execute table creation
                stmt.execute(createPersonnelTable);

                // Execute indexes creation
                stmt.execute(createIndexes);

                System.out.println("Database initialization successful: 'personnel' table and indexes verified.");
            }
    }

    /**
     * Drops existing tables and reinitializes the database schema, run when needed to clear the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void resetDatabase(Connection conn) throws SQLException {

        String[] tables = {
            "personnel"
        };

        try (Statement stmt = conn.createStatement()) {

            for (String table : tables) {
                stmt.executeUpdate("DROP TABLE IF EXISTS " + table);
            }

        }

        initialize(conn);
    }
}