package org.eviewhite.matches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {
    //Instantiate a testMatch object to be tested against in this class
    Match testMatch = new Match(1, "6/11/2024", "(H)", "Test 1", "0-1");


    //This test the constructor by validating that the getters, return the correct values
    @Test
    void testConstructor() {
        assertEquals(1, testMatch.getMatchDay());
        assertEquals("(H)", testMatch.getLeg());
        assertEquals("0-1", testMatch.getScore());
    }


    //This tests the toString method and ensures it matches the expected string
    @Test
    void testToString() {
        String expectedString = "Match 1:   6/11/2024 (H) Test 1 0-1";
        assertEquals(expectedString, testMatch.matchToString());
    }

    //This tests the matchFileToString method and ensures it matches the expected string (the data about the matchday are written in a comma-separated format, ready to be written to the csv file)
    @Test
    void testMatchFileToString() {
        String expectedString = "1,6/11/2024,(H),Test 1,0-1";
        assertEquals(expectedString, testMatch.matchFileString());
    }
}
