package org.eviewhite.staff;

import org.eviewhite.Person;

//Class for staff which inherits from Person
public class Staff extends Person {
    //staff attributes
    private final String jobRole;
    private final int trophies;

    //Staff constructor
    public Staff(String fullName, int age, String nation, String dateJoined, String jobRole, int trophies) {
        //Sets super class attributes
        super(fullName, age, nation, dateJoined);
        //Sets staff attributes
        this.jobRole = jobRole;
        this.trophies = trophies;
    }

    //Getter for staff job role
    public String getJobRole() {
        return jobRole;
    }

    //Getter for staff trophies
    public int getTrophies() {
        return trophies;
    }

    //Override toString Method to build Staff output string
    public String toString() {
        return ("Staff: " + super.getName() + " (" + jobRole + ") (" + super.getAge() + ") (Trophies: " + getTrophies() + ")");
    }
}
