package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.classes.JSON.CDL;
import main.classes.JSON.JSONArray;
import main.classes.JSON.JSONObject;
import main.classes.TOA.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML public TextField tb_apiurl = new TextField();
    @FXML public TextField tb_apikey = new TextField();
    @FXML public Button btn_auth = new Button();
    @FXML public Pane pne_auth = new Pane();
    @FXML public Label lbl_auth = new Label();
    @FXML public TextField tb_eventkey = new TextField();
    @FXML public TextField tb_location = new TextField();
    @FXML public Button btn_browse = new Button();
    @FXML public CheckBox cb_allevents = new CheckBox();
    @FXML public CheckBox cb_allteams = new CheckBox();
    @FXML public CheckBox cb_advancements = new CheckBox();
    @FXML public CheckBox cb_alliance = new CheckBox();
    @FXML public CheckBox cb_awards = new CheckBox();
    @FXML public CheckBox cb_eventparticipants = new CheckBox();
    @FXML public CheckBox cb_matches = new CheckBox();
    @FXML public CheckBox cb_matchdetails = new CheckBox();
    @FXML public CheckBox cb_schedulestation = new CheckBox();
    @FXML public CheckBox cb_teamrankings = new CheckBox();
    @FXML public CheckBox cb_seperatejson = new CheckBox();
    @FXML public CheckBox cb_combinedjson = new CheckBox();
    @FXML public CheckBox cb_csv = new CheckBox();
    @FXML public Button btn_download = new Button();

    public String apiKey = null;
    public String webURL = null;
    public String appPurpose = "TOA Data Downloader";
    private statusPopupController stPop;

    private List<Advancement>       adv = new ArrayList<Advancement>();
    private List<Alliance>          all = new ArrayList<Alliance>();
    private List<Award>             awa = new ArrayList<Award>();
    private List<Event>             eve = new ArrayList<Event>();
    private List<EventTeam>         etm = new ArrayList<EventTeam>();
    private List<Match>             mat = new ArrayList<Match>();
    private List<MatchDetails>      mad = new ArrayList<MatchDetails>();
    private List<ScheduleStation>   sch = new ArrayList<ScheduleStation>();
    private List<Team>              tem = new ArrayList<Team>();
    private List<TeamRanking>       ter = new ArrayList<TeamRanking>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pne_auth.setStyle("-fx-background-color: red");
    }

    @FXML
    public void authenticate(ActionEvent event) {
        try {
            if(checkAuth(new URL(tb_apiurl.getText()), tb_apikey.getText())){
                pne_auth.setStyle("-fx-background-color: green");
                lbl_auth.setText("Authenticated!");
                apiKey = tb_apikey.getText();
                webURL = tb_apiurl.getText();
                btn_download.setDisable(false);
            }else{
                lbl_auth.setText("API Key Rejected.  Please Try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkAuth(URL url, String APIkey) throws Exception {

        boolean responseCode200 = false;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("X-TOA-Key", APIkey);
        con.setRequestProperty("X-Application-Origin", appPurpose);

        int responseCode = con.getResponseCode();
        if(responseCode == 200){responseCode200 = true;}

        return responseCode200;
    }

    public BufferedReader sendGETRequest(URL url) throws Exception {

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("X-TOA-Key", apiKey);
        con.setRequestProperty("X-Application-Origin", appPurpose);

        // Reading response from input Stream
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        return in;

    }

    @FXML
    public void download(ActionEvent event) {
        if(cb_advancements.isSelected()){

        }
        if(cb_awards.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/awards"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();

                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject) jsonarray.get(i);
                    Award singleAward = new Award(jsonobject);
                    awa.add(singleAward);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_alliance.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/alliances"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject) jsonarray.get(i);
                    Alliance singleAlliance = new Alliance(jsonobject);
                    all.add(singleAlliance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_eventparticipants.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/teams"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject) jsonarray.get(i);
                    EventTeam singleEventTeam = new EventTeam(jsonobject);
                    etm.add(singleEventTeam);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_matches.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    Match singleMatch = new Match(jsonobject);
                    mat.add(singleMatch);

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("(╯°□°）╯︵ ┻━┻");
            }
        }
        if(cb_matchdetails.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches/details"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    MatchDetails singleMatch = new MatchDetails(jsonobject);
                    mad.add(singleMatch);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_schedulestation.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches/stations"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject) jsonarray.get(i);
                    ScheduleStation singleSS = new ScheduleStation(jsonobject);
                    sch.add(singleSS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_teamrankings.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/rankings"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    TeamRanking singleTR = new TeamRanking(jsonobject);
                    ter.add(singleTR);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_allevents.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/events/"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    Event singleEvent =  new Event(jsonobject);
                    eve.add(singleEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_allteams.isSelected()){
            BufferedReader in = null;
            try {
                in = sendGETRequest(new URL(webURL + "/teams/"));

                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();
                JSONArray jsonarray = new JSONArray(response + "");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    Team singleTeam = new Team(jsonobject);
                    tem.add(singleTeam);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        confirm();
    }

    public void confirm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statusPopup.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stPop = (statusPopupController) fxmlLoader.getController();
            stPop.populateWindow();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Log");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/app_ico.png")));
            stage.setScene(new Scene(root1));
            stage.show();

            //((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        String confirmMessage = "";
        List<String> confirm = new ArrayList<String>();
        confirm.add("Downloading:");
        if(cb_allevents.isSelected()){confirm.add("All Events");}
        if(cb_allteams.isSelected()){confirm.add("All Teams");}
        if(cb_advancements.isSelected()){confirm.add("Advancements(Currently Inactive) for " + tb_eventkey.getText());}
        if(cb_alliance.isSelected()){confirm.add("Alliances for " + tb_eventkey.getText());}
        if(cb_awards.isSelected()){confirm.add("Awards for " + tb_eventkey.getText());}
        if(cb_eventparticipants.isSelected()){confirm.add("Event Teams for " + tb_eventkey.getText());}
        if(cb_matches.isSelected()){confirm.add("Matches for " + tb_eventkey.getText());}
        if(cb_matchdetails.isSelected()){confirm.add("Match Details for " + tb_eventkey.getText());}
        if(cb_schedulestation.isSelected()){confirm.add("Advancements for " + tb_eventkey.getText());}
        if(cb_teamrankings.isSelected()){confirm.add("Rankings for " + tb_eventkey.getText());}
        confirm.add("Downloading as a:");
        if(cb_seperatejson.isSelected()){confirm.add("Separate JSON for ALL");}
        if(cb_combinedjson.isSelected()){confirm.add("Combined JSON for ALL");}
        if(cb_csv.isSelected()){confirm.add("Separate CSV(s)");}
        for(String con : confirm){
            confirmMessage = confirmMessage + con + "\n";
        }
        stPop.stat_popup_textField.setText(confirmMessage);
    }

    public void save(){
        if(cb_seperatejson.isSelected()){
            if(cb_advancements.isSelected()){

            }
            if(cb_awards.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Awards", parseAwardToJSON(awa));
                writeStringToFile(obj.toString(), "Awards", "json");
            }
            if(cb_alliance.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Alliances", parseAllianceToJSON(all));
                writeStringToFile(obj.toString(), "Alliances", "json");
            }
            if(cb_eventparticipants.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Event Teams", parseEventTeamsToJSON(etm));
                writeStringToFile(obj.toString(), "Event-Teams", "json");
            }
            if(cb_matches.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Matches", parseMatchesToJSON(mat));
                writeStringToFile(obj.toString(), "Matches", "json");
            }
            if(cb_matchdetails.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Match Details", parseMatchDetailsToJSON(mad));
                writeStringToFile(obj.toString(), "Match-Details", "json");
            }
            if(cb_schedulestation.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Schedule Station", parseScheduleStationToJSON(sch));
                writeStringToFile(obj.toString(), "Schedule-Station", "json");
            }
            if(cb_teamrankings.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Team Rankings", parseTeamRankingToJSON(ter));
                writeStringToFile(obj.toString(), "Team-Rankings", "json");
            }
            if(cb_allevents.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Events", parseEventsToJSON(eve));
                writeStringToFile(obj.toString(), "Events", "json");
            }
            if(cb_allteams.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Teams", parseTeamsToJSON(tem));
                writeStringToFile(obj.toString(), "Teams", "json");
            }
        }
        if(cb_combinedjson.isSelected()){
            JSONObject obj = new JSONObject();
            if(cb_advancements.isSelected()){

            }
            if(cb_awards.isSelected()){
                obj.put("Awards", parseAwardToJSON(awa));
            }
            if(cb_alliance.isSelected()){
                obj.put("Alliances", parseAllianceToJSON(all));
            }
            if(cb_eventparticipants.isSelected()){
                obj.put("Event Teams", parseEventTeamsToJSON(etm));
            }
            if(cb_matches.isSelected()){
                obj.put("Matches", parseMatchesToJSON(mat));
            }
            if(cb_matchdetails.isSelected()){
                obj.put("Match Details", parseMatchDetailsToJSON(mad));
            }
            if(cb_schedulestation.isSelected()){
                obj.put("Schedule Station", parseScheduleStationToJSON(sch));
            }
            if(cb_teamrankings.isSelected()){
                obj.put("Team Rankings", parseTeamRankingToJSON(ter));
            }
            if(cb_allevents.isSelected()){
                obj.put("All Events", parseEventsToJSON(eve));
            }
            if(cb_allteams.isSelected()){
                obj.put("All Teams", parseTeamsToJSON(tem));
            }
            writeStringToFile(obj.toString(), "All", "json");
        }
        if(cb_csv.isSelected()){
            if(cb_advancements.isSelected()){

            }
            if(cb_awards.isSelected()){
                parseJSONtoCSV("Awards", parseAwardToJSON(awa));
            }
            if(cb_alliance.isSelected()){
                parseJSONtoCSV("Alliances", parseAllianceToJSON(all));
            }
            if(cb_eventparticipants.isSelected()){
                parseJSONtoCSV("Event-Teams", parseEventTeamsToJSON(etm));
            }
            if(cb_matches.isSelected()){
                parseJSONtoCSV("Matches", parseMatchesToJSON(mat));
            }
            if(cb_matchdetails.isSelected()){
                parseJSONtoCSV("Match-Details", parseMatchDetailsToJSON(mad));
            }
            if(cb_schedulestation.isSelected()){
                parseJSONtoCSV("Schedule-Station", parseScheduleStationToJSON(sch));
            }
            if(cb_teamrankings.isSelected()){
                parseJSONtoCSV("Team-Rankings", parseTeamRankingToJSON(ter));
            }
            if(cb_allevents.isSelected()){
                parseJSONtoCSV("All-Events", parseEventsToJSON(eve));
            }
            if(cb_allteams.isSelected()){
                parseJSONtoCSV("All-Teams", parseTeamsToJSON(tem));
            }
        }

        Stage stage = (Stage) stPop.stat_popup_textField.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void browse(ActionEvent event){
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Save");
        File file = fileChooser.showDialog(((Node)event.getTarget()).getScene().getWindow());
        if(file != null){
            tb_location.setText(file.getAbsolutePath());
        }
    }

    public void writeStringToFile(String output, String fileName, String ext) {
        try {
            File file = new File(tb_location.getText() + "\\" + tb_eventkey.getText() + "-" + fileName + "." + ext);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(output);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray parseAwardToJSON(List<Award> award) {
        JSONArray awards = new JSONArray();
        int i = 0;
        while (award.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("award_key", award.get(i).getAwardsID());
            obj.put("award_name", award.get(i).getAwardID());
            obj.put("team_key", award.get(i).getTeamId());
            obj.put("reciever_name", award.get(i).getRecieverNam());
            obj.put("award_desc", award.get(i).getAwardNamAdd());
            awards.put(obj);
            i++;
        }

        return awards;
    }

    public JSONArray parseAllianceToJSON(List<Alliance> alliance) {
        JSONArray alliances = new JSONArray();
        int i = 0;
        while (alliance.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("alliance_key", alliance.get(i).getAllianceID());
            obj.put("event_key", alliance.get(i).getEventID());
            obj.put("team_key", alliance.get(i).getTeamID());
            obj.put("alliance_num", alliance.get(i).getAllianceNum());
            obj.put("alliance_pick", alliance.get(i).getAlliancePick());
            obj.put("alliance_name", alliance.get(i).getAllianceName());
            obj.put("card_carry", alliance.get(i).getCardCarry());
            alliances.put(obj);
            i++;
        }

        return alliances;
    }

    public JSONArray parseEventTeamsToJSON(List<EventTeam> eventPar) {
        JSONArray team = new JSONArray();
        int i = 0;
        while (eventPar.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("team_key", eventPar.get(i).getTeamID());
            obj.put("region_key", eventPar.get(i).getRegionID());
            obj.put("league_key", eventPar.get(i).getLeagueID());
            obj.put("team_number", eventPar.get(i).getTeamNumber());
            obj.put("team_name_short", eventPar.get(i).getTeamNameShort());
            obj.put("team_name_long", eventPar.get(i).getTeamNameLong());
            obj.put("robot_name", eventPar.get(i).getRobotName());
            obj.put("city", eventPar.get(i).getCity());
            obj.put("state_prov", eventPar.get(i).getStateProv());
            obj.put("country", eventPar.get(i).getCountry());
            obj.put("rookie_year", eventPar.get(i).getRookieYear());
            obj.put("website", eventPar.get(i).getWebsite());
            obj.put("has_card", eventPar.get(i).getHasCard());
            obj.put("event_key", eventPar.get(i).getEventID());
            team.put(obj);
            i++;
        }

        return team;
    }

    public JSONArray parseMatchesToJSON(List<Match> matches) {
        JSONArray match = new JSONArray();
        int i = 0;
        while (matches.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("MatchID", matches.get(i).getMatchID());
            obj.put("EventID", matches.get(i).getEventID());
            obj.put("TournamentLevel", matches.get(i).getTournamentLevel());
            obj.put("ScheduleTime", matches.get(i).getScheduleTime());
            obj.put("MatchName", matches.get(i).getMatchName());
            obj.put("PlayNumber", matches.get(i).getPlayNumber());
            obj.put("FieldNumber", matches.get(i).getFieldNumber());
            obj.put("PreStartInitialTime", matches.get(i).getPreStartInitialTime());
            obj.put("PreStartFinalTime", matches.get(i).getPreStartFinalTime());
            obj.put("PreStartCount", matches.get(i).getPreStartCount());
            obj.put("AutoStartTime", matches.get(i).getAutoStartTime());
            obj.put("AutoEndTime", matches.get(i).getAutoEndTime());
            obj.put("TeleopStartTime", matches.get(i).getTeleopStartTime());
            obj.put("TeleopEndTime", matches.get(i).getTeleopEndTime());
            obj.put("RefCommitTime", matches.get(i).getRefCommitTime());
            obj.put("ScoreKeeperCommitTime", matches.get(i).getScoreKeeperCommitTime());
            obj.put("ScorePostTime", matches.get(i).getScorePostTime());
            obj.put("CancelMatchTime", matches.get(i).getCancelMatchTime());
            obj.put("CycleTime", matches.get(i).getCycleTime());
            obj.put("RedScore", matches.get(i).getRedScore());
            obj.put("BlueScore", matches.get(i).getBlueScore());
            obj.put("RedPenalty", matches.get(i).getRedPenalty());
            obj.put("BluePenalty", matches.get(i).getBluePenalty());
            obj.put("RedAutoScore", matches.get(i).getRedAutoScore());
            obj.put("BlueAutoScore", matches.get(i).getBlueAutoScore());
            obj.put("RedTeleScore", matches.get(i).getRedTeleScore());
            obj.put("BlueTeleScore", matches.get(i).getBlueTeleScore());
            obj.put("RedEndScore", matches.get(i).getRedEndScore());
            obj.put("BlueEndScore", matches.get(i).getBlueEndScore());
            obj.put("HeadRefReview", matches.get(i).getHeadRefReview());
            obj.put("VideoURL", matches.get(i).getVideoURL());
            match.put(obj);
            i++;
        }

        return match;
    }

    public JSONArray parseMatchDetailsToJSON(List<MatchDetails> matchDetails) {
        JSONArray match = new JSONArray();
        int i = 0;
        while (matchDetails.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("MatchDtlKey", matchDetails.get(i).getMatchDtlKey());
            obj.put("MatchID", matchDetails.get(i).getMatchID());
            obj.put("RedAutoBeacons", matchDetails.get(i).getRedAutoBeacons());
            obj.put("RedAutoCap", matchDetails.get(i).getRedAutoCap());
            obj.put("RedAutoPartCen", matchDetails.get(i).getRedAutoPartCen());
            obj.put("RedAutoPartCor", matchDetails.get(i).getRedAutoPartCor());
            obj.put("RedAutoRobot1", matchDetails.get(i).getRedAutoRobot1());
            obj.put("RedAutoRobot2", matchDetails.get(i).getRedAutoRobot2());
            obj.put("RedDriverBeacons", matchDetails.get(i).getRedDriverBeacons());
            obj.put("RedDriverPartCen", matchDetails.get(i).getRedDriverPartCen());
            obj.put("RedDriverPartCor", matchDetails.get(i).getRedDriverPartCor());
            obj.put("RedDriverCap", matchDetails.get(i).getRedDriverCap());
            obj.put("RedPenMaj", matchDetails.get(i).getRedPenMaj());
            obj.put("RedPenMin", matchDetails.get(i).getRedPenMin());
            obj.put("BlueAutoBeacons", matchDetails.get(i).getBlueAutoBeacons());
            obj.put("BlueAutoCap", matchDetails.get(i).getBlueAutoCap());
            obj.put("BlueAutoPartCen", matchDetails.get(i).getBlueAutoPartCen());
            obj.put("BlueAutoPartCor", matchDetails.get(i).getBlueAutoPartCor());
            obj.put("BlueAutoRobot1", matchDetails.get(i).getBlueAutoRobot1());
            obj.put("BlueAutoRobot2", matchDetails.get(i).getBlueAutoRobot2());
            obj.put("BlueDriverBeacons", matchDetails.get(i).getBlueDriverBeacons());
            obj.put("BlueDriverPartCen", matchDetails.get(i).getBlueDriverPartCen());
            obj.put("BlueDriverPartCor", matchDetails.get(i).getBlueDriverPartCor());
            obj.put("BlueDriverCap", matchDetails.get(i).getBlueDriverCap());
            obj.put("BluePenMaj", matchDetails.get(i).getBluePenMaj());
            obj.put("BluePenMin", matchDetails.get(i).getBluePenMin());
            match.put(obj);
            i++;
        }

        return match;
    }

    public JSONArray parseScheduleStationToJSON(List<ScheduleStation> scheduleStations) {
        JSONArray ss = new JSONArray();
        int i = 0;
        while (scheduleStations.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("match_key", scheduleStations.get(i).getMatchId());
            obj.put("teams", scheduleStations.get(i).getTeams());
            obj.put("station_status", scheduleStations.get(i).getStats());
            obj.put("red_score", scheduleStations.get(i).getRedScore());
            obj.put("blue_score", scheduleStations.get(i).getBlueScore());
            obj.put("tournament_level", scheduleStations.get(i).getTournamentLevel());
            obj.put("match_name", scheduleStations.get(i).getMatchName());
            ss.put(obj);
            i++;
        }

        return ss;
    }

    public JSONArray parseTeamRankingToJSON(List<TeamRanking> teamRankings) {
        JSONArray teamRank = new JSONArray();
        int i = 0;
        while (teamRankings.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("team_rank_key", teamRankings.get(i).getTeamRankId());
            obj.put("event_key", teamRankings.get(i).getEventID());
            obj.put("team_key", teamRankings.get(i).getTeamID());
            obj.put("rank", teamRankings.get(i).getRank());
            obj.put("rank_change", teamRankings.get(i).getRankChange());
            obj.put("wins", teamRankings.get(i).getWins());
            obj.put("losses", teamRankings.get(i).getLosses());
            obj.put("ties", teamRankings.get(i).getTies());
            obj.put("qualifying_points", teamRankings.get(i).getQualifyingPoints());
            obj.put("ranking_points", teamRankings.get(i).getRankingPoints());
            obj.put("highest_qual_score", teamRankings.get(i).getHighestQualScore());
            obj.put("matches_played", teamRankings.get(i).getMatchesPlayed());
            obj.put("disqualified", teamRankings.get(i).getDisqualified());
            teamRank.put(obj);
            i++;
        }

        return teamRank;
    }

    public JSONArray parseEventsToJSON(List<Event> events) {
        JSONArray event = new JSONArray();
        int i = 0;
        while (events.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("EventID", events.get(i).getEventID());
            obj.put("SeasonID", events.get(i).getSeasonID());
            obj.put("RegionID", events.get(i).getRegionID());
            obj.put("LeagueID", events.get(i).getLeagueID());
            obj.put("EventCode", events.get(i).getEventID());
            obj.put("EventRegionNum", events.get(i).getEventRegionNum());
            obj.put("DivisionID", events.get(i).getDivisionID());
            obj.put("EventTypeID", events.get(i).getEventTypeID());
            obj.put("EventName", events.get(i).getEventName());
            obj.put("DivisionName", events.get(i).getDivisionName());
            obj.put("StartDate", events.get(i).getStartDate());
            obj.put("EndDate", events.get(i).getEndDate());
            obj.put("WeekID", events.get(i).getWeekID());
            obj.put("City", events.get(i).getCity());
            obj.put("StateProv", events.get(i).getStateProv());
            obj.put("Country", events.get(i).getCountry());
            obj.put("Venue", events.get(i).getVenue());
            obj.put("EventWebsite", events.get(i).getEventWebsite());
            obj.put("TimeZone", events.get(i).getTimeZone());
            obj.put("ActiveTournamentLevel", events.get(i).getActiveTournamentLevel());
            obj.put("AllianceCount", events.get(i).getAllianceCount());
            obj.put("NumberOfFields", events.get(i).getNumberOfFields());
            obj.put("AdvanceSpots", events.get(i).getAdvanceSpots());
            obj.put("AdvancementEvent", events.get(i).getAdvancementEvent());
            event.put(obj);
            i++;
        }
        return event;
    }

    public JSONArray parseTeamsToJSON(List<Team> teams) {
        JSONArray team = new JSONArray();
        int i = 0;
        while (teams.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("team_key", teams.get(i).getTeamID());
            obj.put("region_key", teams.get(i).getRegionID());
            obj.put("league_key", teams.get(i).getLeagueID());
            obj.put("team_number", teams.get(i).getTeamNumber());
            obj.put("team_name_short", teams.get(i).getTeamNameShort());
            obj.put("team_name_long", teams.get(i).getTeamNameLong());
            obj.put("robot_name", teams.get(i).getRobotName());
            obj.put("city", teams.get(i).getCity());
            obj.put("state_prov", teams.get(i).getStateProv());
            obj.put("country", teams.get(i).getCountry());
            obj.put("rookie_year", teams.get(i).getRookieYear());
            obj.put("website", teams.get(i).getWebsite());
            team.put(obj);
            i++;
        }
        return team;
    }

    public void parseJSONtoCSV(String fileName, JSONArray json){
        String csv = CDL.toString(json);
        writeStringToFile(csv, fileName, "csv");
    }
}
