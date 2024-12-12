package org.eviewhite;

import org.eviewhite.application.App;
import org.eviewhite.matches.Match;
import org.eviewhite.players.Player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Update Match class
public final class UpdateMatch {

    private UpdateMatch(){}

    //Set up goalsScored variable
    private static int goalsScored;

    public static int getterForGoalsScored() {
        return goalsScored;
    }

    //Handles updating the matchday score
    public static void updateScore(int matchday, String fileName) throws IOException {
        //Set up Scanner to use
        Scanner myScanner = new Scanner(System.in);

        //Ask and receive input from user of score from the matchday
        System.out.println("Enter Score for Match Day " + matchday);
        String inputScore = myScanner.nextLine();
        //index matchday (list starts at 0)
        matchday -= 1;
        //Find match in match list
        Match m = App.matchList.getMatchList().get(matchday);
        //Call setScore method
        m.setScore(inputScore);

        //Update match object in matchList
        App.matchList.getMatchList().set(matchday, m);
        //Call overWrite file method
        overWriteMatchFile(fileName);
        //Return updated matchday to user
        System.out.println("Updated Matchday: " + m.matchToString());
    }

    //Handles overwriting the matchFile with new matchday data
    static void overWriteMatchFile(String fileName) throws IOException {
        //Calls clearFile
        clearFile(fileName);
        //Initialise file writer
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
        //Loop through list of matches and write to file
        for (Match m : App.matchList.getMatchList()) {
            String matchStringForFile = m.matchFileString();
            fw.write(matchStringForFile);
            fw.newLine();
        }
        //close file writer
        fw.close();
    }

    //Handles clearing file - pass in file as parameter to specify which file is being overwritten
    static void clearFile(String fileName) throws IOException {
        //initialise writer
        PrintWriter writer = new PrintWriter(fileName);
        //replaces lines in file with an empty line
        writer.print("");
        //close writer
        writer.close();
        //File has not been deleted just 'cleared' (by replacing with blank lines) and ready to be rewritten
    }

    //Handles getting the players who made an appearance in the specified matchday
    public static void getLineup() {
        //Set up Scanner
        Scanner myScanner = new Scanner(System.in);

        //Asks user to enter players
        System.out.println("Enter Player Surnames of Lineup/Subs. \nPlease enter comma-separated");
        //get input from user
        String userInputLineup = myScanner.nextLine();
        //Split input by the commas, and store each player as an index in an array
        String[] lineupPlayersArray = userInputLineup.split(",");

        //Loop through lineup array
        for (String surname : lineupPlayersArray) {
            //loop through squad list
            for (Player p : App.squadList.getSquadList()) {
                //find player by checking if surname in player's full name
                if (p.getName().contains(surname)) {
                    //set appearances + 1
                    p.setApps(p.getApps() + 1);
                }
            }
        }
    }

    //Handles getting how many goals were scored in the matchday
    public static void getGoalsScored(int md) {
        //Get matchday score
        String score = App.matchList.getMatchList().get(md - 1).getScore();

        //identify whether MUWFC where home or away
        if (App.matchList.getMatchList().get(md - 1).getLeg().equals("(H)")) {
            //get first part of scoreline as home game
            goalsScored = Integer.parseInt(score.substring(0, 1));
        } else {
            //gets second part of scoreline as away game
            goalsScored = Integer.parseInt(score.substring(2));
        }
    }

    //Handles getting goalscorers
    public static void getGoalScorers(int md) {
        //Set up Scanner for method to use
        Scanner myScanner = new Scanner(System.in);

        //call getGoalsScored to find out how many goals were scored
        getGoalsScored(md);
        //for each goal scored
        for (int i = 1; i < goalsScored + 1; i++) {
            //ask user to input goalscorer
            System.out.println("Enter GoalScorer " + i + ":");
            //Receive input
            String goalScorer = myScanner.nextLine();
            //loop through squad list
            for (Player p : App.squadList.getSquadList()) {
                //find goalscorer object by their name
                if (p.getName().contains(goalScorer)) {
                    //set goals + 1
                    p.setGoals(p.getGoals() + 1);
                }
            }
        }
    }

    //Handles getting players who provided assists
    public static void getAssists(String fileName) throws IOException {
        //Set up Scanner for methods to use
        Scanner myScanner = new Scanner(System.in);

        //for each goal scored
        for (int i = 1; i < goalsScored + 1; i++) {
            //ask user to enter which player provided the assist
            System.out.println("Enter Assister " + i + ":");
            //Receive input
            String assister = myScanner.nextLine();
            //loop through squad list
            for (Player p : App.squadList.getSquadList()) {
                //find player object by using full name
                if (p.getName().contains(assister)) {
                    //set players assists + 1
                    p.setAssists(p.getAssists() + 1);
                }
            }
        }
        //Call overwrite file method to store new data in file
        overWritePlayerFile(fileName);
    }

    //handles overwriting player file
    static void overWritePlayerFile(String fileName) throws IOException {
        //call clear file with player file as parameter
        clearFile(fileName);
        //initialise file writer
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
        //for each player in the squad list
        for (Player p : App.squadList.getSquadList()) {
            //write the player object as a string (in format  defined in playerWrite() method)
            fw.write(p.playerWrite());
            //move onto new line after each player
            fw.newLine();
        }
        //close writer
        fw.close();
    }
}