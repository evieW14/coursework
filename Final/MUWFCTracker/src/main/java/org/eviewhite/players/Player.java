package org.eviewhite.players;

import org.eviewhite.Person;

//Player class, which inherits from Person class
public class Player extends Person {
    //new attributes for each player
    private final String position;
    private final int number;
    private int appearances;
    private int goals;
    private int assists;

    //Player constructor
    public Player(String name, String pos, int age, int num, String nation, String dateJoined, int apps, int gls, int ast) {
        //Set super class attributes
        super(name, age, nation, dateJoined);
        //set new player attributes
        this.position = pos;
        this.number = num;
        this.appearances = apps;
        this.goals = gls;
        this.assists = ast;
    }

    //Getter for player's position
    public String getPosition() {
        return position;
    }

    //Getter for player's number
    public int getNumber() {
        return number;
    }

    //Getter for player's appearances
    public int getApps() {
        return appearances;
    }

    //Setter for player's appearances
    public void setApps(int apps) {
        this.appearances = apps;
    }

    //Getter for player's goals
    public int getGoals() {
        return goals;
    }

    //Setter for player's goals
    public void setGoals(int gls) {
        this.goals = gls;
    }

    //Getter for player's assists
    public int getAssists() {
        return assists;
    }

    //Setter for player's assists
    public void setAssists(int ast) {
        this.assists = ast;
    }

    //Player string output method
    public String toString() {
        return ("Player: " + super.getName() + " (" + position + ") (" + super.getAge() + ") (#" + number + ")");
    }

    //Method to build string for player's details
    public String playerDetailsToString() {
        return ("Nation: " + super.getNationality() + "\nDate Joined: " + super.getDateJoined() + "\nAppearances: " + appearances + "\nGoals: " + goals + "\nAssists: " + assists);
    }

    //Method to build string to write player attributes to file
    public String playerWrite() {
        return (super.getName() + "," + position + "," + super.getAge() + "," + number + "," + super.getNationality() + "," + super.getDateJoined() + ","
                + appearances + "," + goals + "," + assists);
    }
}