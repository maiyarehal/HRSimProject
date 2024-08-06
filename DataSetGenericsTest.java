/**
 * @author Maiya Rehal
 */

package edu.waketech.csc251.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import java.util.List;

/**
 * Unit tests for the DataSetGeneric class.
 */
public class DataSetGenericsTest {

    private DataSetGeneric<Employee> dataStore;
    private Employee emp1, emp2;
    private Manager man1, man2;
    private Executive exe1, exe2;

    /**
     * Sets up the test environment before each test.
     * Initializes the dataStore and adds Employee, Manager, and Executive objects.
     */
    @BeforeEach
    public void setUp() {
        dataStore = new DataSetGeneric<>();
        emp1 = new Employee("Bailey", 50000);
        emp2 = new Employee("Luke", 50000);
        man1 = new Manager("Dave", 900000, "IT");
        man2 = new Manager("Alexis", 85000, "HR");
        exe1 = new Executive("Cameron", 100000, "COO", 0.1);
        exe2 = new Executive("Jacob", 150000, "CEO", 0.2);
        
        dataStore.add(emp1);
        dataStore.add(emp2);
        dataStore.add(man1);
        dataStore.add(man2);
        dataStore.add(exe1);
        dataStore.add(exe2);
    }

    /**
     * Tests if the dataStore correctly adds elements and returns the correct size.
     */
    @Test
    public void testAddAndSize() {
        assertEquals(6, dataStore.size());
    }

    /**
     * Tests if the getList method returns the correct list size.
     */
    @Test
    public void testGetList() {
        List<Employee> list = dataStore.getList();
        assertEquals(6, list.size());
    }

    /**
     * Tests if the getList method with EmployeeOnlyScreen returns the correct list of employees.
     */
    @Test
    public void testGetListWithEmployeeOnlyScreen() {
        List<Employee> list = dataStore.getList(new EmployeeOnlyScreen());
        assertEquals(2, list.size());
        assertTrue(list.contains(emp1));
        assertTrue(list.contains(emp2));
    }

    /**
     * Tests if the getList method with ManagerOnlyScreen returns the correct list of managers.
     */
    @Test
    public void testGetListWithManagerOnlyScreen() {
        List<Employee> list = dataStore.getList(new ManagerOnlyScreen());
        assertEquals(2, list.size());
        assertTrue(list.contains(man1));
        assertTrue(list.contains(man2));
    }

    /**
     * Tests if the getList method with ExecutiveScreen returns the correct list of executives.
     */
    @Test
    public void testGetListWithExecutiveScreen() {
        List<Employee> list = dataStore.getList(new ExecutiveScreen());
        assertEquals(2, list.size());
        assertTrue(list.contains(exe1));
        assertTrue(list.contains(exe2));
    }
}
