package org.eviewhite;

//Abstract class for Person
public abstract class Person {
    //Person attributes
    private final String fullName;
    private final int age;
    private final String nation;
    private final String dateJoined;

    //Super class/person constructor
    protected Person(String fullName, int age, String nation, String dateJoined) {
        //set full name, age, nation and dateJoined
        this.fullName = fullName;
        this.age = age;
        this.nation = nation;
        this.dateJoined = dateJoined;
    }

    //Public getters to be used by child-classes
    //Getter for name, Age, Nationality and datejoined
    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nation;
    }

    public String getDateJoined() {
        return dateJoined;
    }
}
