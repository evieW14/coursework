package org.eviewhite.players;

import org.eviewhite.application.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class SquadListTest {
    //Set up string to hold the file path of the testPlayers.csv file to be used in this test class so that the real files are not affected by tests
    private static final String TEST_FILE_PLAYERS = "src/test/resources/testPlayers.csv";

    //Set up output stream to collect the outputs of the program and its default state
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream standardOut = System.out;


    //before each test, the System.out is directed to the output stream and a squadList object is created and assigned to the one in the App class
    @BeforeEach
    public void setUp() throws IOException {
        System.setOut(new PrintStream(outContent));
        App.squadList = new SquadList(TEST_FILE_PLAYERS);
    }

    //After each test, the standard output is reset to ensure no state is held post-test
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    //This test the squadList constructor in that the data is correctly read from the testPlayers file and objects are made for each player in the file with their attributes assigned to the correct data from the file.
    //The expected values are found from the testPlayers.csv
    @Test
    public void testSquadListConstructor() {
        assertNotNull(App.squadList.getSquadList());

        //Check First Test in file
        Player player1 = App.squadList.getSquadList().get(0);
        assertNotNull(player1);
        assertEquals("First Test", player1.getName());
        assertEquals("Forward", player1.getPosition());
        assertEquals(1, player1.getAge());
        assertEquals(1, player1.getNumber());
        assertEquals("England", player1.getNationality());
        assertEquals("31/10/2024", player1.getDateJoined());
        assertEquals(1, player1.getApps());
        assertEquals(1, player1.getGoals());
        assertEquals(1, player1.getAssists());


        //Check Second Test in file
        Player player2 = App.squadList.getSquadList().get(1);
        assertNotNull(player2);
        assertEquals("Second Test", player2.getName());
        assertEquals("GK", player2.getPosition());
        assertEquals(2, player2.getAge());
        assertEquals(2, player2.getNumber());
        assertEquals("England", player2.getNationality());
        assertEquals("31/10/2024", player2.getDateJoined());
        assertEquals(2, player2.getApps());
        assertEquals(2, player2.getGoals());
        assertEquals(2, player2.getAssists());
    }


    //This checks that when a player requests to see the details of a player, they are outputted in the correct format, and correct details
    @Test
    public void testPlayerDetails(){
        String expectedDetails = "Nation: England\nDate Joined: 31/10/2024\nAppearances: 1\nGoals: 1\nAssists: 1";
        App.squadList.getPlayerDetails("First Test");
        String content = outContent.toString().trim();
        assertTrue(content.contains(expectedDetails));
    }

    //This checks if a user requests to see the details of a player not in the list, they will be told that player was not found.
    @Test
    public void testPlayerDetailsNotFound() {
        App.squadList.getPlayerDetails("Fail");
        assertEquals("Player not found\n", outContent.toString());
    }
}
