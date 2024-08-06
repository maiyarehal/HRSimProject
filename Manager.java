package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.hr.person.Employee;

public class Manager extends Employee {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager [department=" + department + ", toString()=" + super.toString() + "]";
    }
}
