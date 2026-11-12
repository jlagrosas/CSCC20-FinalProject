# Human Resource Information System (HRIS)

## 1. Project Overview

The **Human Resource Information System (HRIS)** is a Java-based application intended for CSCC20 class of 2026-2027, to demonstrate Object-Oriented Programming concepts: Encapsulation, Abstraction, Inheritance, and Polymorphism.

The project's main goal is to create a HR management system for an organization, school, or company. It allows users to perform basic HR operations such as adding, removing, and updating personnel records, as well as managing personnel information.

## 2. Project Objectives

The primary objectives of this project are to:

- Develop a centralized system for managing personnel information.
- Implement Object-Oriented Programming principles, including encapsulation, inheritance, abstraction, and polymorphism.

- Implement database operations using Java Database Connectivity (JDBC).
- Separate application logic, database operations, and user interface components.
- Provide a foundation for developing additional HRIS modules.

## 3. Technologies Used

| Technology | Purpose  |
|---         |---       |
| Java       | Primary programming language |
| Java AWT   | Graphical user interface |
| SQLite     | Relational database |
| JavaDoc    | API documentation |

## 4. System Architecture

The application follows a layered architecture to separate responsibilities.

| Layer                 | Responsibility    |
|---                    |---                |
| Application (`app`)   | Application entry point and initialization |
| Models (`models`)     | Represents system entities and their attributes |
| Services (`services`) | Implements business rules and application logic |
| DAO (`dao`)           | Handles database operations |
| Database (`database`) | Manages database connections and initialization |
| UI (`ui`)             | Provides graphical user interface components |


## 5. Project Structure

The project is organized into the following directories:

```text
HRIS/
│
├── src/
│   └── app/
│       └── Main.java
│
├── models/
│   ├── Person.java
│   ├── Personnel.java
│   ├── ...
│   └── AdminStaff.java
│
├── dao/
│   └── PersonnelDAO.java
│
├── resources/
│   ├── images/
│   └── icons/
│
├── database/
│   └── The database file
│
├── bin/
│   └── Compiled Java classes
│
├── docs/
│   └── Generated JavaDoc documentation
│
└── README.md
```

## 6. Object-Oriented Design

The system uses an inheritance hierarchy to represent individuals and employees.

Person (Abstract Class)

Represents a human individual and contains common personal and contact information.

**Personnel (Concrete Class)**

Extends Person and introduces employment-related information, including:

- Employee number
- Position 
- Department
- Hire date
- Employment status
- Government identification numbers
- Emergency contact information

**Personnel Subclasses**

The system can accommodate different personnel categories through inheritance.

- Teacher
- AdminStaff

These subclasses can introduce attributes and methods specific to their respective personnel categories.

## 7. Getting Started

### Prerequisites

Before running the application, you will need to have the following installed on your computer:

- Java Development Kit (JDK 17 or later recommended).
- Java compiler (javac).
- Java runtime (java).
- git (https://git-scm.com/)
- account in github (https://github.com)


### Project Compilation

Open terminal (or cmd), and go to the project folder and run the following:

```
javac -cp "lib/sqlite-jdbc-3.54.1.0.jar" -d bin -sourcepath . $(find models database dao services ui src -name "*.java"
```

The -d bin option instructs the Java compiler to place compiled .class files inside the bin directory.

### Running the Main App
After successful compilation, you can run the application by executing:

```
java --enable-native-access=ALL-UNNAMED -cp "bin:lib/*" app.Main
```


