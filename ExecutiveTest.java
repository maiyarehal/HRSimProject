package edu.waketech.csc251.hr.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.waketech.csc251.hr.mgmt.Executive;

public class ExecutiveTest {

    private Executive executive;

    @BeforeEach
    public void setUp() {
        executive = new Executive("Robert Newton", 130000, "Finance", 0.4);
    }

    @Test
    public void testGetSalary() {
        assertEquals(130000, executive.getSalary(), 0.1);
    }

    @Test
    public void testGetBonus() {
        assertEquals(0.2, executive.getBonus(), 0.1);
    }

    @Test
    public void testSetBonus() {
        executive.setBonus(0.3);
        assertEquals(0.3, executive.getBonus(), 0.1);
    }

    @Test
    public void testToString() {
        String str = executive.toString();
        assertTrue(str.contains("Robert Newton"));
        assertTrue(str.contains("Finance"));
        assertTrue(str.contains("130000"));
        assertTrue(str.contains("0.2"));
    }
}
