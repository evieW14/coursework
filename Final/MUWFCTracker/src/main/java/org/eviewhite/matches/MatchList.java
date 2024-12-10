package org.eviewhite.matches;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchList {
    //Initialise ArrayList of Match objects
    public static List<Match> matchList;

    public MatchList(String matchFilePath) throws IOException {
        matchList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(matchFilePath));
        String line;
        while ((line = br.readLine()) != null) {
            // Split line up
            String[] attributes = line.split(",");

            // Set Matchday
            int md = Integer.parseInt(attributes[0]);

            // Set Date
            String date = attributes[1];

            // Set leg
            String homeOrAway = attributes[2];

            // Set Opponent
            String oppTeam = attributes[3];

            // Set score
            String matchScore = attributes[4];

            // Instantiate match object (pass through variables)
            // add to array
            Match match = new Match(md, date, homeOrAway, oppTeam, matchScore);
            matchList.add(match);
        }
        br.close();
    }

    //Getter to return list of match objects
    public List<Match> getMatchList() {
        return matchList;
    }


    //Find match in list
    public boolean getMatchDetails(int matchDay) {
        boolean matchFound = false;

        //search through each object in the list
        for (Match m : matchList) {
            //if match is found
            if (m.getMatchDay() == matchDay) {
                //sets matchFound as true
                matchFound = true;
                break;
            }
        }
        //Return if that matchday was found.
        return matchFound;
    }
}