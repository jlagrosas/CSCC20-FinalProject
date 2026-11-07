package models;

import java.time.LocalDate;


/**
 * Personnel Class (Subclass of abstract class Person)
 * This class contains fields and methods for an employee of the organization.
 * 
 * @author CSCC 20 class of 2026-2027
 * @version 1.0
 */
public class Personnel extends Person {
    
    /**********************
    * Employee Information
    **********************/

    /** Employee Number (employeeID). */
    private String employeeNumber;
    /** Position currently held in the company. */
    private String position;
    /** Department which the employee belongs to. */
    private String department;
    /** Date when the employee was hired. */
    private LocalDate hireDate;
    
    /** Employment Status, e.g. Full-time, Part-time */
    private String employmentStatus;
    
    /** The SSS number of the employee */
    private String sssNumber;
    /** Tax Identification Number */
    private String tinNumber;
    /** Phil Health number of the employee */
    private String philHealthNumber;
    /** Pag-ibig number of the employee */
    private String pagibigNumber;
    /** The government-issued ID number of the employee (e.g., Passport, Driver's License, etc.) */
    private String governmentIdNumber;
    
    // Emergency Contacts
    /** In-case of Emergency contact person */
    private String emergencyContactName;
    /** Emergency person relationship, e.g. Spouse, Parent, etc. */
    private String emergencyContactRelationship;
    /** Emergency contact number */
    private String emergencyContactNumber;
    
    // Employee Status
    /** Is employee status, active */
    private boolean isActive;
    /** Last active date */
    private LocalDate lastActiveDate;
        
    
    // Employee Notes
    /** Additional notes associated with the employee */
    private String notes;
    
   
    /**
     * Creates a Personnel object 
     *
     * @param firstName (String, required) the personnel first name
     * @param lastName (String, required) the personnel last name
     * @param middleName (String, optional) the personnel middle name
     * @param suffix (String, optional) the name suffix of the personnel
     * @param prefix (String, optional) the name prefix of the personnel
     * @param sex (String, required) the biological sex of the personnel
     * @param birthDate (LocalDate, required) the birth date of the personnel
     * @param civilStatus (String, required) the civil status of the personnel
     * @param email (String, optional) the email address of the personnel
     * @param primaryContactNumber (String, required) the primary contact number of the personnel
     * @param secondaryContactNumber (String, optional) the secondary contact number of the personnel
     * @param address1 (String, required) the primary address of the personnel
     * @param address2 (String, optional) the secondary address
     * @param cityMunicipality (String, required) the city or municipality
     * @param employeeNumber (String, required) the employee number
     * @param position (String, required) the employee's position (current)
     * @param department (String, required) the employee's department
     * @param hireDate (LocalDate, required) the employee's hiring date
     * @param employmentStatus (String, required) the employment status
     * @param sssNumber (String, optional) the SSS number
     * @param tinNumber (String, optional) the tax identification number
     * @param philHealthNumber (String, optional) the PhilHealth number
     * @param pagibigNumber (String, optional) the Pag-IBIG number
     * @param governmentIdNumber (String, optional) the government-issued ID number
     * @param emergencyContactName (String, optional) the emergency contact person's name
     * @param emergencyContactRelationship (String, optional) the relationship to the employee
     * @param emergencyContactNumber (String, optional) the emergency contact number
     * @param isActive (boolean) indicates whether the employee is active
     * @param lastActiveDate (LocalDate, optional) the employee's last active date
     * @param notes (String, optional) additional employee notes
     */
    public Personnel(
        String firstName,
        String lastName,
        String middleName,
        String suffix,
        String prefix,
        String sex,
        LocalDate birthDate,
        String civilStatus,
        String email,
        String primaryContactNumber,
        String secondaryContactNumber,
        String address1,
        String address2,
        String cityMunicipality,

        String employeeNumber,
        String position,
        String department,
        LocalDate hireDate,
        String employmentStatus,

        String sssNumber,
        String tinNumber,
        String philHealthNumber,
        String pagibigNumber,
        String governmentIdNumber,

        String emergencyContactName,
        String emergencyContactRelationship,
        String emergencyContactNumber,

        boolean isActive,
        LocalDate lastActiveDate,

        String notes
    ) {

        // Initialize inherited Person attributes
        super(
            firstName,
            lastName,
            middleName,
            suffix,
            prefix,
            sex,
            birthDate,
            civilStatus,
            email,
            primaryContactNumber,
            secondaryContactNumber,
            address1,
            address2,
            cityMunicipality
        );

        // Initialize Employee Information
        this.employeeNumber = employeeNumber;
        this.position = position;
        this.department = department;
        this.hireDate = hireDate;
        this.employmentStatus = employmentStatus;

        // Initialize Government Identification
        this.sssNumber = sssNumber;
        this.tinNumber = tinNumber;
        this.philHealthNumber = philHealthNumber;
        this.pagibigNumber = pagibigNumber;
        this.governmentIdNumber = governmentIdNumber;

        // Initialize Emergency Contacts
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactRelationship = emergencyContactRelationship;
        this.emergencyContactNumber = emergencyContactNumber;

        // Initialize Employee Status
        this.isActive = isActive;
        this.lastActiveDate = lastActiveDate;

        // Initialize Employee Notes
        this.notes = notes;
    }


    /**
     * Displays the complete personal, employment, government
     * identification, and emergency contact information
     * of the employee.
     *
     * This method overrides the abstract displayInformation()
     * method declared in the Person superclass.
     */
    @Override
    public void displayInformation() {

        System.out.println("\n==========================================");
        System.out.println("          PERSONNEL INFORMATION");
        System.out.println("==========================================");

        // Personal Information
        System.out.println("\nPERSONAL INFORMATION");
        System.out.println("------------------------------------------");
        System.out.println("Full Name: " + getFullName());
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Prefix: " + prefix);
        System.out.println("Suffix: " + suffix);
        System.out.println("Sex: " + sex);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Civil Status: " + civilStatus);

        // Contact Information
        System.out.println("\nCONTACT INFORMATION");
        System.out.println("------------------------------------------");
        System.out.println("Email: " + email);
        System.out.println("Primary Contact: " + primaryContactNumber);
        System.out.println("Secondary Contact: " + secondaryContactNumber);
        System.out.println("Address 1: " + address1);
        System.out.println("Address 2: " + address2);
        System.out.println("City/Municipality: " + cityMunicipality);

        // Employment Information
        System.out.println("\nEMPLOYMENT INFORMATION");
        System.out.println("------------------------------------------");
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Employment Status: " + employmentStatus);

        // Government Identification
        System.out.println("\nGOVERNMENT IDENTIFICATION");
        System.out.println("------------------------------------------");
        System.out.println("SSS Number: " + sssNumber);
        System.out.println("TIN Number: " + tinNumber);
        System.out.println("PhilHealth Number: " + philHealthNumber);
        System.out.println("Pag-IBIG Number: " + pagibigNumber);
        System.out.println("Government ID: " + governmentIdNumber);

        // Emergency Contact
        System.out.println("\nEMERGENCY CONTACT");
        System.out.println("------------------------------------------");
        System.out.println("Contact Name: " + emergencyContactName);
        System.out.println("Relationship: " + emergencyContactRelationship);
        System.out.println("Contact Number: " + emergencyContactNumber);

        // Employee Status
        System.out.println("\nEMPLOYEE STATUS");
        System.out.println("------------------------------------------");
        System.out.println("Active: " + (isActive ? "Yes" : "No"));
        System.out.println("Last Active Date: " + lastActiveDate);

        // Additional Notes
        System.out.println("\nADDITIONAL INFORMATION");
        System.out.println("------------------------------------------");
        System.out.println("Notes: " + notes);

        System.out.println("\n==========================================");

    }
}