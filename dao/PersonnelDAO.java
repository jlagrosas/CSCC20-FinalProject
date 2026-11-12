package dao;

import models.Personnel;
import database.DatabaseConnection;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonnelDAO {

    /**
     * Insert a personnel record into the database.
     * 
     * @param personnel The personnel record to insert.
     * @return true if insertion is successful, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    public boolean insert(Personnel personnel) throws SQLException {

        String sql = """
                INSERT INTO personnel (
                    employee_number,
                    position,
                    department,
                    hire_date,
                    employment_status,
                    first_name,
                    last_name,
                    middle_name,
                    suffix,
                    prefix,
                    sex,
                    birth_date,
                    civil_status,
                    email,
                    primary_contact_number,
                    secondary_contact_number,
                    address1,
                    address2,
                    city_municipality,
                    sss_number,
                    tin_number,
                    philhealth_number,
                    pagibig_number,
                    government_id_number,
                    emergency_contact_name,
                    emergency_contact_relationship,
                    emergency_contact_number,
                    is_active,
                    last_active_date,
                    notes
                )
                VALUES (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                )
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Employment Information
            stmt.setString(1, personnel.getEmployeeNumber());
            stmt.setString(2, personnel.getPosition());
            stmt.setString(3, personnel.getDepartment());
            stmt.setString(4, personnel.getHireDate().toString());
            stmt.setString(5, personnel.getEmploymentStatus());

            // Personal Information
            stmt.setString(6, personnel.getFirstName());
            stmt.setString(7, personnel.getLastName());
            stmt.setString(8, personnel.getMiddleName());
            stmt.setString(9, personnel.getSuffix());
            stmt.setString(10, personnel.getPrefix());
            stmt.setString(11, personnel.getSex());
            stmt.setString(12, personnel.getBirthDate().toString());
            stmt.setString(13, personnel.getCivilStatus());

            // Contact Information
            stmt.setString(14, personnel.getEmail());
            stmt.setString(15, personnel.getPrimaryContactNumber());
            stmt.setString(16, personnel.getSecondaryContactNumber());
            stmt.setString(17, personnel.getAddress1());
            stmt.setString(18, personnel.getAddress2());
            stmt.setString(19, personnel.getCityMunicipality());

            // Government Identification
            stmt.setString(20, personnel.getSssNumber());
            stmt.setString(21, personnel.getTinNumber());
            stmt.setString(22, personnel.getPhilHealthNumber());
            stmt.setString(23, personnel.getPagibigNumber());
            stmt.setString(24, personnel.getGovernmentIdNumber());

            // Emergency Contact
            stmt.setString(25, personnel.getEmergencyContactName());
            stmt.setString(26, personnel.getEmergencyContactRelationship());
            stmt.setString(27, personnel.getEmergencyContactNumber());

            // Employee Status
            stmt.setInt(28, personnel.getIsActive() ? 1 : 0);

            if (personnel.getLastActiveDate() != null) {

                stmt.setString(29, personnel.getLastActiveDate().toString());
            } else {

                stmt.setNull(29, java.sql.Types.VARCHAR);
            }

            // Additional Notes
            stmt.setString(30, personnel.getNotes());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {

                try (var rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        personnel.setId(rs.getInt(1));
                    }
                }

                return true;
            }

            return false;
        }
    }

    /**
     * Retrieve all personnel records from the database.
     * 
     * @return An array of Personnel objects.
     * @throws SQLException If a database access error occurs.
     */
    public Personnel[] getAll() throws SQLException {

        // how many records in personnel table
        String countSQL = "SELECT COUNT(*) FROM personnel";

        int count = 0;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(countSQL);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }

        Personnel[] personnelList = new Personnel[count];

        String sql = "SELECT * FROM personnel";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            int index = 0;

            while (rs.next()) {
                personnelList[index] = mapResultSetToPersonnel(rs);
                index++;
            }
        }

        return personnelList;
    }

    /**
     * Retrieve a single Personnel record based on the employee number.
     * 
     * @param employeeNumber The employee number (EmployeeId) of the personnel to
     *                       retrieve.
     * 
     * @return The Personnel object with the specified employee number, or null if
     *         not found.
     * 
     * @throws SQLException If a database access error occurs.
     */
    public Personnel getByEmployeeNumber(String employeeNumber) throws SQLException {

        String sql = "SELECT * FROM personnel WHERE employee_number = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employeeNumber);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    // return the Personnel
                    return mapResultSetToPersonnel(rs);
                }
            }
        }

        return null;
    }

    /**
     * Update an existing personnel record in the database.
     * 
     * @param personnel The Personnel object containing the updated information.
     * 
     * @return true if the update was successful, false otherwise.
     * 
     * @throws SQLException If a database access error occurs.
     */
    public boolean update(Personnel personnel) throws SQLException {

        String sql = """
                UPDATE personnel SET
                    employee_number = ?,
                    position = ?,
                    department = ?,
                    hire_date = ?,
                    employment_status = ?,
                    first_name = ?,
                    last_name = ?,
                    middle_name = ?,
                    suffix = ?,
                    prefix = ?,
                    sex = ?,
                    birth_date = ?,
                    civil_status = ?,
                    email = ?,
                    primary_contact_number = ?,
                    secondary_contact_number = ?,
                    address1 = ?,
                    address2 = ?,
                    city_municipality = ?,
                    sss_number = ?,
                    tin_number = ?,
                    philhealth_number = ?,
                    pagibig_number = ?,
                    government_id_number = ?,
                    emergency_contact_name = ?,
                    emergency_contact_relationship = ?,
                    emergency_contact_number = ?,
                    is_active = ?,
                    last_active_date = ?,
                    notes = ?
                WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Employment Information
            stmt.setString(1, personnel.getEmployeeNumber());
            stmt.setString(2, personnel.getPosition());
            stmt.setString(3, personnel.getDepartment());
            stmt.setString(4, personnel.getHireDate().toString());
            stmt.setString(5, personnel.getEmploymentStatus());

            // Personal Information
            stmt.setString(6, personnel.getFirstName());
            stmt.setString(7, personnel.getLastName());
            stmt.setString(8, personnel.getMiddleName());
            stmt.setString(9, personnel.getSuffix());
            stmt.setString(10, personnel.getPrefix());
            stmt.setString(11, personnel.getSex());
            stmt.setString(12, personnel.getBirthDate().toString());
            stmt.setString(13, personnel.getCivilStatus());

            // Contact Information
            stmt.setString(14, personnel.getEmail());
            stmt.setString(15, personnel.getPrimaryContactNumber());
            stmt.setString(16, personnel.getSecondaryContactNumber());
            stmt.setString(17, personnel.getAddress1());
            stmt.setString(18, personnel.getAddress2());
            stmt.setString(19, personnel.getCityMunicipality());

            // Government Identification
            stmt.setString(20, personnel.getSssNumber());
            stmt.setString(21, personnel.getTinNumber());
            stmt.setString(22, personnel.getPhilHealthNumber());
            stmt.setString(23, personnel.getPagibigNumber());
            stmt.setString(24, personnel.getGovernmentIdNumber());

            // Emergency Contact
            stmt.setString(25, personnel.getEmergencyContactName());
            stmt.setString(26, personnel.getEmergencyContactRelationship());
            stmt.setString(27, personnel.getEmergencyContactNumber());

            // Employee Status
            stmt.setInt(28, personnel.getIsActive() ? 1 : 0);

            if (personnel.getLastActiveDate() != null) {
                stmt.setString(29, personnel.getLastActiveDate().toString());
            } else {
                stmt.setNull(29, java.sql.Types.VARCHAR);
            }

            // Additional Notes
            stmt.setString(30, personnel.getNotes());

            // Record to update
            stmt.setInt(31, personnel.getId());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }

    /**
     * Delete a personnel record from the database based on the record ID.
     * 
     * @param id The ID of the personnel record to delete.
     * 
     * @return true if the deletion was successful, false otherwise.
     * 
     * @throws SQLException If a database access error occurs.
     */
    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM personnel WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }

    private Personnel mapResultSetToPersonnel(ResultSet rs) throws SQLException {

        return new Personnel(
                // Personal Information (Person)
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("middle_name"),
                rs.getString("suffix"),
                rs.getString("prefix"),
                rs.getString("sex"),
                LocalDate.parse(rs.getString("birth_date")),
                rs.getString("civil_status"),
                rs.getString("email"),
                rs.getString("primary_contact_number"),
                rs.getString("secondary_contact_number"),
                rs.getString("address1"),
                rs.getString("address2"),
                rs.getString("city_municipality"),

                // Employment Information (Personnel)
                rs.getString("employee_number"),
                rs.getString("position"),
                rs.getString("department"),
                LocalDate.parse(rs.getString("hire_date")),
                rs.getString("employment_status"),

                // Government Identification
                rs.getString("sss_number"),
                rs.getString("tin_number"),
                rs.getString("philhealth_number"),
                rs.getString("pagibig_number"),
                rs.getString("government_id_number"),

                // Emergency Contact
                rs.getString("emergency_contact_name"),
                rs.getString("emergency_contact_relationship"),
                rs.getString("emergency_contact_number"),

                // Employee Status
                rs.getInt("is_active") == 1,
                rs.getString("last_active_date") != null
                        ? LocalDate.parse(rs.getString("last_active_date"))
                        : null,

                // Additional Notes
                rs.getString("notes"));
    }

}