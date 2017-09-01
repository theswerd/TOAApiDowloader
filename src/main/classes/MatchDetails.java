package main.classes;

/**
 * Created by SPZ Productions on 8/26/2017.
 */
public class MatchDetails {
    private Object MatchDtlKey;
    private Object MatchID;
    private Object RedAutoBeacons;
    private Object RedAutoCap;
    private Object RedAutoPartCen;
    private Object RedAutoPartCor;
    private Object RedAutoRobot1;
    private Object RedAutoRobot2;
    private Object RedDriverBeacons;
    private Object RedDriverPartCen;
    private Object RedDriverPartCor;
    private Object RedDriverCap;
    private Object RedPenMaj;
    private Object RedPenMin;
    private Object BlueAutoBeacons;
    private Object BlueAutoCap;
    private Object BlueAutoPartCen;
    private Object BlueAutoPartCor;
    private Object BlueAutoRobot1;
    private Object BlueAutoRobot2;
    private Object BlueDriverBeacons;
    private Object BlueDriverPartCen;
    private Object BlueDriverPartCor;
    private Object BlueDriverCap;
    private Object BluePenMaj;
    private Object BluePenMin;

    public MatchDetails(){
        this.MatchDtlKey = "";
        this.MatchID = "";
        this.RedAutoBeacons = "";
        this.RedAutoCap = "";
        this.RedAutoPartCen = "";
        this.RedAutoPartCor = "";
        this.RedAutoRobot1 = "";
        this.RedAutoRobot2 = "";
        this.RedDriverBeacons = "";
        this.RedDriverPartCen = "";
        this.RedDriverPartCor = "";
        this.RedDriverCap = "";
        this.RedPenMaj = "";
        this.RedPenMin = "";
        this.BlueAutoBeacons = "";
        this.BlueAutoCap = "";
        this.BlueAutoPartCen = "";
        this.BlueAutoPartCor = "";
        this.BlueAutoRobot1 = "";
        this.BlueAutoRobot2 = "";
        this.BlueDriverBeacons = "";
        this.BlueDriverPartCen = "";
        this.BlueDriverPartCor = "";
        this.BlueDriverCap = "";
        this.BluePenMaj = "";
        this.BluePenMin = "";
    }

    public MatchDetails(Object MatchDtlKey, Object MatchID, Object RedAutoBeacons, Object RedAutoCap, Object RedAutoPartCen, Object RedAutoPartCor, Object RedAutoRobot1,
                        Object RedAutoRobot2, Object RedDriverBeacons, Object RedDriverPartCen, Object RedDriverPartCor, Object RedDriverCap, Object RedPenMaj, Object RedPenMin,
                        Object BlueAutoBeacons, Object BlueAutoCap, Object BlueAutoPartCen, Object BlueAutoPartCor, Object BlueAutoRobot1, Object BlueAutoRobot2, Object BlueDriverBeacons,
                        Object BlueDriverPartCen, Object BlueDriverPartCor, Object BlueDriverCap, Object BluePenMaj, Object BluePenMin){

        this.MatchDtlKey = MatchDtlKey;
        this.MatchID = MatchID;
        this.RedAutoBeacons = RedAutoBeacons;
        this.RedAutoCap = RedAutoCap;
        this.RedAutoPartCen = RedAutoPartCen;
        this.RedAutoPartCor = RedAutoPartCor;
        this.RedAutoRobot1 = RedAutoRobot1;
        this.RedAutoRobot2 = RedAutoRobot2;
        this.RedDriverBeacons = RedDriverBeacons;
        this.RedDriverPartCen = RedDriverPartCen;
        this.RedDriverPartCor = RedDriverPartCor;
        this.RedDriverCap = RedDriverCap;
        this.RedPenMaj = RedPenMaj;
        this.RedPenMin = RedPenMin;
        this.BlueAutoBeacons = BlueAutoBeacons;
        this.BlueAutoCap = BlueAutoCap;
        this.BlueAutoPartCen = BlueAutoPartCen;
        this.BlueAutoPartCor = BlueAutoPartCor;
        this.BlueAutoRobot1 = BlueAutoRobot1;
        this.BlueAutoRobot2 = BlueAutoRobot2;
        this.BlueDriverBeacons = BlueDriverBeacons;
        this.BlueDriverPartCen = BlueDriverPartCen;
        this.BlueDriverPartCor = BlueDriverPartCor;
        this.BlueDriverCap = BlueDriverCap;
        this.BluePenMaj = BluePenMaj;
        this.BluePenMin = BluePenMin;
    }

    public MatchDetails(JSONObject json){

        this.MatchDtlKey = json.get("MatchDtlKey");
        this.MatchID = json.get("MatchID");
        this.RedAutoBeacons = json.get("RedAutoBeacons");
        this.RedAutoCap = json.get("RedAutoCap");
        this.RedAutoPartCen = json.get("RedAutoPartCen");
        this.RedAutoPartCor = json.get("RedAutoPartCor");
        this.RedAutoRobot1 = json.get("RedAutoRobot1");
        this.RedAutoRobot2 = json.get("RedAutoRobot2");
        this.RedDriverBeacons = json.get("RedDriverBeacons");
        this.RedDriverPartCen = json.get("RedDriverPartCen");
        this.RedDriverPartCor = json.get("RedDriverPartCor");
        this.RedDriverCap = json.get("RedDriverCap");
        this.RedPenMaj = json.get("RedPenMaj");
        this.RedPenMin = json.get("RedPenMin");
        this.BlueAutoBeacons = json.get("BlueAutoBeacons");
        this.BlueAutoCap = json.get("BlueAutoCap");
        this.BlueAutoPartCen = json.get("BlueAutoPartCen");
        this.BlueAutoPartCor = json.get("BlueAutoPartCor");
        this.BlueAutoRobot1 = json.get("BlueAutoRobot1");
        this.BlueAutoRobot2 = json.get("BlueAutoRobot2");
        this.BlueDriverBeacons = json.get("BlueDriverBeacons");
        this.BlueDriverPartCen = json.get("BlueDriverPartCen");
        this.BlueDriverPartCor = json.get("BlueDriverPartCor");
        this.BlueDriverCap = json.get("BlueDriverCap");
        this.BluePenMaj = json.get("BluePenMaj");
        this.BluePenMin = json.get("BluePenMin");
    }

    public Object getMatchDtlKey() {
        return MatchDtlKey;
    }

    public void setMatchDtlKey(Object matchDtlKey) {
        MatchDtlKey = matchDtlKey;
    }

    public Object getMatchID() {
        return MatchID;
    }

    public void setMatchID(Object matchID) {
        MatchID = matchID;
    }

    public Object getRedAutoBeacons() {
        return RedAutoBeacons;
    }

    public void setRedAutoBeacons(Object redAutoBeacons) {
        RedAutoBeacons = redAutoBeacons;
    }

    public Object getRedAutoCap() {
        return RedAutoCap;
    }

    public void setRedAutoCap(Object redAutoCap) {
        RedAutoCap = redAutoCap;
    }

    public Object getRedAutoPartCen() {
        return RedAutoPartCen;
    }

    public void setRedAutoPartCen(Object redAutoPartCen) {
        RedAutoPartCen = redAutoPartCen;
    }

    public Object getRedAutoPartCor() {
        return RedAutoPartCor;
    }

    public void setRedAutoPartCor(Object redAutoPartCor) {
        RedAutoPartCor = redAutoPartCor;
    }

    public Object getRedAutoRobot1() {
        return RedAutoRobot1;
    }

    public void setRedAutoRobot1(Object redAutoRobot1) {
        RedAutoRobot1 = redAutoRobot1;
    }

    public Object getRedAutoRobot2() {
        return RedAutoRobot2;
    }

    public void setRedAutoRobot2(Object redAutoRobot2) {
        RedAutoRobot2 = redAutoRobot2;
    }

    public Object getRedDriverBeacons() {
        return RedDriverBeacons;
    }

    public void setRedDriverBeacons(Object redDriverBeacons) {
        RedDriverBeacons = redDriverBeacons;
    }

    public Object getRedDriverPartCen() {
        return RedDriverPartCen;
    }

    public void setRedDriverPartCen(Object redDriverPartCen) {
        RedDriverPartCen = redDriverPartCen;
    }

    public Object getRedDriverPartCor() {
        return RedDriverPartCor;
    }

    public void setRedDriverPartCor(Object redDriverPartCor) {
        RedDriverPartCor = redDriverPartCor;
    }

    public Object getRedDriverCap() {
        return RedDriverCap;
    }

    public void setRedDriverCap(Object redDriverCap) {
        RedDriverCap = redDriverCap;
    }

    public Object getRedPenMaj() {
        return RedPenMaj;
    }

    public void setRedPenMaj(Object redPenMaj) {
        RedPenMaj = redPenMaj;
    }

    public Object getRedPenMin() {
        return RedPenMin;
    }

    public void setRedPenMin(Object redPenMin) {
        RedPenMin = redPenMin;
    }

    public Object getBlueAutoBeacons() {
        return BlueAutoBeacons;
    }

    public void setBlueAutoBeacons(Object blueAutoBeacons) {
        BlueAutoBeacons = blueAutoBeacons;
    }

    public Object getBlueAutoCap() {
        return BlueAutoCap;
    }

    public void setBlueAutoCap(Object blueAutoCap) {
        BlueAutoCap = blueAutoCap;
    }

    public Object getBlueAutoPartCen() {
        return BlueAutoPartCen;
    }

    public void setBlueAutoPartCen(Object blueAutoPartCen) {
        BlueAutoPartCen = blueAutoPartCen;
    }

    public Object getBlueAutoPartCor() {
        return BlueAutoPartCor;
    }

    public void setBlueAutoPartCor(Object blueAutoPartCor) {
        BlueAutoPartCor = blueAutoPartCor;
    }

    public Object getBlueAutoRobot1() {
        return BlueAutoRobot1;
    }

    public void setBlueAutoRobot1(Object blueAutoRobot1) {
        BlueAutoRobot1 = blueAutoRobot1;
    }

    public Object getBlueAutoRobot2() {
        return BlueAutoRobot2;
    }

    public void setBlueAutoRobot2(Object blueAutoRobot2) {
        BlueAutoRobot2 = blueAutoRobot2;
    }

    public Object getBlueDriverBeacons() {
        return BlueDriverBeacons;
    }

    public void setBlueDriverBeacons(Object blueDriverBeacons) {
        BlueDriverBeacons = blueDriverBeacons;
    }

    public Object getBlueDriverPartCen() {
        return BlueDriverPartCen;
    }

    public void setBlueDriverPartCen(Object blueDriverPartCen) {
        BlueDriverPartCen = blueDriverPartCen;
    }

    public Object getBlueDriverPartCor() {
        return BlueDriverPartCor;
    }

    public void setBlueDriverPartCor(Object blueDriverPartCor) {
        BlueDriverPartCor = blueDriverPartCor;
    }

    public Object getBlueDriverCap() {
        return BlueDriverCap;
    }

    public void setBlueDriverCap(Object blueDriverCap) {
        BlueDriverCap = blueDriverCap;
    }

    public Object getBluePenMaj() {
        return BluePenMaj;
    }

    public void setBluePenMaj(Object bluePenMaj) {
        BluePenMaj = bluePenMaj;
    }

    public Object getBluePenMin() {
        return BluePenMin;
    }

    public void setBluePenMin(Object bluePenMin) {
        BluePenMin = bluePenMin;
    }
}