package org.eviewhite.application;


import java.io.*;
import java.util.Scanner;

import org.eviewhite.matches.MatchList;
import org.eviewhite.players.SquadList;
import org.eviewhite.staff.StaffList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//This test class utilises the JUnit framework to test the Menu class in the main programme.
class MenuTest {
    //Strings to hold the path of the csv files for the test files utilises in the unit tests.
    //This is so that the files utilised in the main programme are not affected by these tests.
    private static final String TEST_FILE_MATCHES = "src/test/resources/testMatches.csv";
    private static final String TEST_FILE_PLAYERS = "src/test/resources/testPlayers.csv";
    private static final String TEST_FILE_STAFF = "src/test/resources/testStaff.csv";

    //Set up output streams to test any System.out.println() calls in the main programme
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    //Set the standard outputs/inputs to be reset to after each test is run
    private final PrintStream standardOut = System.out;
    private static final InputStream standardIn = System.in;

    private Menu menuTest;

    //Handles setting up the objects and byte-streams that will be performed before each test.
    @BeforeEach
    public void setUp() throws IOException {
        //This will also set the testMatchList/SquadList/StaffList objects to the ones in the App class so that they are used throughout the program
        System.setOut(new PrintStream(outContent));

        //Set up MatchList,SquadList and StaffList objects
        App.matchList = new MatchList(TEST_FILE_MATCHES);

        App.squadList = new SquadList(TEST_FILE_PLAYERS);

        App.staffList = new StaffList(TEST_FILE_STAFF);

        //Instantiate a menu object for the test to use, passing in a scanner as a parameter.
        menuTest = new Menu(new Scanner(System.in));
    }

    //will be performed after each test and resets the output stream.
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    //Method to handle providing inputs, take in input as parameter and sets it to the System input.
    void provideInput(String testInputData) {
        ByteArrayInputStream testInputs = new ByteArrayInputStream(testInputData.getBytes());
        System.setIn(testInputs);
    }


    //This tests handles the first option: View Squad
    @Test
    void testOptViewSquad() {
        //Provide input of '1' to select option 1 of the menu
        provideInput("1");
        menuTest.optViewSquad();
        //Check if the view squad output contains an expected value.
        assertTrue(outContent.toString().contains("Player: First Test"));
    }

    //This tests handles the second option: View Player Details
    @Test
    void testOptViewPlayer() {
        //Provide input of the player to view the details of
        provideInput("First Test");
        //Call the viewPlayer method which will handle searching through the squadList for the player and returning their details
        menuTest.optViewPlayer();
        String content = outContent.toString().trim();
        //Check whether the output of the method contains the details of the 'First Test' (expected values found from the testPlayers.csv)
        assertTrue(content.contains("Nation: England"));
        assertTrue(content.contains("Date Joined: 31/10/2024"));
        assertTrue(content.contains("Appearances: 1"));
        assertTrue(content.contains("Goals: 1"));
        assertTrue(content.contains("Assists: 1"));

    }

    //This test handles the third option: View Matches
    @Test
    void testViewMatches() {
        //Call the view matches method to output all the matches in the testMatches.csv
        menuTest.optViewMatches();
        //Strings to store the expected values
        String expectedMatchDay1 = "Match 1:   5/11/2024 (H) Test Match United 1-0";
        String expectedMatchDay2 = "Match 2:   6/11/2024 (A) Test Match City 0";
        String content = outContent.toString().trim();
        assertTrue(content.contains(expectedMatchDay1));
        assertTrue(content.contains(expectedMatchDay2));
    }


    //This test handles the user attempting to update a matchday, that has already had  it's score inputted.
    @Test
    void testUpdateMatchMatchDay1AlreadyComplete() throws IOException {
        provideInput("1");
        menuTest.optUpdateMatch();
        String otherOutputs = "4. Match Update\nWhat Matchday do you want to update?";
        String matchDayComplete = "\nMatchday 1 is already complete";
        assertEquals(otherOutputs + matchDayComplete, outContent.toString().trim());
    }


    //This test handles the user wanting to update a matchday, that is out of bounds of the matches in the file/array
    @Test
    void testUpdateMatchMatchDayNotFound() throws IOException {
        String otherOutputs = "4. Match Update\nWhat Matchday do you want to update?";
        provideInput("14");
        menuTest.optUpdateMatch();
        assertEquals(otherOutputs + "\nMatchday not found", outContent.toString().trim());
    }
}

