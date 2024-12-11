package org.eviewhite.matches;

//Class for matches
public class Match {
    private final int matchDay;
    private final String matchDate;
    private final String leg;
    private final String opponent;
    private String score;

    //Public constructor for each matchday
    public Match(int mDay, String date, String hOrA, String opps, String results) {
        this.matchDay = mDay;
        this.matchDate = date;
        this.leg = hOrA;
        this.opponent = opps;
        this.score = results;
    }

    //Output format for Matches
    public String matchToString() {
        return ("Match " + matchDay + ":  " + " " + matchDate + " " + leg + " " + opponent + " " + score);
    }

    //Getter for matchday
    public int getMatchDay() {
        return this.matchDay;
    }

    //Getter for matchDate
    public String getMatchDate() {
        return this.matchDate;
    }

    //Getter for Opponent
    public String getOpponent() {
        return this.opponent;
    }

    //Getter for match leg
    public String getLeg() {
        return this.leg;
    }

    //Setter to update score
    public void setScore(String inputScore) {
        this.score = inputScore;
    }

    //Getter for match score
    public String getScore() {
        return this.score;
    }

    //Format for writing the match to file (CSV)
    public String matchFileString() {
        return (matchDay + "," + matchDate + "," + leg + "," + opponent + "," + score);
    }
}
