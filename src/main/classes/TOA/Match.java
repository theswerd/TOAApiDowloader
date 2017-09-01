package main.classes.TOA;

import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/12/2017.
 */
public class Match {

    private Object MatchID;
    private Object EventID;
    private Object TournamentLevel;
    private Object ScheduleTime;
    private Object MatchName;
    private Object PlayNumber;
    private Object FieldNumber;
    private Object PreStartInitialTime;
    private Object PreStartFinalTime;
    private Object PreStartCount;
    private Object AutoStartTime;
    private Object AutoEndTime;
    private Object TeleopStartTime;
    private Object TeleopEndTime;
    private Object RefCommitTime;
    private Object ScoreKeeperCommitTime;
    private Object ScorePostTime;
    private Object CancelMatchTime;
    private Object CycleTime;
    private Object RedScore;
    private Object BlueScore;
    private Object RedPenalty;
    private Object BluePenalty;
    private Object RedAutoScore;
    private Object BlueAutoScore;
    private Object RedTeleScore;
    private Object BlueTeleScore;
    private Object RedEndScore;
    private Object BlueEndScore;
    private Object HeadRefReview;
    private Object VideoURL;

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

    public Match(Object MatchID, Object EventID, Object TournamentLevel, Object ScheduleTime, Object MatchName, Object PlayNumber,
                 Object FieldNumber, Object PreStartInitialTime, Object PreStartFinalTime, Object PreStartCount, Object AutoStartTime,
                 Object AutoEndTime, Object TeleopStartTime, Object TeleopEndTime, Object RefCommitTime, Object ScoreKeeperCommitTime, Object ScorePostTime,
                 Object CancelMatchTime, Object CycleTime, Object RedScore, Object BlueScore, Object RedPenalty, Object BluePenalty,
                 Object RedAutoScore, Object BlueAutoScore, Object RedTeleScore, Object BlueTeleScore, Object RedEndScore,
                 Object BlueEndScore, Object HeadRefReview, Object VideoURL, Object CreatedBy, Object CreatedOn, Object ModifiedBy, Object ModifiedOn,
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
        this.MatchID = json.get("MatchID");
        this.EventID = json.get("EventID");
        this.TournamentLevel = json.get("TournamentLevel");
        this.ScheduleTime = json.get("ScheduleTime");
        this.MatchName = json.get("MatchName");
        this.PlayNumber = json.get("PlayNumber");
        this.FieldNumber = json.get("FieldNumber");
        this.PreStartInitialTime = json.get("PreStartInitialTime");
        this.PreStartFinalTime = json.get("PreStartFinalTime");
        this.PreStartCount = json.get("PreStartCount");
        this.AutoStartTime = json.get("AutoStartTime");
        this.AutoEndTime = json.get("AutoEndTime");
        this.TeleopStartTime = json.get("TeleopStartTime");
        this.TeleopEndTime = json.get("TeleopEndTime");
        this.RefCommitTime = json.get("RefCommitTime");
        this.ScoreKeeperCommitTime = json.get("ScoreKeeperCommitTime");
        this.ScorePostTime = json.get("ScorePostTime");
        this.CancelMatchTime = json.get("CancelMatchTime");
        this.CycleTime = json.get("CycleTime");
        this.RedScore = json.get("RedScore");
        this.BlueScore = json.get("BlueScore");
        this.RedPenalty = json.get("RedPenalty");
        this.BluePenalty = json.get("BluePenalty");
        this.RedAutoScore = json.get("RedAutoScore");
        this.BlueAutoScore = json.get("BlueAutoScore");
        this.RedTeleScore = json.get("RedTeleScore");
        this.BlueTeleScore = json.get("BlueTeleScore");
        this.RedEndScore = json.get("RedEndScore");
        this.BlueEndScore = json.get("BlueEndScore");
        this.HeadRefReview = json.get("HeadRefReview");
        this.VideoURL = json.get("VideoUrl");
    }

    public Object getTeleopStartTime() {
        return TeleopStartTime;
    }

    public void setTeleopStartTime(Object teleopStartTime) {
        TeleopStartTime = teleopStartTime;
    }

    public Object getMatchID() {
        return MatchID;
    }

    public void setMatchID(Object matchID) {
        MatchID = matchID;
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getTournamentLevel() {
        return TournamentLevel;
    }

    public void setTournamentLevel(Object tournamentLevel) {
        TournamentLevel = tournamentLevel;
    }

    public Object getScheduleTime() {
        return ScheduleTime;
    }

    public void setScheduleTime(Object scheduleTime) {
        ScheduleTime = scheduleTime;
    }

    public Object getMatchName() {
        return MatchName;
    }

    public void setMatchName(Object matchName) {
        MatchName = matchName;
    }

    public Object getPlayNumber() {
        return PlayNumber;
    }

    public void setPlayNumber(Object playNumber) {
        PlayNumber = playNumber;
    }

    public Object getFieldNumber() {
        return FieldNumber;
    }

    public void setFieldNumber(Object fieldNumber) {
        FieldNumber = fieldNumber;
    }

    public Object getPreStartInitialTime() {
        return PreStartInitialTime;
    }

    public void setPreStartInitialTime(Object preStartInitialTime) {
        PreStartInitialTime = preStartInitialTime;
    }

    public Object getPreStartFinalTime() {
        return PreStartFinalTime;
    }

    public void setPreStartFinalTime(Object preStartFinalTime) {
        PreStartFinalTime = preStartFinalTime;
    }

    public Object getPreStartCount() {
        return PreStartCount;
    }

    public void setPreStartCount(Object preStartCount) {
        PreStartCount = preStartCount;
    }

    public Object getAutoStartTime() {
        return AutoStartTime;
    }

    public void setAutoStartTime(Object autoStartTime) {
        AutoStartTime = autoStartTime;
    }

    public Object getAutoEndTime() {
        return AutoEndTime;
    }

    public void setAutoEndTime(Object autoEndTime) {
        AutoEndTime = autoEndTime;
    }

    public Object getTeleopEndTime() {
        return TeleopEndTime;
    }

    public void setTeleopEndTime(Object teleopEndTime) {
        TeleopEndTime = teleopEndTime;
    }

    public Object getRefCommitTime() {
        return RefCommitTime;
    }

    public void setRefCommitTime(Object refCommitTime) {
        RefCommitTime = refCommitTime;
    }

    public Object getScoreKeeperCommitTime() {
        return ScoreKeeperCommitTime;
    }

    public void setScoreKeeperCommitTime(Object scoreKeeperCommitTime) {
        ScoreKeeperCommitTime = scoreKeeperCommitTime;
    }

    public Object getScorePostTime() {
        return ScorePostTime;
    }

    public void setScorePostTime(Object scorePostTime) {
        ScorePostTime = scorePostTime;
    }

    public Object getCancelMatchTime() {
        return CancelMatchTime;
    }

    public void setCancelMatchTime(Object cancelMatchTime) {
        CancelMatchTime = cancelMatchTime;
    }

    public Object getCycleTime() {
        return CycleTime;
    }

    public void setCycleTime(Object cycleTime) {
        CycleTime = cycleTime;
    }

    public Object getRedScore() {
        return RedScore;
    }

    public void setRedScore(Object redScore) {
        RedScore = redScore;
    }

    public Object getBlueScore() {
        return BlueScore;
    }

    public void setBlueScore(Object blueScore) {
        BlueScore = blueScore;
    }

    public Object getRedPenalty() {
        return RedPenalty;
    }

    public void setRedPenalty(Object redPenalty) {
        RedPenalty = redPenalty;
    }

    public Object getBluePenalty() {
        return BluePenalty;
    }

    public void setBluePenalty(Object bluePenalty) {
        BluePenalty = bluePenalty;
    }

    public Object getRedAutoScore() {
        return RedAutoScore;
    }

    public void setRedAutoScore(Object redAutoScore) {
        RedAutoScore = redAutoScore;
    }

    public Object getBlueAutoScore() {
        return BlueAutoScore;
    }

    public void setBlueAutoScore(Object blueAutoScore) {
        BlueAutoScore = blueAutoScore;
    }

    public Object getRedTeleScore() {
        return RedTeleScore;
    }

    public void setRedTeleScore(Object redTeleScore) {
        RedTeleScore = redTeleScore;
    }

    public Object getBlueTeleScore() {
        return BlueTeleScore;
    }

    public void setBlueTeleScore(Object blueTeleScore) {
        BlueTeleScore = blueTeleScore;
    }

    public Object getRedEndScore() {
        return RedEndScore;
    }

    public void setRedEndScore(Object redEndScore) {
        RedEndScore = redEndScore;
    }

    public Object getBlueEndScore() {
        return BlueEndScore;
    }

    public void setBlueEndScore(Object blueEndScore) {
        BlueEndScore = blueEndScore;
    }

    public Object getHeadRefReview() {
        return HeadRefReview;
    }

    public void setHeadRefReview(Object headRefReview) {
        HeadRefReview = headRefReview;
    }

    public Object getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(Object videoURL) {
        VideoURL = videoURL;
    }
}