# Payroll Management System
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
