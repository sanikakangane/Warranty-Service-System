# Product Warranty & Service Claim Management System

## Overview

The Product Warranty & Service Claim Management System is a Java-based desktop application designed to manage product registration, warranty information, customer service claims, and repair scheduling.

The system provides a centralized workflow for registering products, tracking warranty periods, creating service claims, scheduling repairs, searching records, and managing service information through a Java Swing graphical user interface.

The project demonstrates core Java programming concepts including object-oriented programming, abstraction, inheritance, method overriding, collections, CRUD operations, searching, sorting, exception handling, validation, and GUI development.

## Features

- Product registration with customer and purchase details
- Category-based warranty management
- Warranty validity and expiry tracking
- Customer service claim management
- Claim status management
- Repair appointment scheduling
- Product and claim searching
- Record sorting
- CRUD operations
- Input validation
- Custom exception handling
- Java Swing graphical user interface
- Detailed project documentation

## Main Modules

### Product Registration

Allows users to register products using:

- Product ID
- Product Name
- Serial Number
- Purchase Date
- Customer Name
- Product Category

Supported categories include:

- Electronics
- Appliance
- Gadget

### Warranty Management

The system manages warranty information according to the selected product category and checks warranty validity before processing eligible service claims.

### Claim Management

Service claims can be created and managed using:

- Claim ID
- Product ID
- Issue Details
- Claim Status

Each claim is associated with a registered product and can be tracked independently.

### Repair Scheduling

Valid service claims can be scheduled for repair using a specified repair date.

### Search and Reports

The system provides functionality to search, sort, and display product, warranty, and claim-related information.

## Java Concepts Used

- Object-Oriented Programming
- Classes and Objects
- Constructors
- Abstraction
- Inheritance
- Method Overriding
- Encapsulation
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
- Java Swing

## Project Structure

Warranty-Service-System/
├── src/
│   ├── Product.java
│   ├── Electronics.java
│   ├── Appliance.java
│   ├── Gadget.java
│   ├── Warranty.java
│   ├── Claim.java
│   ├── ClaimStatus.java
│   ├── ServiceCenter.java
│   ├── ExpiredWarrantyException.java
│   ├── WarrantyManagementGUI.java
│   └── Main.java
├── Detailed-Report/
│   └── Product_Warranty_and_Service_Claim_Management_System.pdf
└── README.md

## Class Responsibilities

| Class | Responsibility |
|---|---|
| Product | Base class containing common product information and warranty behavior |
| Electronics | Represents electronics products and their warranty behavior |
| Appliance | Represents appliance products and their warranty behavior |
| Gadget | Represents gadget products and their warranty behavior |
| Warranty | Manages warranty-related information and expiry details |
| Claim | Represents a customer service claim |
| ClaimStatus | Represents the status of a service claim |
| ServiceCenter | Manages products, warranties, claims, searching, sorting, and service operations |
| ExpiredWarrantyException | Handles expired warranty conditions |
| WarrantyManagementGUI | Provides the Java Swing graphical interface |
| Main | Entry point used to start the application |

## System Workflow

1. Start the Java application.
2. Open the Product & Warranty section.
3. Enter product and customer details.
4. Select the product category.
5. Register the product.
6. Calculate and track the applicable warranty.
7. Create a service claim when required.
8. Validate the warranty and claim details.
9. Schedule a repair appointment for a valid claim.
10. Search or sort records when required.
11. View the required service and warranty information.

## Data Structures

### ArrayList

Used to maintain collections of products and claims.

### LinkedList

Used for sequential claim history and related operations.

### HashMap

Used for fast lookup of product or warranty information using keys such as Product ID.

### TreeMap

Used to maintain entries in sorted key order.

## Exception Handling and Validation

The project includes a custom ExpiredWarrantyException to handle situations where a service claim is attempted for a product whose warranty has expired.

The application also performs validation for:

- Required product information
- Date formats
- Claim information
- Warranty eligibility
- Invalid input

## CRUD Operations

| Operation | Purpose |
|---|---|
| Create | Register products and create service claims |
| Read | Display product, warranty, and claim information |
| Update | Modify relevant records |
| Delete | Remove records when required |

## Graphical User Interface

The application is developed using Java Swing and provides three main functional areas:

- Product & Warranty
- Claims & Repair
- Search & Reports

The interface provides input fields, selection controls, action buttons, and result areas for interacting with the system.

## Sample Scenario

A customer purchases a laptop and registers it with the following details:

- Product ID: P101
- Product Name: Laptop
- Serial Number: SN-LAP-101
- Purchase Date: 2026-01-07
- Customer: Aarav
- Category: Electronics

A service claim can then be created using:

- Claim ID: C001
- Product ID: P101
- Issue: Laptop screen is not working

After the claim is validated, a repair appointment can be scheduled for a suitable repair date.

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

## Technology Stack

- Language: Java
- GUI Framework: Java Swing
- Application Type: Desktop Application
- Data Structures: ArrayList, LinkedList, HashMap, TreeMap
- Documentation: PDF

## Documentation

The complete project report is available in the Detailed-Report folder.

Report file: Product_Warranty_and_Service_Claim_Management_System.pdf

The report contains the project introduction, objectives, modules, system design, Java concepts, implementation details, workflow, testing, advantages, future enhancements, and conclusion.

## Future Enhancements

- Database integration using MySQL or PostgreSQL
- Customer and service-center staff authentication
- Automatic warranty expiry notifications
- Email or SMS notifications for repair appointments
- Downloadable service reports
- Dashboard for active claims, completed repairs, and expired warranties
- Role-based access control

## Conclusion

The Product Warranty & Service Claim Management System demonstrates the practical application of Java programming concepts in a real-world warranty and service management scenario.

The project combines object-oriented programming, abstraction, inheritance, method overriding, collections, CRUD operations, searching, sorting, validation, exception handling, and Java Swing to provide a structured system for product registration, warranty management, service claims, and repair scheduling.

## Author

Sanika Kangane 👩🏻‍💻
