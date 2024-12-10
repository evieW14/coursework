package org.eviewhite.staff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StaffListTest {
    //StaffList object setup
    private static StaffList testStaffList;

    //Initialise staffList object before each test so a new object is used each time to prevent any changes affecting subsequent tests
    @BeforeEach
    public void setUpTests() throws IOException{
        //Set up string to store the file path of the testStaff.csv file which will be used to test the methods against. This is so the real files are not affecting by testing
        String TEST_FILE_STAFF = "src/test/resources/testStaff.csv";
        testStaffList = new StaffList(TEST_FILE_STAFF);
    }

    //Test the constructor of staffList to ensure the file is read properly, the staff objects are made and added to the list, and all the attributes are assigned correctly.
    @Test
    public void testStaffListConstructor(){

        assertNotNull(testStaffList.getStaffList());
        assertEquals(2, testStaffList.getStaffList().size());

        //Check First Test in file
        Staff staff1 = testStaffList.getStaffList().get(0);
        assertNotNull(staff1);
        assertEquals("First Test Staff", staff1.getName());
        assertEquals(21, staff1.getAge());
        assertEquals("Manager", staff1.getJobRole());
        assertEquals("England", staff1.getNationality());
        assertEquals("19/11/2024", staff1.getDateJoined());
        assertEquals(1, staff1.getTrophies());


        //Check Second Test in file
        Staff staff2 = testStaffList.getStaffList().get(1);
        assertNotNull(staff2);
        assertEquals("Second Test Staff", staff2.getName());
        assertEquals(22, staff2.getAge());
        assertEquals("Assistant Coach", staff2.getJobRole());
        assertEquals("England", staff2.getNationality());
        assertEquals("19/11/2024", staff2.getDateJoined());
        assertEquals(2, staff2.getTrophies());
    }

    //Test the toString method so that it returns in the correct format with the correct data from the correct object
    @Test
    public void testToString(){
        String expected = "Staff: First Test Staff (Manager) (21) (Trophies: 1)";
        assertEquals(expected, testStaffList.getStaffList().get(0).toString());
    }
}
