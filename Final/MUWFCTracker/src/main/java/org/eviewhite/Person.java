package org.eviewhite;

//Abstract class for Person
public abstract class Person {
    //Person attributes
    private final String fullName;
    private final int age;
    private final String nation;
    private final String dateJoined;

    //Super class/person constructor
    public Person(String fullName, int age, String nation, String dateJoined) {
        //set fullname, age, nation and dateJoined
        this.fullName = fullName;
        this.age = age;
        this.nation = nation;
        this.dateJoined = dateJoined;
    }

    //Public getters to be used by child-classes
    //Getter for name
    public String getName() {
        return fullName;
    }

    //Getter for Age
    public int getAge() {
        return age;
    }

    //Getter for Nationality
    public String getNationality() {
        return nation;
    }

    //Getter for dateJoined
    public String getDateJoined() {
        return dateJoined;
    }
}
