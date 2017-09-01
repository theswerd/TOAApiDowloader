package main.classes;

/**
 * Created by SPZ Productions on 8/19/2017.
 */
public class ScheduleStation {

        private Object MatchId;
    private Object teams;
    private Object stats;
    private Object RedScore;
    private Object BlueScore;
    private Object TournamentLevel;
    private Object MatchName;

    public ScheduleStation(){
        this.MatchId = "";
        this.teams = "";
        this.stats = "";
        this.RedScore = "";
        this.BlueScore = "";
        this.TournamentLevel = "";
        this.MatchName = "";
    }

    public ScheduleStation(Object RedScore, Object MatchId, Object Red1, Object Red1Stat, Object BlueScore, Object TournamentLevel, Object MatchName){
        this.MatchId = MatchId;
        this.teams = Red1;
        this.stats = Red1Stat;
        this.RedScore = RedScore;
        this.BlueScore = BlueScore;
        this.TournamentLevel = TournamentLevel;
        this.MatchName = MatchName;
    }

    public ScheduleStation(JSONObject json){
        this.MatchId = json.get("match_key");
        this.teams = json.get("teams");
        this.stats = json.get("station_status");
        this.RedScore = json.get("red_score");
        this.BlueScore = json.get("blue_score");
        this.TournamentLevel = json.get("tournament_level");
        this.MatchName = json.get("match_name");
    }

    public Object getStats() {
        return stats;
    }

    public void setStats(Object stats) {
        this.stats = stats;
    }

    public Object getRedScore() {
        return RedScore;
    }

    public void setRedScore(Object redScore) {
        RedScore = redScore;
    }

    public Object getMatchId() {
        return MatchId;
    }

    public void setMatchId(Object matchId) {
        MatchId = matchId;
    }

    public Object getTeams() {
        return teams;
    }

    public void setTeams(Object teams) {
        this.teams = teams;
    }

    public Object getBlueScore() {
        return BlueScore;
    }

    public void setBlueScore(Object blueScore) {
        BlueScore = blueScore;
    }

    public Object getTournamentLevel() {
        return TournamentLevel;
    }

    public void setTournamentLevel(Object tournamentLevel) {
        TournamentLevel = tournamentLevel;
    }

    public Object getMatchName() {
        return MatchName;
    }

    public void setMatchName(Object matchName) {
        MatchName = matchName;
    }

}