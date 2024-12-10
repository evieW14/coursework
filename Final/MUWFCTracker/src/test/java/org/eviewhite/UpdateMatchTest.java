package org.eviewhite;

import org.eviewhite.application.App;
import org.eviewhite.matches.MatchList;
import org.eviewhite.players.SquadList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateMatchTest {
    //Define the file paths for the test files to be used in this test class
    private static final String TEST_FILE_MATCHES = "src/test/resources/testMatches.csv";
    private static final String TEST_FILE_PLAYERS = "src/test/resources/testPlayers.csv";

    //Set up an output stream to capture the outputs.
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    //Standard outputs/inputs which will be returned to after each test to ensure clean slate
    private static final PrintStream standardOut = System.out;
    private static final InputStream standardIn = System.in;

    //Will run before each test to set up the matchList/squadList objects and direct the output to the output stream
    @BeforeEach
    public void setUp() throws IOException {
        App.matchList = new MatchList(TEST_FILE_MATCHES);
        App.squadList = new SquadList(TEST_FILE_PLAYERS);
        System.setOut(new PrintStream(outContent));
    }

    //This is run after each test to reset the files and the outputs/inputs
    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(standardOut);
        System.setIn(standardIn);
        resetFiles();
    }


    //This method handles rewriting the match/player test files to their original state. This is because some tests involve changing these files whereas others need the original state so this prevents any changes being made, affecting other tests.
    void resetFiles() throws IOException {
        PrintWriter writerMatch = new PrintWriter(TEST_FILE_MATCHES);
        writerMatch.print("1,5/11/2024,(H),Test Match United,1-0\n");
        writerMatch.print("2,6/11/2024,(A),Test Match City,0-2\n");
        writerMatch.close();

        PrintWriter writerPlayer = new PrintWriter(TEST_FILE_PLAYERS);
        writerPlayer.print("First Test,Forward,1,1,England,31/10/2024,1,1,1\n");
        writerPlayer.print("Second Test,GK,2,2,England,31/10/2024,2,2,2");
        writerPlayer.close();
    }

    //This method handles directing a set input to the System.setIn so that any scanner-reliant methods can be tested
    void provideInput(String testInputData) {
        ByteArrayInputStream testInputs = new ByteArrayInputStream(testInputData.getBytes());
        System.setIn(testInputs);
    }


    //This test handles updating a matchday score to now be 1-0 and checks this is changed in the matchList/match object
    @Test
    public void testUpdateScore() throws IOException {
        provideInput("1-0");
        UpdateMatch.updateScore(1, TEST_FILE_MATCHES);
        assertEquals("1-0", App.matchList.getMatchList().get(0).getScore());
    }


    //This handles taking in the lineup from the user of the players who appeared in a matchday and checks their appearances have been updated in the player objects
    @Test
    public void testInputLineup() {
        provideInput("First Test,Second Test");
        UpdateMatch.getLineup();
        assertEquals(2, App.squadList.getSquadList().get(0).getApps());
        assertEquals(3, App.squadList.getSquadList().get(1).getApps());
    }


    //this method tests getting the goals scored in a match at home (i.e. leg = (H)).
    //Should return the integer to the left of the hyphen in the score attribute of a match object.

    @Test
    public void testGetGoalScoredHomeMatch() {
        UpdateMatch.getGoalsScored(1);
        int homeGameScore = UpdateMatch.getterForGoalsScored();
        assertEquals(1, homeGameScore);
    }

    //this method tests getting the goals scored in a match that was away (i.e. leg = (A)).
    //Should return the integer to the right of the hyphen in the score attribute of a match object.
    @Test
    public void testGoalsScoredAwayMatch() {
        UpdateMatch.getGoalsScored(2);
        int awayGameScore = UpdateMatch.getterForGoalsScored();
        assertEquals(2, awayGameScore);
    }

    //This test checks that when the user enters a goalscorer, that player's goals should be incremented
    @Test
    public void testGetGoalScorers() {
        provideInput("First Test");
        UpdateMatch.getGoalScorers(1);
        assertEquals(2, App.squadList.getSquadList().get(0).getGoals());
    }

    //This test checks that when a user enters a player, who got an assist in that game, that player's assist should be incremented
    @Test
    public void testGetAssists() throws IOException {
        provideInput("First Test");
        UpdateMatch.getGoalsScored(1);
        UpdateMatch.getAssists(TEST_FILE_PLAYERS);
        assertEquals(2, App.squadList.getSquadList().get(0).getAssists());
    }
}