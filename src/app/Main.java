package app;

import models.Personnel;
import java.time.LocalDate;
import dao.PersonnelDAO;
import java.sql.SQLException;
import database.DatabaseConnection;
import database.DatabaseInitializer;

/**
 * Main entry point.
 *
 * <p>
 * Sample usage of Personnel class.
 * </p>
 *
 * @author CSCC 20 class of 2026-2027
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        PersonnelDAO personnelDAO = new PersonnelDAO();

        // 1. Create a Personnel object

        Personnel personnel = new Personnel(
                "Juan", // firstName
                "Dela Cruz", // lastName
                "Santos", // middleName
                "Jr.", // suffix
                "Mr.", // prefix
                "Male", // sex
                LocalDate.of(1990, 5, 15), // birthDate
                "Married", // civilStatus
                "juan.delacruz@example.com", // email
                "09171234567", // primaryContactNumber
                "09281234567", // secondaryContactNumber
                "123 Main Street", // address1
                "Subdivision XYZ", // address2
                "Cagayan de Oro", // cityMunicipality

                // Personnel Information
                "EMP-2026-001", // employeeNumber
                "IT Officer", // position
                "Information Technology", // department
                LocalDate.of(2020, 6, 1), // hireDate
                "Permanent", // employmentStatus

                // Government Identification
                "12-3456789-0", // sssNumber
                "123-456-789", // tinNumber
                "12-345678901-2", // philHealthNumber
                "1234-5678-9012", // pagibigNumber
                "N/A", // governmentIdNumber

                // Emergency Contact
                "Maria Dela Cruz", // emergencyContactName
                "Spouse", // emergencyContactRelationship
                "09181234567", // emergencyContactNumber

                // Employee Status
                true, // isActive
                null, // lastActiveDate

                // Additional Notes
                "Initial personnel record");

        try {

            // 2. Save Personnel into the database

            boolean saved = personnelDAO.insert(personnel);

            if (saved) {

                System.out.println("Personnel successfully saved!");
                // System.out.println("Generated ID: " + personnel.getId());

                // 3. Retrieve the saved Personnel

                Personnel retrievedPersonnel = personnelDAO.getByEmployeeNumber(personnel.getEmployeeNumber());

                // 4. Display retrieved information

                if (retrievedPersonnel != null) {

                    System.out.println("\nRetrieved Personnel Information:");
                    System.out.println("--------------------------------");

                    retrievedPersonnel.displayInformation();

                } else {
                    System.out.println("Personnel record not found.");
                }

            } else {
                System.out.println("Failed to save Personnel.");

            }

        } catch (SQLException e) {

            System.err.println("Database operation failed:");
            e.printStackTrace();

        }
    }
}