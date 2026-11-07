package app;

import models.Personnel;
import java.time.LocalDate;

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

        // Create a Personnel object
        Personnel personnel = new Personnel(

            // Personal Information
            "Juan",
            "Dela Cruz",
            "Santos",
            "Jr.",
            "Mr.",
            "Male",
            LocalDate.of(1990, 5, 15),
            "Married",
            "juan.delacruz@example.com",
            "09171234567",
            "09281234567",
            "123 Main Street",
            "Subdivision XYZ",
            "Cagayan de Oro",

            // Employment Information
            "EMP-2026-001",
            "IT Officer",
            "Information Technology",
            LocalDate.of(2020, 6, 1),
            "Permanent",

            // Government Identification
            "12-3456789-0",
            "123-456-789-000",
            "12-345678901-2",
            "1234-5678-9012",
            "N01-23-456789",

            // Emergency Contact
            "Maria Dela Cruz",
            "Spouse",
            "09181234567",

            // Employee Status
            true,
            null,

            // Additional Notes
            "Regular employee of the organization."
        );

        // Display personnel information
        personnel.displayInformation();

    }

}