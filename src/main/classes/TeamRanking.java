package main.classes;

import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class TeamRanking {
    private String TeamRankId;
    private String EventID;
    private String TeamID;
    private String Rank;
    private String RankChange;
    private String Wins;
    private String Losses;
    private String Ties;
    private String QualifyingPoints;
    private String RankingPoints;
    private String HighestQualScore;
    private String MatchesPlayed;
    private String Disqualified;

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

    public TeamRanking(String TeamRankId, String EventID, String TeamID, String Rank, String RankChange, String Wins, String Losses, String Ties, String QualifyingPoints, String RankingPoints, String HighestQualScore, String MatchesPlayed, String Disqualified){
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

    public TeamRanking(ResultSet rs) throws SQLException {
        this.TeamRankId = rs.getString("TeamRankID");
        this.EventID = rs.getString("EventID");
        this.TeamID = rs.getString("TeamID");
        this.Rank = rs.getString("Rank");
        this.RankChange = rs.getString("RankChange");
        this.Wins = rs.getString("Wins");
        this.Losses = rs.getString("Losses");
        this.Ties = rs.getString("Ties");
        this.QualifyingPoints = rs.getString("QualifyingPoints");
        this.RankingPoints = rs.getString("RankingPoints");
        this.HighestQualScore = rs.getString("HighestQualScore");
        this.MatchesPlayed = rs.getString("MatchesPlayed");
        this.Disqualified = rs.getString("Disqualified");
    }

    public TeamRanking(JSONObject json) {
        this.TeamRankId = json.get("TeamRankID").toString();
        this.EventID = json.get("EventID").toString();
        this.TeamID = json.get("TeamID").toString();
        this.Rank = json.get("Rank").toString();
        this.RankChange = json.get("RankChange").toString();
        this.Wins = json.get("Wins").toString();
        this.Losses = json.get("Losses").toString();
        this.Ties = json.get("Ties").toString();
        this.QualifyingPoints = json.get("QualifyingPoints").toString();
        this.RankingPoints = json.get("RankingPoints").toString();
        this.HighestQualScore = json.get("HighestQualScore").toString();
        this.MatchesPlayed = json.get("MatchesPlayed").toString();
        this.Disqualified = json.get("Disqualified").toString();
    }

    public String getTeamRankId() {
        return TeamRankId;
    }

    public void setTeamRankId(String teamRankId) {
        TeamRankId = teamRankId;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getRankChange() {
        return RankChange;
    }

    public void setRankChange(String rankChange) {
        RankChange = rankChange;
    }

    public String getWins() {
        return Wins;
    }

    public void setWins(String wins) {
        Wins = wins;
    }

    public String getLosses() {
        return Losses;
    }

    public void setLosses(String losses) {
        Losses = losses;
    }

    public String getTies() {
        return Ties;
    }

    public void setTies(String ties) {
        Ties = ties;
    }

    public String getQualifyingPoints() {
        return QualifyingPoints;
    }

    public void setQualifyingPoints(String qualifyingPoints) {
        QualifyingPoints = qualifyingPoints;
    }

    public String getRankingPoints() {
        return RankingPoints;
    }

    public void setRankingPoints(String rankingPoints) {
        RankingPoints = rankingPoints;
    }

    public String getHighestQualScore() {
        return HighestQualScore;
    }

    public void setHighestQualScore(String highestQualScore) {
        HighestQualScore = highestQualScore;
    }

    public String getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(String matchesPlayed) {
        MatchesPlayed = matchesPlayed;
    }

    public String getDisqualified() {
        return Disqualified;
    }

    public void setDisqualified(String disqualified) {
        Disqualified = disqualified;
    }
}