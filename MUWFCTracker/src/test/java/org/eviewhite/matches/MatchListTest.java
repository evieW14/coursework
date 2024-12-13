package org.eviewhite.matches;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MatchListTest {

    //Sets up the standard output that is returned to after each test
    private final PrintStream standardOut = System.out;

    //Sets up string to hold the file path for the testMatches file to be used in this test class
    private static final String TEST_FILE_MATCHES = "src/test/resources/testMatches.csv";

    //Set up output stream to capture outputs from the program when the tests are run (i.e. data outputted via System.out.println())
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    //Set up MatchList object
    private static MatchList testMatchList;

    //this is run before each test and sets the System output to point to the outContent output stream. Also creates a new instance of the matchList so that a fresh instance is used in each test (so that any changes made during testing does not affect the next test)
    @BeforeEach
    public void setUp() throws IOException {
        testMatchList = new MatchList(TEST_FILE_MATCHES);
        System.setOut(new PrintStream(outContent));
    }

    //This is run after each test to return to the standard output, so no state is held after tests
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    //This tests the SquadList constructor and ensures that all the data from the files is inputted to the match objects and is in the correct attribute (matches what is expected)
    @Test
    void testSquadListConstructor() {

        assertNotNull(testMatchList);
        assertEquals(2, testMatchList.getMatchList().size());

        //Check First Test in file
        Match match1 = testMatchList.getMatchList().get(0);
        assertNotNull(match1);
        assertEquals(1, match1.getMatchDay());
        assertEquals("5/11/2024", match1.getMatchDate());
        assertEquals("(H)", match1.getLeg());
        assertEquals("Test Match United", match1.getOpponent());
        assertEquals("1-0", match1.getScore());

        //Check Second Test in file
        Match match2 = testMatchList.getMatchList().get(1);
        assertNotNull(match2);
        assertEquals(2, match2.getMatchDay());
        assertEquals("6/11/2024", match2.getMatchDate());
        assertEquals("(A)", match2.getLeg());
        assertEquals("Test Match City", match2.getOpponent());
        assertEquals("0-2", match2.getScore());
    }


    //This tests that if the user enters a matchday outside the range, getMatchDetails will be false (as there is no matchday of this number found in the list)
    @Test
    void testMatchNotFound() {
        int testMatch = 44;
        assertFalse(testMatchList.getMatchDetails(testMatch));
    }

    //This tests that when the user enters a valid matchday, getMatchDetails returns true (the match was found in the list)
    @Test
    void testMatchFound() {
        int testMatch = 1;
        assertTrue(testMatchList.getMatchDetails(testMatch));
    }
}
