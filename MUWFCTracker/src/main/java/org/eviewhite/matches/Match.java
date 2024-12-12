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

    //Method to return the attributes in a format for writing the match to file (CSV)
    public String matchFileString() {
        return (matchDay + "," + matchDate + "," + leg + "," + opponent + "," + score);
    }

    //Getter methods to return matchday, match-date, opponent team, match leg (home or away) and score
    public int getMatchDay() {
        return this.matchDay;
    }

    public String getMatchDate() {
        return this.matchDate;
    }

    public String getOpponent() {
        return this.opponent;
    }

    public String getLeg() {
        return this.leg;
    }

    public String getScore() {
        return this.score;
    }

    //Setter to update score
    public void setScore(String inputScore) {
        this.score = inputScore;
    }
}
