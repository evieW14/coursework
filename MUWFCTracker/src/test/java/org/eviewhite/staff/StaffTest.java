package org.eviewhite.staff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffTest {
    //Set up Staff object to use during this test class
    Staff testStaff = new Staff("Test", 21, "England", "19/11/2024","Manager",4);

    //test the constructor and that all attributes are assigned correctly
    @Test
    public void testConstructor(){
        assertEquals("Test",testStaff.getName());
        assertEquals(21, testStaff.getAge());
        assertEquals("England", testStaff.getNationality());
        assertEquals("19/11/2024", testStaff.getDateJoined());
        assertEquals("Manager", testStaff.getJobRole());
        assertEquals(4, testStaff.getTrophies());
    }


    //test the overridden toString method so that it matches the expected string.
    @Test
    public void testToString(){
        String expected = "Staff: Test (Manager) (21) (Trophies: 4)";
        assertEquals(expected, testStaff.toString());
    }
}
