package org.eviewhite.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    //Initialises a testPlayer object that will be tested against during this test class
    Player testPlayer = new Player("Test", "GK", 1, 1, "England", "5/11/2024", 1, 0, 0);


    //Tests the playerConstructor in that the getters all return the correct values
    @Test
    public void testConstructor(){
        assertEquals("Test", testPlayer.getName());
        assertEquals("GK", testPlayer.getPosition());
        assertEquals(1, testPlayer.getAge());
        assertEquals(1, testPlayer.getNumber());
        assertEquals("England",testPlayer.getNationality());
        assertEquals("5/11/2024", testPlayer.getDateJoined());
        assertEquals(1, testPlayer.getApps());
        assertEquals(0, testPlayer.getGoals());
        assertEquals(0, testPlayer.getAssists());
    }


    //This tests the toString method in that it returns in the expected format for this testPlayer
    @Test
    public void testToString(){
        String expectedString = "Player: Test (GK) (1) (#1)";
        assertEquals(expectedString, testPlayer.toString());
    }

    //This tests the playerDetailsToString method in that the details about the player are outputted with this data and in this format
    @Test
    public void testPlayerDetailsToString(){
        String expectedString = "Nation: England\nDate Joined: 5/11/2024\nAppearances: 1\nGoals: 0\nAssists: 0";
        assertEquals(expectedString, testPlayer.playerDetailsToString());
    }

    //This test the playerWrite method in that the player data is written in a comma-separated format in this order so that it is ready to be written to the csv file
    @Test
    public void testPlayerWrite(){
        String expectedString = "Test,GK,1,1,England,5/11/2024,1,0,0";
        assertEquals(expectedString, testPlayer.playerWrite());
    }
}
