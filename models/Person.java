package models;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents the basic properties of a person.
 * 
 * <p>
 * This abstract class is intended to be extended by other classes. This serves as an abstract superclass for different types of personnel used in the systme.
 * </p>
 * <p>
 * It contains common properties and methods for all types of persons.
 * </p>
 * 
 * <p>
 * Subclasses may include Personnel, Teacher, and other types of persons used.
 * </p>
 * 
 * @author CSCC 20 class of 2026-2027
 * @version 1.0
 */
public abstract class Person {

    // Personal Information

    /** The first name of the person */
    protected String firstName;

    /** The last name or family name of the person */
    protected String lastName;

    /** The middle name of the person */
    protected String middleName;
    /** The name suffix of the person, such as Jr., Sr., or III */
    protected String suffix;
    /** The name prefix of the person, such as Mr., Ms., or Dr. */
    protected String prefix;

    /** The biological sex of the person */
    protected String sex;
    /** The birthdate of the person */
    protected LocalDate birthDate;
    /** The civil status of the person, such as Single, Married, Widowed, or Divorced. */
    protected String civilStatus;
    
    // Contact Information
    /** The email address of the person */
    protected String email;
    /** The primary contact number of the person */
    protected String primaryContactNumber;
    /** The secondary or backup number of the person */
    protected String secondaryContactNumber;
    /** The house and street address of the person */
    protected String address1;
    /** The local community or barangay address */
    protected String address2;
    /** The city or municipality of the person */
    protected String cityMunicipality;

    /**
     * Creates an instance of a person
     * 
     * <p>
     * This default constructor will called by the subclasses and be used to create an instance of a person with default values.
     * </p>
     */
    public Person() {}


    /**
     * Creates an instance of a person with the specified properties.
     * 
     * @param firstName (String, required) the first name of the person
     * @param lastName (String, required) the last name or family name of the person
     * @param middleName (String, optional) the middle name of the person
     * @param suffix (String, optional) the name suffix, such as Jr., Sr., or III
     * @param prefix (String, optional) the name prefix, such as Mr., Ms., or Dr.
     * @param sex (String, required) the biological sex of the person
     * @param birthDate (LocalDate, required) the birth date of the person
     * @param civilStatus (String, required) the civil status of the person, such as "Single", "Married", "Widowed", or "Divorced"
     * @param email (String, optional) the email address of the person
     * @param primaryContactNumber (String, optional) the primary contact number
     * @param secondaryContactNumber (String, optional) the secondary contact number
     * @param address1 (String, optional) the primary residential address
     * @param address2 (String, optional) additional address information
     * @param cityMunicipality (String, optional) the city or municipality of residence
     */
    public Person(
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
        String cityMunicipality
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.prefix = prefix;
        this.sex = sex;
        this.birthDate = birthDate;
        this.civilStatus = civilStatus;
        this.email = email;
        this.primaryContactNumber = primaryContactNumber;
        this.secondaryContactNumber = secondaryContactNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.cityMunicipality = cityMunicipality;
    }

    /**
     * Returns the full name of the person
     * 
     * <p>
     * The returned value (string) will be formatted as: <br>
     * [Prefix] [First Name] [Middle Name] [Last Name] [Suffix]
     * </p>
     * <p>
     * The prefix and suffix are optional.
     * </p>
     * 
     * @return the complete name of the person
     */
    public String getFullName() {
        
        // Use StringBuilder for string concatenation
        StringBuilder sb = new StringBuilder();

        // Add prefix if present
        if (prefix != null && !prefix.isBlank()) {
            
            sb.append(prefix.trim()).append(" ");
        }

        // Add first name
        if (firstName != null) {
            
            sb.append(firstName.trim());
        }

        // Add space before middle name if needed
        if (middleName != null && !middleName.isBlank()) {
            
            sb.append(" ").append(middleName.trim());
        }

        // Add space before last name
        sb.append(" ");

        // Add last name
        if (lastName != null) {
            
            sb.append(lastName.trim());
        }

        // Add suffix if present
        if (suffix != null && !suffix.isBlank()) {
            
            sb.append(" ").append(suffix.trim());
        }

        return sb.toString().trim();
    }

    public LocalDate getBirthDate() {

        return this.birthDate;
    }

    /**
     * Calculates the age of the person
     * @return the age of the person
     */
    public int calculateAge() {

        LocalDate start = getBirthDate();
        LocalDate end = LocalDate.now();

        return Period.between(start, end).getYears();
    }


    /****************** 
     * Abstract classes 
     ******************/
    
    /** 
     * Displays the information of the person
     */   
    public abstract void displayInformation();
}