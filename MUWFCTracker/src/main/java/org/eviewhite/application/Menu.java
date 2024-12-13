package org.eviewhite.application;

import org.eviewhite.UpdateMatch;

import java.io.IOException;
import java.util.Scanner;


public class Menu {
    private Scanner myScanner;

    //Constructor for Menu
    public Menu(Scanner myScanner) {
        this.myScanner = myScanner;
    }

    //handles printing out the menu options to the user and allows them to select an option (1-5), the action is performed and the user is asked if they would like to continue -
    //if yes, the menu options are printed out again and if no, the game is ended.
    public void gameMenu() throws IOException {
        boolean continueMenu = true;
        //Scanner for user input
        do {
            //main loop for the 5 menu options
            System.out.println("In this programme, you have 5 menu options.");
            System.out.println("1. View Squad + Staff\n2. View Player Details \n3. Match Results \n4. Match Update \n5. Exit");
            int userMenuOption = myScanner.nextInt();
            myScanner.nextLine();

            //Switch statement to read user input (option) and handle menu options
            switch (userMenuOption) {
                case 1: {
                    //View Squad + Staff
                    optViewSquad();
                    break;
                }
                case 2: {
                    //View a selected player's details
                    optViewPlayer();
                    break;
                }
                case 3: {
                    //View all league matches of this season
                    optViewMatches();
                    break;
                }
                case 4: {
                    //Update a matchday scoreline and goals/assists
                    optUpdateMatch();
                    myScanner.nextLine();
                    break;
                }
                case 5: {
                    //Exit the program
                    System.out.println("Program exiting, Goodbye!");
                    myScanner.close();
                    return;
                }
                default: {
                    //Default to remind user to only enter 1-5
                    System.out.println("Please enter a number 1-5.");
                    break;
                }
            }

            //Asks user if they would like to continue after completing menu option task.
            System.out.println("Do you wish to proceed? Y/N");
            String answer = myScanner.nextLine();
            //If no, the menu loop is exited.
            if (answer.equalsIgnoreCase("N")) {
                continueMenu = false;
            }
        } while (continueMenu);

        //Exit statement
        System.out.println("Program exiting, Goodbye!");
        myScanner.close();
    }

    //Handles outputting Squad List and Staff List
    void optViewSquad() {
        System.out.println("1. View Squad + Staff");
        for (int i = 0; i < App.staffList.getStaffList().size(); i++) {
            System.out.println(App.staffList.getStaffList().get(i).toString());
        }

        for (int i = 0; i < App.squadList.getSquadList().size(); i++) {
            System.out.println(App.squadList.getSquadList().get(i).toString());
        }
    }

    //Handles viewing a player's details
    void optViewPlayer() {
        //Reset input
        this.myScanner = new Scanner(System.in);
        System.out.println("2. View Player Details");
        //Gets input of a player's name from the user.
        System.out.println("Enter a Player Name:");
        String userInputPlayer = myScanner.nextLine();
        //will output the chosen player's details
        App.squadList.getPlayerDetails(userInputPlayer);
    }

    //Handles outputting all the match days of the league campaign
    void optViewMatches() {
        System.out.println("3. Match Results");
        for (int i = 0; i < App.matchList.getMatchList().size(); i++) {
            System.out.println(App.matchList.getMatchList().get(i).matchToString());
        }
    }

    //Handles updating match results
    void optUpdateMatch() throws IOException {
        //Reset inputs
        this.myScanner = new Scanner(System.in);

        System.out.println("4. Match Update");
        //Allows user to input the matchday they want to update
        System.out.println("What Matchday do you want to update?");
        int userInputMatchDay = myScanner.nextInt();

        App.matchList.getMatchDetails(userInputMatchDay);
        if (!App.matchList.getMatchDetails(userInputMatchDay)) {
            System.out.println("Matchday not found");
        } else {
            //checks if match is not completed
            if (App.matchList.getMatchList().get(userInputMatchDay - 1).getScore().equals("0")) {
                //Handles updating score
                UpdateMatch.updateScore(userInputMatchDay, App.MATCH_FILE_PATH);
                //Allows user to input the lineup from the matchday and will update appearances
                UpdateMatch.getLineup();
                //gets goals scored and allows user to input the names of the goalscorers.
                UpdateMatch.getGoalScorers(userInputMatchDay);
                //gets goals scored and allows user to input the names of the assists.
                UpdateMatch.getAssists(App.PLAYER_FILE_PATH);
            } else {
                //statement for completed matchday
                System.out.println("Matchday " + userInputMatchDay + " is already complete");
            }
        }
    }
}

