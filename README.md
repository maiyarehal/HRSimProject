# Payroll Management System

## Overview

This Payroll Management System is a simple Java application designed to manage and handle employee data within an organization. It allows for the addition of employees, managers, and executives, and provides various functionalities such as listing employees, sorting, and generating payroll reports.

## Features

- **Add Employee:** Allows the user to add regular employees, managers, and executives.
- **List Employees:** Displays all employees or filtered lists of regular employees, managers, or executives.
- **Sort Employees:** Provides options to sort employees by name (then salary) or by salary (then name).
- **Generate Payroll:** Calculates and displays the total payroll.
- **Show Highest Salary:** Displays the employee with the highest salary.

## Class Descriptions

### `edu.waketech.csc251.collection`

- **`DataSetGeneric<T extends Measurable>`**
  - A generic class to manage a collection of items that implement the `Measurable` interface.
  - Methods:
    - `add(T item)`: Adds an item to the collection.
    - `size()`: Returns the size of the collection.
    - `getList()`: Returns a list of all items in the collection.
    - `getList(Screener<T> screener)`: Returns a filtered list of items that pass the `Screener` test.

- **`Measurable`**
  - An interface that requires implementing a `getMeasure()` method returning an integer measure.
 
  ### `edu.waketech.csc251.hr`

- **`Payroll`**
  - The main class that provides the user interface and handles user actions.
  - Includes methods to add employees, display lists, sort employees, and generate payroll reports.

### `edu.waketech.csc251.hr.mgmt`

- **`Executive`**
  - Extends `Manager` and includes a bonus attribute.
  - Overrides the `getSalary()` method to include the bonus.

- **`ExecutiveScreen`**
  - Implements the `Screener<Employee>` interface to filter only `Executive` instances.
 
- **`Manager`**
  - Extends `Employee` and includes a department attribute.

- **`ManagerOnlyScreen`**
  - Implements the `Screener<Employee>` interface to filter only `Manager` instances, excluding `Executive`.
    
### `edu.waketech.csc251.hr.person`

- **`Employee`**
  - Implements the `Measurable` interface.
  - Includes name and salary attributes.

- **`EmployeeOnlyScreen`**
  - Implements the `Screener<Employee>` interface to filter only regular `Employee` instances.

### `edu.waketech.csc251.hr.test`

- **`EmployeeTest`**
  - Unit tests for the `Employee` class.

- **`ExecutiveTest`**
  - Unit tests for the `Executive` class.

- **`ManagerTest`**
  - Unit tests for the `Manager` class.

### `edu.waketech.csc251.test`

- **`DataSetGenericsTest`**
  - Unit tests for the `DataSetGeneric` class.

### `edu.waketech.csc251.tools`

- **`Screener<T>`**
  - An interface to define a screening method for filtering objects.

- **`Utils`**
  - Utility methods for user interactions such as displaying lists and handling menu selections.

## Running the Application

1. **Compile the Code:**
   ```sh
   javac -d bin src/**/*.java

2. **Run the Application:**
   ```sh
   java -cp bin edu.waketech.csc251.hr.Payroll

4. **Follow the on-screen menu to perform various operations.**

## Unit Test
- To run the unit tests, you can use a testing framework like JUnit. Ensure that all dependencies are properly configured.

1. **Compile the Tests:**
   ```sh
   javac -d bin -cp .:path/to/junit.jar src/**/*.java

3. **Run the Tests:**
   ```sh
   java -cp .:bin:path/to/junit.jar org.junit.runner.JUnitCore edu.waketech.csc251.hr.test.EmployeeTest
   java -cp .:bin:path/to/junit.jar org.junit.runner.JUnitCore edu.waketech.csc251.hr.test.ExecutiveTest
   java -cp .:bin:path/to/junit.jar org.junit.runner.JUnitCore edu.waketech.csc251.hr.test.ManagerTest
   java -cp .:bin:path/to/junit.jar org.junit.runner.JUnitCore edu.waketech.csc251.test.DataSetGenericsTest
