package main.classes;

import org.json.simple.JSONObject;

/**
 * Created by SPZ Productions on 8/19/2017.
 */
public class ScheduleStation {

        private String MatchId;
    private String Red1;
    private String Red2;
    private String Red3;
    private String Blue1;
    private String Blue2;
    private String Blue3;
    private String Red1Stat;
    private String Red2Stat;
    private String Red3Stat;
    private String Blue1Stat;
    private String Blue2Stat;
    private String Blue3Stat;
    private String RedScore;
    private String BlueScore;
    private String TournamentLevel;
    private String MatchName;

    public ScheduleStation(){
        this.MatchId = "";
        this.Red1 = "";
        this.Red2 = "";
        this.Red3 = "";
        this.Blue1 = "";
        this.Blue2 = "";
        this.Blue3 = "";
        this.Red1Stat = "";
        this.Red2Stat = "";
        this.Red3Stat = "";
        this.Blue1Stat = "";
        this.Blue2Stat = "";
        this.Blue3Stat = "";
        this.RedScore = "";
        this.BlueScore = "";
        this.TournamentLevel = "";
        this.MatchName = "";
    }

    public ScheduleStation(String RedScore, String MatchId, String Red1, String Red2, String Red3, String Blue1, String Blue2, String Blue3, String Red1Stat, String Red2Stat, String Red3Stat, String Blue1Stat, String Blue2Stat, String Blue3Stat, String BlueScore, String TournamentLevel, String MatchName){
        this.MatchId = MatchId;
        this.Red1 = Red1;
        this.Red2 = Red2;
        this.Red3 = Red3;
        this.Blue1 = Blue1;
        this.Blue2 = Blue2;
        this.Blue3 = Blue3;
        this.Red1Stat = Red1Stat;
        this.Red2Stat = Red2Stat;
        this.Red3Stat = Red3Stat;
        this.Blue1Stat = Blue1Stat;
        this.Blue2Stat = Blue2Stat;
        this.Blue3Stat = Blue3Stat;
        this.RedScore = RedScore;
        this.BlueScore = BlueScore;
        this.TournamentLevel = TournamentLevel;
        this.MatchName = MatchName;
    }

    public ScheduleStation(JSONObject json){
        this.MatchId = json.get("match_key").toString();
        String[] teams = json.get("teams").toString().split(",", -1);
        this.Red1 = teams[0];
        this.Red2 = teams[1];
        this.Red3 = teams[2];
        this.Blue1 = teams[3];
        this.Blue2 = teams[4];
        this.Blue3 = teams[5];
        String[] teamStats = json.get("station_status").toString().split(",", -1);
        this.Red1Stat = teamStats[0];
        this.Red2Stat = teamStats[1];
        this.Red3Stat = teamStats[2];
        this.Blue1Stat = teamStats[3];
        this.Blue2Stat = teamStats[4];
        this.Blue3Stat = teamStats[5];
        this.RedScore = json.get("RedScore").toString();
        this.BlueScore = json.get("BlueScore").toString();
        this.TournamentLevel = json.get("tournament_level").toString();
        this.MatchName = json.get("match_name").toString();
    }

    public String getRedScore() {
        return RedScore;
    }

    public void setRedScore(String redScore) {
        RedScore = redScore;
    }

    public String getMatchId() {
        return MatchId;
    }

    public void setMatchId(String matchId) {
        MatchId = matchId;
    }

    public String getRed1() {
        return Red1;
    }

    public void setRed1(String red1) {
        Red1 = red1;
    }

    public String getBlueScore() {
        return BlueScore;
    }

    public void setBlueScore(String blueScore) {
        BlueScore = blueScore;
    }

    public String getTournamentLevel() {
        return TournamentLevel;
    }

    public void setTournamentLevel(String tournamentLevel) {
        TournamentLevel = tournamentLevel;
    }

    public String getMatchName() {
        return MatchName;
    }

    public void setMatchName(String matchName) {
        MatchName = matchName;
    }
}