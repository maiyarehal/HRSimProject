package edu.waketech.csc251.hr.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.Executive;

public class EmployeeTest {

    @Test
    public void testEmployeeCreation() {
        Employee emp = new Employee("Kaylee", 60000);
        assertEquals("Kaylee", emp.getName());
        assertEquals(60000, emp.getSalary());
    }

    @Test
    public void testManagerCreation() {
        Manager man = new Manager("Steven", 100000, "CEO");
        assertEquals("Steven", man.getName());
        assertEquals(100000, man.getSalary());
        assertEquals("CEO", man.getDepartment());
    }

    @Test
    public void testExecutiveCreation() {
        Executive exe = new Executive("John", 95000, "IT", 0.2);
        assertEquals("John", exe.getName());
        assertEquals(95000 * 1.0, exe.getSalary());
        assertEquals("IT", exe.getDepartment());
        assertEquals(0.4, exe.getBonus());
    }
}
