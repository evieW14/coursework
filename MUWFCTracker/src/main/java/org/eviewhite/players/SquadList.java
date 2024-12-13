package org.eviewhite.players;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SquadList {
    private List<Player> squadList = new ArrayList<>();

    public SquadList(String filepath) throws IOException {
        // Loop through lines of file
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String fileLine;
        while ((fileLine = br.readLine()) != null) {

            // Split line up
            String[] attributes = fileLine.split(",");
            // Set Name
            String name = attributes[0];

            // Set position
            String pos = attributes[1];

            //Set age
            int age = Integer.parseInt(attributes[2]);

            // Set number
            int num = Integer.parseInt(attributes[3]);

            // Set nationality
            String nation = attributes[4];

            // Set date joined
            String joined = attributes[5];

            // Set aps
            int apps = Integer.parseInt(attributes[6]);

            // Set goals
            int gls = Integer.parseInt(attributes[7]);

            // Set assists
            int ast = Integer.parseInt(attributes[8]);

            // Instantiate player object (pass through variables)
            // add to array
            Player player = new Player(name, pos, age, num, nation, joined, apps, gls, ast);
            squadList.add(player);
        }
        br.close();
    }

    public List<Player> getSquadList() {
        return squadList;
    }


    //Take in the player name entered by the user as a parameter
    public void getPlayerDetails(String playerChoice) {
        //Boolean to identify if player is found
        boolean playerFound = false;
        //Loop through each player in the squad list
        for (Player p : squadList) {
            //Get the name of each player object and check if it contains the input from the user
            if (p.getName().contains(playerChoice)) {
                //If so, call the playerDetails method and output the details to the user.
                System.out.println(p.getName());
                String details = p.playerDetailsToString();
                System.out.println(details);
                //Player is found
                playerFound = true;
            }
        }
        //If playerFound is still false (i.e. the name entered was not in the list) the user will be told the player was not found
        if (!playerFound) {
            System.out.println("Player not found");
        }
    }
}
