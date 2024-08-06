package edu.waketech.csc251.hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.tools.Utils;

public class Payroll {

    // Possible User Actions.
    public static final String MENU_EXIT = "Exit";
    public static final String MENU_ADD_EMPLOYEE = "Add Employee";
    public static final String MENU_ADD_MANAGER = "Add Manager";
    public static final String MENU_ADD_EXECUTIVE = "Add Executive";
    public static final String MENU_LIST_ALL = "List All";
    public static final String MENU_LIST_EMPLOYEE = "List (Regular) Employees";
    public static final String MENU_LIST_MANAGER = "List Managers";
    public static final String MENU_LIST_EXECUTIVE = "List Executives";
    public static final String MENU_SHOW_HIGHEST_SALARY_PERSON = "Show Highest Salary Person";
    public static final String MENU_GENERATE_PAYROLL = "Generate Payroll";
    public static final String MENU_SORT_BY_NAME_THEN_SALARY = "Display Sorted List by Name";
    public static final String MENU_SORT_BY_SALARY_THEN_NAME = "Display Sorted List By Salary";

    // Menu for user actions
    public static final String[] MAIN_MENU = { MENU_EXIT, MENU_ADD_EMPLOYEE, MENU_ADD_MANAGER, MENU_ADD_EXECUTIVE,
            MENU_LIST_ALL, MENU_LIST_EMPLOYEE, MENU_LIST_MANAGER, MENU_LIST_EXECUTIVE, MENU_SHOW_HIGHEST_SALARY_PERSON,
            MENU_GENERATE_PAYROLL, MENU_SORT_BY_NAME_THEN_SALARY, MENU_SORT_BY_SALARY_THEN_NAME, };

    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        DataSetGeneric<Employee> hrdb = new DataSetGeneric<>();

        String userChoice = Utils.userChoose(kybd, MAIN_MENU);
        while (!MENU_EXIT.equals(userChoice)) {
            if (MENU_ADD_EMPLOYEE.equals(userChoice)) {
                addEmployee(kybd, hrdb);
            } else if (MENU_ADD_MANAGER.equals(userChoice)) {
                addManager(kybd, hrdb);
            } else if (MENU_ADD_EXECUTIVE.equals(userChoice)) {
                addExecutive(kybd, hrdb);
            } else if (MENU_LIST_ALL.equals(userChoice)) {
                displayEverybody(kybd, hrdb);
            } else if (MENU_LIST_EMPLOYEE.equals(userChoice)) {
                displayOnlyEmployees(kybd, hrdb);
            } else if (MENU_LIST_MANAGER.equals(userChoice)) {
                displayOnlyManagers(kybd, hrdb);
            } else if (MENU_LIST_EXECUTIVE.equals(userChoice)) {
                displayOnlyExecutives(kybd, hrdb);
            } else if (MENU_SHOW_HIGHEST_SALARY_PERSON.equals(userChoice)) {
                displayHighestSalary(kybd, hrdb);
            } else if (MENU_GENERATE_PAYROLL.equals(userChoice)) {
                generatePayroll(kybd, hrdb);
            } else if (MENU_SORT_BY_NAME_THEN_SALARY.equals(userChoice)) {
                displaySortedByName(kybd, hrdb);
            } else if (MENU_SORT_BY_SALARY_THEN_NAME.equals(userChoice)) {
                displaySortedBySalary(kybd, hrdb);
            }

            userChoice = Utils.userChoose(kybd, MAIN_MENU);
        }
        System.out.println("Bye");
        kybd.close();
    }

    /**
     * Display the List of Employees sorted first by name, and then by salary
     * 
     * @param kybd      incoming data stream
     * @param dataStore DataSetGeneric to provide sorted Employees
     */
    private static void displaySortedByName(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        ArrayList<Employee> employees = (ArrayList<Employee>) dataStore.getList();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int nameCompare = e1.getName().compareTo(e2.getName());
                if (nameCompare == 0) {
                    return Double.compare(e1.getSalary(), e2.getSalary());
                } else {
                    return nameCompare;
                }
            }
        });
        Utils.userDisplay(kybd, employees);
    }

    /**
     * Display the list of Employees sorted first by salary, then by name.
     * 
     * @param kybd      incoming data stream
     * @param dataStore provides the sorted list of Employees
     */
    private static void displaySortedBySalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        ArrayList<Employee> employees = dataStore.getList();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int salaryCompare = Double.compare(e1.getSalary(), e2.getSalary());
                if (salaryCompare == 0) {
                    return e1.getName().compareTo(e2.getName());
                } else {
                    return salaryCompare;
                }
            }
        });
        Utils.userDisplay(kybd, employees);
    }

    /**
     * Add a regular employee to the data store
     * 
     * @param input     incoming data stream
     * @param dataStore will hold the new employee
     */
    public static void addEmployee(Scanner input, DataSetGeneric<Employee> dataStore) {
        System.out.print("Enter employee name: ");
        String name = input.next();
        System.out.print("Enter employee salary: ");
        double salary = input.nextDouble();
        Employee emp = new Employee(name, salary);
        dataStore.add(emp);
        System.out.println("Employee added: " + emp);
    }

    /**
     * Add an executive to the data store
     * 
     * @param input     incoming data stream
     * @param dataStore will hold the new executive
     */
    public static void addExecutive(Scanner input, DataSetGeneric<Employee> dataStore) {
        System.out.print("Enter executive name: ");
        String name = input.next();
        System.out.print("Enter executive salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter executive department: ");
        String department = input.next();
        System.out.print("Enter executive bonus: ");
        double bonus = input.nextDouble();
        Executive exec = new Executive(name, salary, department, bonus);
        dataStore.add(exec);
        System.out.println("Executive added: " + exec);
    }

    /**
     * Add a manager to the data store
     * 
     * @param input     incoming data stream
     * @param dataStore will hold the new manager
     */
    public static void addManager(Scanner input, DataSetGeneric<Employee> dataStore) {
        System.out.print("Enter manager name: ");
        String name = input.next();
        System.out.print("Enter manager salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter manager department: ");
        String department = input.next();
        Manager mgr = new Manager(name, salary, department);
        dataStore.add(mgr);
        System.out.println("Manager added: " + mgr);
    }

    /**
     * Display everybody in the data store
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void displayEverybody(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        Utils.userDisplay(kybd, dataStore.getList());
    }

    /**
     * Display the person with the highest salary
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void displayHighestSalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        Employee highestPaid = null;
        for (Employee emp : dataStore.getList()) {
            if (highestPaid == null || emp.getSalary() > highestPaid.getSalary()) {
                highestPaid = emp;
            }
        }
        ArrayList<Employee> result = new ArrayList<>();
        if (highestPaid != null) {
            result.add(highestPaid);
        }
        Utils.userDisplay(kybd, result);
    }

    /**
     * Display only the regular employees
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void displayOnlyEmployees(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        Utils.userDisplay(kybd, dataStore.getList(new EmployeeOnlyScreen()));
    }

    /**
     * Display only the executives
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void displayOnlyExecutives(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        Utils.userDisplay(kybd, dataStore.getList(new ExecutiveScreen()));
    }

    /**
     * Display only the managers
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void displayOnlyManagers(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        Utils.userDisplay(kybd, dataStore.getList(new ManagerOnlyScreen()));
    }

    /**
     * Generate a payroll for the employees
     * 
     * @param kybd      incoming data stream so the user can verify that the data
     *                  has been seen
     * @param dataStore containing the employees to be displayed
     */
    public static void generatePayroll(Scanner kybd, DataSetGeneric<Employee> dataStore) {
        double totalPayroll = 0;
        for (Employee emp : dataStore.getList()) {
            totalPayroll += emp.getSalary();
        }
        System.out.println("Total payroll: " + totalPayroll);
    }
}
