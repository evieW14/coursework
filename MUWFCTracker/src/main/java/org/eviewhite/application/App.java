package org.eviewhite.application;

import org.eviewhite.matches.MatchList;
import org.eviewhite.players.SquadList;
import org.eviewhite.staff.StaffList;

import java.io.IOException;
import java.util.Scanner;

public class App {
    //File paths for the CSV files containing players, matches, and staff data
    public static final String PLAYER_FILE_PATH = "MUWFCTracker/src/main/resources/players.csv";
    public static final String MATCH_FILE_PATH = "MUWFCTracker/src/main/resources/matches.csv";
    public static final String STAFF_FILE_PATH = "MUWFCTracker/src/main/resources/staff.csv";

    //Set up objects for lists of matches, squad and staff
    public static MatchList matchList;
    public static SquadList squadList;
    public static StaffList staffList;

    public static void main(String[] args) throws IOException {

        //Construct objects for the lists of matches, the squad, and staff
        matchList = new MatchList(MATCH_FILE_PATH);
        squadList = new SquadList(PLAYER_FILE_PATH);
        staffList = new StaffList(STAFF_FILE_PATH);
        Scanner myScanner = new Scanner(System.in);
        //User welcome message
        System.out.println("Welcome to the 24-25 Manchester United Women's Season Tracker.");
        //Create menu object and pass in myScanner as a parameter for the menu to use
        Menu trackerMenu = new Menu(myScanner);
        //Call gameMenu method to begin program
        trackerMenu.gameMenu();
    }
}
