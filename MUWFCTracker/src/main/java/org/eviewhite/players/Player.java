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

    //Getter for player's position, number, appearances, goals, assists
    //Also setters for appearances, goals and assists as these can be changed in the program
    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public int getApps() {
        return appearances;
    }

    public void setApps(int apps) {
        this.appearances = apps;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int gls) {
        this.goals = gls;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int ast) {
        this.assists = ast;
    }

    //Override toString method for Player string output
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