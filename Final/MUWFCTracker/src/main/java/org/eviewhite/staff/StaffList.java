package org.eviewhite.staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffList {
    public List<Staff> staffList;

    public StaffList(String filepath) throws IOException {
        staffList = new ArrayList<>();
        // Loop through lines of file
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String fileLine;
        while ((fileLine = br.readLine()) != null) {

            // Split line up
            String[] attributes = fileLine.split(",");

            // Set Name
            String name = attributes[0];

            // Set age
            int age = Integer.parseInt(attributes[1]);

            // Set nationality
            String nation = attributes[2];

            // Set date joined
            String joined = attributes[3];

            // Set jobRole
            String jobRole = attributes[4];

            // Set Trophies
            int trophy = Integer.parseInt(attributes[5]);

            // Instantiate player object (pass through variables)
            // add to array
            Staff staff = new Staff(name, age, nation, joined, jobRole, trophy);
            staffList.add(staff);
        }
        br.close();
    }

    //Getter to return ArrayList of staff objects
    public List<Staff> getStaffList() {
        return staffList;
    }
}