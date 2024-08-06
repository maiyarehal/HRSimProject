package edu.waketech.csc251.hr.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.waketech.csc251.hr.mgmt.Manager;

public class ManagerTest {

    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager("Bailey Cole", 70000, "HR");
    }

    @Test
    public void testGetDepartment() {
        assertEquals("HR", manager.getDepartment());
    }

    @Test
    public void testSetDepartment() {
        manager.setDepartment("IT");
        assertEquals("IT", manager.getDepartment());
    }

    @Test
    public void testToString() {
        String str = manager.toString();
        assertTrue(str.contains("Bailey Cole"));
        assertTrue(str.contains("HR"));
        assertTrue(str.contains("70000"));
    }
}
