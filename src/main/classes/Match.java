package main.classes;

import org.json.simple.JSONObject;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/12/2017.
 */
public class Match {

    private String MatchID;
    private String EventID;
    private String TournamentLevel;
    private String ScheduleTime;
    private String MatchName;
    private String PlayNumber;
    private String FieldNumber;
    private String PreStartInitialTime;
    private String PreStartFinalTime;
    private String PreStartCount;
    private String AutoStartTime;
    private String AutoEndTime;
    private String TeleopStartTime;
    private String TeleopEndTime;
    private String RefCommitTime;
    private String ScoreKeeperCommitTime;
    private String ScorePostTime;
    private String CancelMatchTime;
    private String CycleTime;
    private String RedScore;
    private String BlueScore;
    private String RedPenalty;
    private String BluePenalty;
    private String RedAutoScore;
    private String BlueAutoScore;
    private String RedTeleScore;
    private String BlueTeleScore;
    private String RedEndScore;
    private String BlueEndScore;
    private String HeadRefReview;
    private String VideoURL;

    public Match(){
        this.MatchID = "";
        this.EventID = "";
        this.TournamentLevel = "";
        this.ScheduleTime = "";
        this.MatchName = "";
        this.PlayNumber = "";
        this.FieldNumber = "";
        this.PreStartInitialTime = "";
        this.PreStartFinalTime = "";
        this.PreStartCount = "";
        this.AutoStartTime = "";
        this.AutoEndTime = "";
        this.TeleopStartTime = "";
        this.TeleopEndTime = "";
        this.RefCommitTime = "";
        this.ScoreKeeperCommitTime = "";
        this.ScorePostTime = "";
        this.CancelMatchTime = "";
        this.CycleTime = "";
        this.RedScore = "";
        this.BlueScore = "";
        this.RedPenalty = "";
        this.BluePenalty = "";
        this.RedAutoScore = "";
        this.BlueAutoScore = "";
        this.RedTeleScore = "";
        this.BlueTeleScore = "";
        this.RedEndScore = "";
        this.BlueEndScore = "";
        this.HeadRefReview = "";
        this.VideoURL = "";
    }

    public Match(ResultSet rs) throws SQLException {
        this.MatchID = rs.getString("MatchID");
        this.EventID = rs.getString("EventID");
        this.TournamentLevel = rs.getString("TournamentLevel");
        this.ScheduleTime = rs.getString("ScheduleTime");
        this.MatchName = rs.getString("MatchName");
        this.PlayNumber = rs.getString("PlayNumber");
        this.FieldNumber = rs.getString("FieldNumber");
        this.PreStartInitialTime = rs.getString("PreStartInitialTime");
        this.PreStartFinalTime = rs.getString("PreStartFinalTime");
        this.PreStartCount = rs.getString("PreStartCount");
        this.AutoStartTime = rs.getString("AutoStartTime");
        this.AutoEndTime = rs.getString("AutoEndTime");
        this.TeleopStartTime = rs.getString("TeleopStartTime");
        this.TeleopEndTime = rs.getString("TeleopEndTime");
        this.RefCommitTime = rs.getString("RefCommitTime");
        this.ScoreKeeperCommitTime = rs.getString("ScoreKeeperCommitTime");
        this.ScorePostTime = rs.getString("ScorePostTime");
        this.CancelMatchTime = rs.getString("CancelMatchTime");
        this.CycleTime = rs.getString("CycleTime");
        this.RedScore = rs.getString("RedScore");
        this.BlueScore = rs.getString("BlueScore");
        this.RedPenalty = rs.getString("RedPenalty");
        this.BluePenalty = rs.getString("BluePenalty");
        this.RedAutoScore = rs.getString("RedAutoScore");
        this.BlueAutoScore = rs.getString("BlueAutoScore");
        this.RedTeleScore = rs.getString("RedTeleScore");
        this.BlueTeleScore = rs.getString("BlueTeleScore");
        this.RedEndScore = rs.getString("RedEndScore");
        this.BlueEndScore = rs.getString("BlueEndScore");
        this.HeadRefReview = rs.getString("HeadRefReview");
        this.VideoURL = rs.getString("VideoURL");
    }

    public Match(String MatchID, String EventID, String TournamentLevel, String ScheduleTime, String MatchName, String PlayNumber,
                 String FieldNumber, String PreStartInitialTime, String PreStartFinalTime, String PreStartCount, String AutoStartTime,
                 String AutoEndTime, String TeleopStartTime, String TeleopEndTime, String RefCommitTime, String ScoreKeeperCommitTime, String ScorePostTime,
                 String CancelMatchTime, String CycleTime, String RedScore, String BlueScore, String RedPenalty, String BluePenalty,
                 String RedAutoScore, String BlueAutoScore, String RedTeleScore, String BlueTeleScore, String RedEndScore,
                 String BlueEndScore, String HeadRefReview, String VideoURL, String CreatedBy, String CreatedOn, String ModifiedBy, String ModifiedOn,
                 ScheduleStation red1, ScheduleStation red2,ScheduleStation red3,ScheduleStation blue1,ScheduleStation blue2,ScheduleStation blue3){
        this.MatchID = MatchID;
        this.EventID = EventID;
        this.TournamentLevel = TournamentLevel;
        this.ScheduleTime = ScheduleTime;
        this.MatchName = MatchName;
        this.PlayNumber = PlayNumber;
        this.FieldNumber = FieldNumber;
        this.PreStartInitialTime = PreStartInitialTime;
        this.PreStartFinalTime = PreStartFinalTime;
        this.PreStartCount = PreStartCount;
        this.AutoStartTime = AutoStartTime;
        this.AutoEndTime = AutoEndTime;
        this.TeleopStartTime = TeleopStartTime;
        this.TeleopEndTime = TeleopEndTime;
        this.RefCommitTime = RefCommitTime;
        this.ScoreKeeperCommitTime = ScoreKeeperCommitTime;
        this.ScorePostTime = ScorePostTime;
        this.CancelMatchTime = CancelMatchTime;
        this.CycleTime = CycleTime;
        this.RedScore = RedScore;
        this.BlueScore = BlueScore;
        this.RedPenalty = RedPenalty;
        this.BluePenalty = BluePenalty;
        this.RedAutoScore = RedAutoScore;
        this.BlueAutoScore = BlueAutoScore;
        this.RedTeleScore = RedTeleScore;
        this.BlueTeleScore = BlueTeleScore;
        this.RedEndScore = RedEndScore;
        this.BlueEndScore = BlueEndScore;
        this.HeadRefReview = HeadRefReview;
        this.VideoURL = VideoURL;
    }

    public Match(JSONObject json){
        this.MatchID = json.get("MatchID").toString();
        this.EventID = json.get("EventID").toString();
        this.TournamentLevel = json.get("TournamentLevel").toString();
        this.ScheduleTime = json.get("ScheduleTime").toString();
        this.MatchName = json.get("MatchName").toString();
        this.PlayNumber = json.get("PlayNumber").toString();
        this.FieldNumber = json.get("FieldNumber").toString();
        this.PreStartInitialTime = json.get("PreStartInitialTime").toString();
        this.PreStartFinalTime = json.get("PreStartFinalTime").toString();
        this.PreStartCount = json.get("PreStartCount").toString();
        this.AutoStartTime = json.get("AutoStartTime").toString();
        this.AutoEndTime = json.get("AutoEndTime").toString();
        this.TeleopStartTime = json.get("TeleopStartTime").toString();
        this.TeleopEndTime = json.get("TeleopEndTime").toString();
        this.RefCommitTime = json.get("RefCommitTime").toString();
        this.ScoreKeeperCommitTime = json.get("ScoreKeeperCommitTime").toString();
        this.ScorePostTime = json.get("ScorePostTime").toString();
        this.CancelMatchTime = json.get("CancelMatchTime").toString();
        this.CycleTime = json.get("CycleTime").toString();
        this.RedScore = json.get("RedScore").toString();
        this.BlueScore = json.get("BlueScore").toString();
        this.RedPenalty = json.get("RedPenalty").toString();
        this.BluePenalty = json.get("BluePenalty").toString();
        this.RedAutoScore = json.get("RedAutoScore").toString();
        this.BlueAutoScore = json.get("BlueAutoScore").toString();
        this.RedTeleScore = json.get("RedTeleScore").toString();
        this.BlueTeleScore = json.get("BlueTeleScore").toString();
        this.RedEndScore = json.get("RedEndScore").toString();
        this.BlueEndScore = json.get("BlueEndScore").toString();
        this.HeadRefReview = json.get("HeadRefReview").toString();
        this.VideoURL = json.get("VideoURL").toString();
    }

    public String getTeleopStartTime() {
        return TeleopStartTime;
    }

    public void setTeleopStartTime(String teleopStartTime) {
        TeleopStartTime = teleopStartTime;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String matchID) {
        MatchID = matchID;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getTournamentLevel() {
        return TournamentLevel;
    }

    public void setTournamentLevel(String tournamentLevel) {
        TournamentLevel = tournamentLevel;
    }

    public String getScheduleTime() {
        return ScheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        ScheduleTime = scheduleTime;
    }

    public String getMatchName() {
        return MatchName;
    }

    public void setMatchName(String matchName) {
        MatchName = matchName;
    }

    public String getPlayNumber() {
        return PlayNumber;
    }

    public void setPlayNumber(String playNumber) {
        PlayNumber = playNumber;
    }

    public String getFieldNumber() {
        return FieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        FieldNumber = fieldNumber;
    }

    public String getPreStartInitialTime() {
        return PreStartInitialTime;
    }

    public void setPreStartInitialTime(String preStartInitialTime) {
        PreStartInitialTime = preStartInitialTime;
    }

    public String getPreStartFinalTime() {
        return PreStartFinalTime;
    }

    public void setPreStartFinalTime(String preStartFinalTime) {
        PreStartFinalTime = preStartFinalTime;
    }

    public String getPreStartCount() {
        return PreStartCount;
    }

    public void setPreStartCount(String preStartCount) {
        PreStartCount = preStartCount;
    }

    public String getAutoStartTime() {
        return AutoStartTime;
    }

    public void setAutoStartTime(String autoStartTime) {
        AutoStartTime = autoStartTime;
    }

    public String getAutoEndTime() {
        return AutoEndTime;
    }

    public void setAutoEndTime(String autoEndTime) {
        AutoEndTime = autoEndTime;
    }

    public String getTeleopEndTime() {
        return TeleopEndTime;
    }

    public void setTeleopEndTime(String teleopEndTime) {
        TeleopEndTime = teleopEndTime;
    }

    public String getRefCommitTime() {
        return RefCommitTime;
    }

    public void setRefCommitTime(String refCommitTime) {
        RefCommitTime = refCommitTime;
    }

    public String getScoreKeeperCommitTime() {
        return ScoreKeeperCommitTime;
    }

    public void setScoreKeeperCommitTime(String scoreKeeperCommitTime) {
        ScoreKeeperCommitTime = scoreKeeperCommitTime;
    }

    public String getScorePostTime() {
        return ScorePostTime;
    }

    public void setScorePostTime(String scorePostTime) {
        ScorePostTime = scorePostTime;
    }

    public String getCancelMatchTime() {
        return CancelMatchTime;
    }

    public void setCancelMatchTime(String cancelMatchTime) {
        CancelMatchTime = cancelMatchTime;
    }

    public String getCycleTime() {
        return CycleTime;
    }

    public void setCycleTime(String cycleTime) {
        CycleTime = cycleTime;
    }

    public String getRedScore() {
        return RedScore;
    }

    public void setRedScore(String redScore) {
        RedScore = redScore;
    }

    public String getBlueScore() {
        return BlueScore;
    }

    public void setBlueScore(String blueScore) {
        BlueScore = blueScore;
    }

    public String getRedPenalty() {
        return RedPenalty;
    }

    public void setRedPenalty(String redPenalty) {
        RedPenalty = redPenalty;
    }

    public String getBluePenalty() {
        return BluePenalty;
    }

    public void setBluePenalty(String bluePenalty) {
        BluePenalty = bluePenalty;
    }

    public String getRedAutoScore() {
        return RedAutoScore;
    }

    public void setRedAutoScore(String redAutoScore) {
        RedAutoScore = redAutoScore;
    }

    public String getBlueAutoScore() {
        return BlueAutoScore;
    }

    public void setBlueAutoScore(String blueAutoScore) {
        BlueAutoScore = blueAutoScore;
    }

    public String getRedTeleScore() {
        return RedTeleScore;
    }

    public void setRedTeleScore(String redTeleScore) {
        RedTeleScore = redTeleScore;
    }

    public String getBlueTeleScore() {
        return BlueTeleScore;
    }

    public void setBlueTeleScore(String blueTeleScore) {
        BlueTeleScore = blueTeleScore;
    }

    public String getRedEndScore() {
        return RedEndScore;
    }

    public void setRedEndScore(String redEndScore) {
        RedEndScore = redEndScore;
    }

    public String getBlueEndScore() {
        return BlueEndScore;
    }

    public void setBlueEndScore(String blueEndScore) {
        BlueEndScore = blueEndScore;
    }

    public String getHeadRefReview() {
        return HeadRefReview;
    }

    public void setHeadRefReview(String headRefReview) {
        HeadRefReview = headRefReview;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }
}