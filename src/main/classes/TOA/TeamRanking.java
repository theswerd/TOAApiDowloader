package main.classes.TOA;

import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class TeamRanking {
    private Object TeamRankId;
    private Object EventID;
    private Object TeamID;
    private Object Rank;
    private Object RankChange;
    private Object Wins;
    private Object Losses;
    private Object Ties;
    private Object QualifyingPoints;
    private Object RankingPoints;
    private Object HighestQualScore;
    private Object MatchesPlayed;
    private Object Disqualified;

    public TeamRanking() {
        this.TeamRankId = "";
        this.EventID = "";
        this.TeamID = "";
        this.Rank = "";
        this.RankChange = "";
        this.Wins = "";
        this.Losses = "";
        this.Ties = "";
        this.QualifyingPoints = "";
        this.RankingPoints = "";
        this.HighestQualScore = "";
        this.MatchesPlayed = "";
        this.Disqualified = "";
    }

    public TeamRanking(Object TeamRankId, Object EventID, Object TeamID, Object Rank, Object RankChange, Object Wins, Object Losses, Object Ties, Object QualifyingPoints, Object RankingPoints, Object HighestQualScore, Object MatchesPlayed, Object Disqualified){
        this.TeamRankId = TeamRankId;
        this.EventID = EventID;
        this.TeamID = TeamID;
        this.Rank = Rank;
        this.RankChange = RankChange;
        this.Wins = Wins;
        this.Losses = Losses;
        this.Ties = Ties;
        this.QualifyingPoints = QualifyingPoints;
        this.RankingPoints = RankingPoints;
        this.HighestQualScore = HighestQualScore;
        this.MatchesPlayed = MatchesPlayed;
        this.Disqualified = Disqualified;
    }

    public TeamRanking(JSONObject json) {
        this.TeamRankId = json.get("TeamRankID");
        this.EventID = json.get("EventID");
        this.TeamID = json.get("TeamID");
        this.Rank = json.get("Rank");
        this.RankChange = json.get("RankChange");
        this.Wins = json.get("Wins");
        this.Losses = json.get("Losses");
        this.Ties = json.get("Ties");
        this.QualifyingPoints = json.get("QualifyingPoints");
        this.RankingPoints = json.get("RankingPoints");
        this.HighestQualScore = json.get("HighestQualScore");
        this.MatchesPlayed = json.get("MatchesPlayed");
        this.Disqualified = json.get("Disqualified");
    }

    public Object getTeamRankId() {
        return TeamRankId;
    }

    public void setTeamRankId(Object teamRankId) {
        TeamRankId = teamRankId;
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getTeamID() {
        return TeamID;
    }

    public void setTeamID(Object teamID) {
        TeamID = teamID;
    }

    public Object getRank() {
        return Rank;
    }

    public void setRank(Object rank) {
        Rank = rank;
    }

    public Object getRankChange() {
        return RankChange;
    }

    public void setRankChange(Object rankChange) {
        RankChange = rankChange;
    }

    public Object getWins() {
        return Wins;
    }

    public void setWins(Object wins) {
        Wins = wins;
    }

    public Object getLosses() {
        return Losses;
    }

    public void setLosses(Object losses) {
        Losses = losses;
    }

    public Object getTies() {
        return Ties;
    }

    public void setTies(Object ties) {
        Ties = ties;
    }

    public Object getQualifyingPoints() {
        return QualifyingPoints;
    }

    public void setQualifyingPoints(Object qualifyingPoints) {
        QualifyingPoints = qualifyingPoints;
    }

    public Object getRankingPoints() {
        return RankingPoints;
    }

    public void setRankingPoints(Object rankingPoints) {
        RankingPoints = rankingPoints;
    }

    public Object getHighestQualScore() {
        return HighestQualScore;
    }

    public void setHighestQualScore(Object highestQualScore) {
        HighestQualScore = highestQualScore;
    }

    public Object getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(Object matchesPlayed) {
        MatchesPlayed = matchesPlayed;
    }

    public Object getDisqualified() {
        return Disqualified;
    }

    public void setDisqualified(Object disqualified) {
        Disqualified = disqualified;
    }
}