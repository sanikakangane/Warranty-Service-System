# Product Warranty & Service Claim Management System

## Overview

The Product Warranty & Service Claim Management System is a Java-based desktop application designed to manage product warranties, customer service claims, and repair appointments.

The system provides a centralized way to register products, track warranty periods, create and manage service claims, schedule repairs, search records, and identify expired warranties.

The project demonstrates core Java programming concepts through a practical warranty management workflow with a Java Swing graphical user interface.

## Objectives

- Register products with customer and purchase details
- Maintain product and warranty information
- Apply category-specific warranty rules
- Create and manage customer service claims
- Schedule repair appointments
- Validate warranty eligibility before processing claims
- Identify expired warranties
- Search and sort product and claim records
- Perform CRUD operations on system records
- Handle invalid input and warranty-related exceptions
- Provide a desktop GUI using Java Swing

## Main Modules

### Product Registration

Allows the user to register products using Product ID, Product Name, Serial Number, Purchase Date, Customer Name, and Product Category.

Supported categories include Electronics, Appliance, and Gadget.

### Warranty Tracking

The system calculates and tracks warranty information based on the selected product category. Warranty validity is checked before processing eligible service claims.

### Claim Management

Customers can create service claims using Claim ID, Product ID, Issue Details, and Claim Status.

Each claim is associated with a registered product and can be tracked independently.

### Repair Scheduling

Valid service claims can be scheduled for repair using a repair date. The repair appointment is handled separately from the original product purchase date.

### Search and Reports

The system provides functionality to search, sort, and display product, warranty, and claim-related information.

## Java Concepts Used

- Object-Oriented Programming
- Classes and Objects
- Constructors
- Abstraction
- Inheritance
- Method Overriding
- ArrayList
- LinkedList
- HashMap
- TreeMap
- CRUD Operations
- Searching
- Sorting
- Exception Handling
- Custom Exceptions
- Input Validation
- Java Swing GUI

## Project Structure

src/
├── Product.java
├── Electronics.java
├── Appliance.java
├── Gadget.java
├── Warranty.java
├── Claim.java
├── ClaimStatus.java
├── ServiceCenter.java
├── ExpiredWarrantyException.java
├── WarrantyManagementGUI.java
└── Main.java

## Class Responsibilities

| Class | Responsibility |
|---|---|
| Product | Base class containing common product information and warranty behavior |
| Electronics | Provides category-specific product and warranty behavior |
| Appliance | Provides category-specific product and warranty behavior |
| Gadget | Provides category-specific product and warranty behavior |
| Warranty | Stores warranty-related information and expiry details |
| Claim | Represents a customer service claim |
| ClaimStatus | Represents the current state of a service claim |
| ServiceCenter | Manages products, warranties, claims, searching, sorting, and service operations |
| ExpiredWarrantyException | Handles expired warranty conditions |
| WarrantyManagementGUI | Provides the Java Swing graphical interface |
| Main | Starts the application |

## System Workflow

1. Start the Java application.
2. Open the Product & Warranty section.
3. Enter product and customer details.
4. Select the product category.
5. Register the product.
6. Calculate the applicable warranty information.
7. File a service claim when required.
8. Validate the warranty and claim details.
9. Schedule a repair appointment for a valid claim.
10. Search or sort records when required.
11. View service and warranty information.

## Data Structures

### ArrayList

Used to maintain expandable collections of products and claims.

### LinkedList

Used for sequential claim history and related operations.

### HashMap

Used for fast lookup using keys such as Product ID.

### TreeMap

Used to maintain entries in sorted key order.

## Exception Handling and Validation

The project includes a custom ExpiredWarrantyException to handle situations where a service claim is attempted after the warranty has expired.

The system also validates:

- Required product information
- Date formats
- Claim information
- Warranty eligibility
- Invalid input

User-friendly validation messages are displayed through the GUI.

## CRUD Operations

| Operation | Use in System |
|---|---|
| Create | Register a product or create a service claim |
| Read | Display product, warranty, and claim records |
| Update | Modify relevant service information |
| Delete | Remove records when required |

## Graphical User Interface

The application uses Java Swing to provide a desktop interface with three main functional areas:

- Product & Warranty
- Claims & Repair
- Search & Reports

The interface provides forms for entering product and claim information, action buttons for performing operations, and areas for displaying system results.

## Sample Scenario

A customer purchases a laptop and registers it in the system with the following information:

Product ID: P101
Product Name: Laptop
Serial Number: SN-LAP-101
Purchase Date: 2026-01-07
Customer: Aarav
Category: Electronics

A service claim can then be created:

Claim ID: C001
Issue: Laptop screen is not working

After the claim is validated, a repair appointment can be scheduled:

Repair Date: 2026-01-10

## Testing

| Test Case | Expected Result |
|---|---|
| Valid product registration | Product is registered successfully |
| Missing required field | Validation message is displayed |
| Invalid date | Invalid date is rejected |
| Valid service claim | Claim is created successfully |
| Expired warranty | Expired warranty condition is detected |
| Product or claim search | Matching records are displayed |
| Clear operation | Input fields are reset |
| Sorting | Records are displayed in sorted order |

## Advantages

- Centralizes product, warranty, and service claim information
- Reduces manual tracking of warranty periods
- Makes claim records easier to search and manage
- Supports category-specific warranty rules
- Improves reliability through validation and exception handling
- Provides a simple desktop GUI
- Demonstrates multiple core Java concepts in one practical application

## Future Enhancements

- Database integration using MySQL or PostgreSQL
- Customer and service-center staff login
- Automatic warranty expiry notifications
- Email or SMS notifications for repair appointments
- Downloadable service reports
- Dashboard for active claims, completed repairs, and expired warranties
- Role-based access control

## Technology Stack

- Language: Java
- GUI: Java Swing
- Application Type: Desktop GUI Application
- Programming Concepts: OOP, Collections, CRUD, Searching, Sorting, Exception Handling, and Validation

## Conclusion

The Product Warranty & Service Claim Management System demonstrates how Java can be used to develop a practical warranty and service management application.

The project combines object-oriented programming, abstraction, inheritance, method overriding, Java collections, CRUD operations, searching, sorting, validation, exception handling, and Swing GUI development to provide a structured workflow for product registration, warranty tracking, claim management, and repair scheduling.

## Author

Sanika Kangane 👩🏻‍💻
