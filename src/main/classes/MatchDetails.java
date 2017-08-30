package main.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/26/2017.
 */
public class MatchDetails {
    String MatchDtlKey = "";
    String MatchID = "";
    String RedAutoBeacons = "";
    String RedAutoCap = "";
    String RedAutoPartCen = "";
    String RedAutoPartCor = "";
    String RedAutoRobot1 = "";
    String RedAutoRobot2 = "";
    String RedDriverBeacons = "";
    String RedDriverPartCen = "";
    String RedDriverPartCor = "";
    String RedDriverCap = "";
    String RedPenMaj = "";
    String RedPenMin = "";
    String BlueAutoBeacons = "";
    String BlueAutoCap = "";
    String BlueAutoPartCen = "";
    String BlueAutoPartCor = "";
    String BlueAutoRobot1 = "";
    String BlueAutoRobot2 = "";
    String BlueDriverBeacons = "";
    String BlueDriverPartCen = "";
    String BlueDriverPartCor = "";
    String BlueDriverCap = "";
    String BluePenMaj = "";
    String BluePenMin = "";

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

    public MatchDetails(String MatchDtlKey, String MatchID, String RedAutoBeacons, String RedAutoCap, String RedAutoPartCen, String RedAutoPartCor, String RedAutoRobot1,
                        String RedAutoRobot2, String RedDriverBeacons, String RedDriverPartCen, String RedDriverPartCor, String RedDriverCap, String RedPenMaj, String RedPenMin,
                        String BlueAutoBeacons, String BlueAutoCap, String BlueAutoPartCen, String BlueAutoPartCor, String BlueAutoRobot1, String BlueAutoRobot2, String BlueDriverBeacons,
                        String BlueDriverPartCen, String BlueDriverPartCor, String BlueDriverCap, String BluePenMaj, String BluePenMin){

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

    public MatchDetails(ResultSet rs) throws SQLException {

        this.MatchDtlKey = rs.getString("MatchDtlKey");
        this.MatchID = rs.getString("MatchID");
        this.RedAutoBeacons = rs.getString("RedAutoBeacons");
        this.RedAutoCap = rs.getString("RedAutoCap");
        this.RedAutoPartCen = rs.getString("RedAutoPartCen");
        this.RedAutoPartCor = rs.getString("RedAutoPartCor");
        this.RedAutoRobot1 = rs.getString("RedAutoRobot1");
        this.RedAutoRobot2 = rs.getString("RedAutoRobot2");
        this.RedDriverBeacons = rs.getString("RedDriverBeacons");
        this.RedDriverPartCen = rs.getString("RedDriverPartCen");
        this.RedDriverPartCor = rs.getString("RedDriverPartCor");
        this.RedDriverCap = rs.getString("RedDriverCap");
        this.RedPenMaj = rs.getString("RedPenMaj");
        this.RedPenMin = rs.getString("RedPenMin");
        this.BlueAutoBeacons = rs.getString("BlueAutoBeacons");
        this.BlueAutoCap = rs.getString("BlueAutoCap");
        this.BlueAutoPartCen = rs.getString("BlueAutoPartCen");
        this.BlueAutoPartCor = rs.getString("BlueAutoPartCor");
        this.BlueAutoRobot1 = rs.getString("BlueAutoRobot1");
        this.BlueAutoRobot2 = rs.getString("BlueAutoRobot2");
        this.BlueDriverBeacons = rs.getString("BlueDriverBeacons");
        this.BlueDriverPartCen = rs.getString("BlueDriverPartCen");
        this.BlueDriverPartCor = rs.getString("BlueDriverPartCor");
        this.BlueDriverCap = rs.getString("BlueDriverCap");
        this.BluePenMaj = rs.getString("BluePenMaj");
        this.BluePenMin = rs.getString("BluePenMin");
    }

    public String getMatchDtlKey() {
        return MatchDtlKey;
    }

    public void setMatchDtlKey(String matchDtlKey) {
        MatchDtlKey = matchDtlKey;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String matchID) {
        MatchID = matchID;
    }

    public String getRedAutoBeacons() {
        return RedAutoBeacons;
    }

    public void setRedAutoBeacons(String redAutoBeacons) {
        RedAutoBeacons = redAutoBeacons;
    }

    public String getRedAutoCap() {
        return RedAutoCap;
    }

    public void setRedAutoCap(String redAutoCap) {
        RedAutoCap = redAutoCap;
    }

    public String getRedAutoPartCen() {
        return RedAutoPartCen;
    }

    public void setRedAutoPartCen(String redAutoPartCen) {
        RedAutoPartCen = redAutoPartCen;
    }

    public String getRedAutoPartCor() {
        return RedAutoPartCor;
    }

    public void setRedAutoPartCor(String redAutoPartCor) {
        RedAutoPartCor = redAutoPartCor;
    }

    public String getRedAutoRobot1() {
        return RedAutoRobot1;
    }

    public void setRedAutoRobot1(String redAutoRobot1) {
        RedAutoRobot1 = redAutoRobot1;
    }

    public String getRedAutoRobot2() {
        return RedAutoRobot2;
    }

    public void setRedAutoRobot2(String redAutoRobot2) {
        RedAutoRobot2 = redAutoRobot2;
    }

    public String getRedDriverBeacons() {
        return RedDriverBeacons;
    }

    public void setRedDriverBeacons(String redDriverBeacons) {
        RedDriverBeacons = redDriverBeacons;
    }

    public String getRedDriverPartCen() {
        return RedDriverPartCen;
    }

    public void setRedDriverPartCen(String redDriverPartCen) {
        RedDriverPartCen = redDriverPartCen;
    }

    public String getRedDriverPartCor() {
        return RedDriverPartCor;
    }

    public void setRedDriverPartCor(String redDriverPartCor) {
        RedDriverPartCor = redDriverPartCor;
    }

    public String getRedDriverCap() {
        return RedDriverCap;
    }

    public void setRedDriverCap(String redDriverCap) {
        RedDriverCap = redDriverCap;
    }

    public String getRedPenMaj() {
        return RedPenMaj;
    }

    public void setRedPenMaj(String redPenMaj) {
        RedPenMaj = redPenMaj;
    }

    public String getRedPenMin() {
        return RedPenMin;
    }

    public void setRedPenMin(String redPenMin) {
        RedPenMin = redPenMin;
    }

    public String getBlueAutoBeacons() {
        return BlueAutoBeacons;
    }

    public void setBlueAutoBeacons(String blueAutoBeacons) {
        BlueAutoBeacons = blueAutoBeacons;
    }

    public String getBlueAutoCap() {
        return BlueAutoCap;
    }

    public void setBlueAutoCap(String blueAutoCap) {
        BlueAutoCap = blueAutoCap;
    }

    public String getBlueAutoPartCen() {
        return BlueAutoPartCen;
    }

    public void setBlueAutoPartCen(String blueAutoPartCen) {
        BlueAutoPartCen = blueAutoPartCen;
    }

    public String getBlueAutoPartCor() {
        return BlueAutoPartCor;
    }

    public void setBlueAutoPartCor(String blueAutoPartCor) {
        BlueAutoPartCor = blueAutoPartCor;
    }

    public String getBlueAutoRobot1() {
        return BlueAutoRobot1;
    }

    public void setBlueAutoRobot1(String blueAutoRobot1) {
        BlueAutoRobot1 = blueAutoRobot1;
    }

    public String getBlueAutoRobot2() {
        return BlueAutoRobot2;
    }

    public void setBlueAutoRobot2(String blueAutoRobot2) {
        BlueAutoRobot2 = blueAutoRobot2;
    }

    public String getBlueDriverBeacons() {
        return BlueDriverBeacons;
    }

    public void setBlueDriverBeacons(String blueDriverBeacons) {
        BlueDriverBeacons = blueDriverBeacons;
    }

    public String getBlueDriverPartCen() {
        return BlueDriverPartCen;
    }

    public void setBlueDriverPartCen(String blueDriverPartCen) {
        BlueDriverPartCen = blueDriverPartCen;
    }

    public String getBlueDriverPartCor() {
        return BlueDriverPartCor;
    }

    public void setBlueDriverPartCor(String blueDriverPartCor) {
        BlueDriverPartCor = blueDriverPartCor;
    }

    public String getBlueDriverCap() {
        return BlueDriverCap;
    }

    public void setBlueDriverCap(String blueDriverCap) {
        BlueDriverCap = blueDriverCap;
    }

    public String getBluePenMaj() {
        return BluePenMaj;
    }

    public void setBluePenMaj(String bluePenMaj) {
        BluePenMaj = bluePenMaj;
    }

    public String getBluePenMin() {
        return BluePenMin;
    }

    public void setBluePenMin(String bluePenMin) {
        BluePenMin = bluePenMin;
    }
}