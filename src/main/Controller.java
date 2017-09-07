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

    private String apiKey = null;
    private String webURL = null;
    private String appPurpose = "TOA Data Downloader";
    private statusPopupController stPop;

    private List<Advancement>       adv = new ArrayList<>();
    private List<Alliance>          all = new ArrayList<>();
    private List<Award>             awa = new ArrayList<>();
    private List<Event>             eve = new ArrayList<>();
    private List<EventTeam>         etm = new ArrayList<>();
    private List<Match>             mat = new ArrayList<>();
    private List<MatchDetails>      mad = new ArrayList<>();
    private List<ScheduleStation>   sch = new ArrayList<>();
    private List<Team>              tem = new ArrayList<>();
    private List<TeamRanking>       ter = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pne_auth.setStyle("-fx-background-color: red");
    }

    @FXML
    public void authenticate() {
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

    private boolean checkAuth(URL url, String APIkey) throws Exception {

        boolean responseCode200 = false;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("X-TOA-Key", APIkey);
        con.setRequestProperty("X-Application-Origin", appPurpose);

        int responseCode = con.getResponseCode();
        if(responseCode == 200){responseCode200 = true;}

        return responseCode200;
    }

    private BufferedReader sendGETRequest(URL url) throws Exception {

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("X-TOA-Key", apiKey);
        con.setRequestProperty("X-Application-Origin", appPurpose);

        // Reading response from input Stream
        return new BufferedReader(new InputStreamReader(con.getInputStream()));

    }

    @FXML
    public void download() {
        if(cb_advancements.isSelected()){
            adv.add(null);
            System.out.println(adv);
        }
        if(cb_awards.isSelected()){
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/awards"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/alliances"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/teams"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches/details"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/matches/stations"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/event/2017/" + tb_eventkey.getText() + "/rankings"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/events/"));

                String output;
                StringBuilder response = new StringBuilder();

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
            try {
                BufferedReader in = sendGETRequest(new URL(webURL + "/teams/"));

                String output;
                StringBuilder response = new StringBuilder();

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

    private void confirm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statusPopup.fxml"));
            Parent root1 = fxmlLoader.load();
            stPop = fxmlLoader.getController();
            stPop.populateWindow();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Log");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/app_ico.png")));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException e){
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        StringBuilder confirmMessage = new StringBuilder();
        List<String> confirm = new ArrayList<>();
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
            confirmMessage.append(con);
            confirmMessage.append("\n");
        }
        stPop.stat_popup_textField.setText(confirmMessage.toString());
    }

    void save(){
        if(cb_seperatejson.isSelected()){
            if(cb_advancements.isSelected()){
                System.out.println("Advancements Called but not Ready Yet");
            }
            if(cb_awards.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("Awards", parseAwardToJSON(awa));
                writeStringToFile(obj.toString(), "awards", "json");
            }
            if(cb_alliance.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("alliances", parseAllianceToJSON(all));
                writeStringToFile(obj.toString(), "alliances", "json");
            }
            if(cb_eventparticipants.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("event _teams", parseEventTeamsToJSON(etm));
                writeStringToFile(obj.toString(), "event_teams", "json");
            }
            if(cb_matches.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("matches", parseMatchesToJSON(mat));
                writeStringToFile(obj.toString(), "matches", "json");
            }
            if(cb_matchdetails.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("match_details", parseMatchDetailsToJSON(mad));
                writeStringToFile(obj.toString(), "match_details", "json");
            }
            if(cb_schedulestation.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("schedule_station", parseScheduleStationToJSON(sch));
                writeStringToFile(obj.toString(), "schedule_station", "json");
            }
            if(cb_teamrankings.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("team_rankings", parseTeamRankingToJSON(ter));
                writeStringToFile(obj.toString(), "team_rankings", "json");
            }
            if(cb_allevents.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("events", parseEventsToJSON(eve));
                writeStringToFile(obj.toString(), "events", "json");
            }
            if(cb_allteams.isSelected()){
                JSONObject obj = new JSONObject();
                obj.put("teams", parseTeamsToJSON(tem));
                writeStringToFile(obj.toString(), "teams", "json");
            }
        }
        if(cb_combinedjson.isSelected()){
            JSONObject obj = new JSONObject();
            if(cb_advancements.isSelected()){
                System.out.println("Advancements Called but not Ready Yet");
            }
            if(cb_awards.isSelected()){
                obj.put("awards", parseAwardToJSON(awa));
            }
            if(cb_alliance.isSelected()){
                obj.put("alliances", parseAllianceToJSON(all));
            }
            if(cb_eventparticipants.isSelected()){
                obj.put("event_teams", parseEventTeamsToJSON(etm));
            }
            if(cb_matches.isSelected()){
                obj.put("matches", parseMatchesToJSON(mat));
            }
            if(cb_matchdetails.isSelected()){
                obj.put("match_details", parseMatchDetailsToJSON(mad));
            }
            if(cb_schedulestation.isSelected()){
                obj.put("schedule_station", parseScheduleStationToJSON(sch));
            }
            if(cb_teamrankings.isSelected()){
                obj.put("team_rankings", parseTeamRankingToJSON(ter));
            }
            if(cb_allevents.isSelected()){
                obj.put("all_events", parseEventsToJSON(eve));
            }
            if(cb_allteams.isSelected()){
                obj.put("all_teams", parseTeamsToJSON(tem));
            }
            writeStringToFile(obj.toString(), "All", "json");
        }
        if(cb_csv.isSelected()){
            if(cb_advancements.isSelected()){
                System.out.println("Advancements Called but not Ready Yet");
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

    private void writeStringToFile(String output, String fileName, String ext) {
        try {
            File file = new File(tb_location.getText() + "\\" + tb_eventkey.getText() + "-" + fileName + "." + ext);
            if(!file.exists()){
                if(file.createNewFile()){
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(output);
                    fileWriter.flush();
                    fileWriter.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray parseAwardToJSON(List<Award> award) {
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

    private JSONArray parseAllianceToJSON(List<Alliance> alliance) {
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

    private JSONArray parseEventTeamsToJSON(List<EventTeam> eventPar) {
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

    private JSONArray parseMatchesToJSON(List<Match> matches) {
        JSONArray match = new JSONArray();
        int i = 0;
        while (matches.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("match_key", matches.get(i).getMatchID());
            obj.put("event_key", matches.get(i).getEventID());
            obj.put("tournament_level", matches.get(i).getTournamentLevel());
            obj.put("schedule_time", matches.get(i).getScheduleTime());
            obj.put("match_name", matches.get(i).getMatchName());
            obj.put("play_number", matches.get(i).getPlayNumber());
            obj.put("field_number", matches.get(i).getFieldNumber());
            obj.put("pre_start_initial_time", matches.get(i).getPreStartInitialTime());
            obj.put("pre_start_final_ime", matches.get(i).getPreStartFinalTime());
            obj.put("pre_start_count", matches.get(i).getPreStartCount());
            obj.put("auto_start_time", matches.get(i).getAutoStartTime());
            obj.put("auto_end_time", matches.get(i).getAutoEndTime());
            obj.put("teleop_start_time", matches.get(i).getTeleopStartTime());
            obj.put("teleop_end_time", matches.get(i).getTeleopEndTime());
            obj.put("ref_commit_time", matches.get(i).getRefCommitTime());
            obj.put("score_keeper_commit_time", matches.get(i).getScoreKeeperCommitTime());
            obj.put("score_post_time", matches.get(i).getScorePostTime());
            obj.put("cancel_match_time", matches.get(i).getCancelMatchTime());
            obj.put("cycle_time", matches.get(i).getCycleTime());
            obj.put("red_score", matches.get(i).getRedScore());
            obj.put("blue_score", matches.get(i).getBlueScore());
            obj.put("red_penalty", matches.get(i).getRedPenalty());
            obj.put("blue_penalty", matches.get(i).getBluePenalty());
            obj.put("red_ auto_score", matches.get(i).getRedAutoScore());
            obj.put("blue_auto_score", matches.get(i).getBlueAutoScore());
            obj.put("red_tele_score", matches.get(i).getRedTeleScore());
            obj.put("blue_tele_score", matches.get(i).getBlueTeleScore());
            obj.put("red_end_score", matches.get(i).getRedEndScore());
            obj.put("blue_end_score", matches.get(i).getBlueEndScore());
            obj.put("head_ref_review", matches.get(i).getHeadRefReview());
            obj.put("video_url", matches.get(i).getVideoURL());
            match.put(obj);
            i++;
        }

        return match;
    }

    private JSONArray parseMatchDetailsToJSON(List<MatchDetails> matchDetails) {
        JSONArray match = new JSONArray();
        int i = 0;
        while (matchDetails.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("match_dtl_key", matchDetails.get(i).getMatchDtlKey());
            obj.put("match_key", matchDetails.get(i).getMatchID());
            obj.put("red_auto_beacons", matchDetails.get(i).getRedAutoBeacons());
            obj.put("red_auto_cap", matchDetails.get(i).getRedAutoCap());
            obj.put("red_auto_part_cen", matchDetails.get(i).getRedAutoPartCen());
            obj.put("red_auto_part_cor", matchDetails.get(i).getRedAutoPartCor());
            obj.put("red_auto_robot1", matchDetails.get(i).getRedAutoRobot1());
            obj.put("red_auto_robot2", matchDetails.get(i).getRedAutoRobot2());
            obj.put("red_driver_beacons", matchDetails.get(i).getRedDriverBeacons());
            obj.put("red_driver_part_cen", matchDetails.get(i).getRedDriverPartCen());
            obj.put("red_driver_part_cor", matchDetails.get(i).getRedDriverPartCor());
            obj.put("red_driver_cap", matchDetails.get(i).getRedDriverCap());
            obj.put("red_pen_maj", matchDetails.get(i).getRedPenMaj());
            obj.put("red_pen_min", matchDetails.get(i).getRedPenMin());
            obj.put("blue_auto_beacons", matchDetails.get(i).getBlueAutoBeacons());
            obj.put("blue_auto_cap", matchDetails.get(i).getBlueAutoCap());
            obj.put("blue_auto_part_cen", matchDetails.get(i).getBlueAutoPartCen());
            obj.put("blue_auto_part_cor", matchDetails.get(i).getBlueAutoPartCor());
            obj.put("blue_auto_robot1", matchDetails.get(i).getBlueAutoRobot1());
            obj.put("blue_auto_robot2", matchDetails.get(i).getBlueAutoRobot2());
            obj.put("blue_driver_beacons", matchDetails.get(i).getBlueDriverBeacons());
            obj.put("blue_driver_part_cen", matchDetails.get(i).getBlueDriverPartCen());
            obj.put("blue_driver_part_cor", matchDetails.get(i).getBlueDriverPartCor());
            obj.put("blue_driver_cap", matchDetails.get(i).getBlueDriverCap());
            obj.put("blue_pen_maj", matchDetails.get(i).getBluePenMaj());
            obj.put("blue_pen_min", matchDetails.get(i).getBluePenMin());
            match.put(obj);
            i++;
        }

        return match;
    }

    private JSONArray parseScheduleStationToJSON(List<ScheduleStation> scheduleStations) {
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

    private JSONArray parseTeamRankingToJSON(List<TeamRanking> teamRankings) {
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

    private JSONArray parseEventsToJSON(List<Event> events) {
        JSONArray event = new JSONArray();
        int i = 0;
        while (events.size() > i){
            JSONObject obj = new JSONObject();
            obj.put("event_key", events.get(i).getEventID());
            obj.put("season_key", events.get(i).getSeasonID());
            obj.put("region_key", events.get(i).getRegionID());
            obj.put("league_key", events.get(i).getLeagueID());
            obj.put("event_code", events.get(i).getEventID());
            obj.put("event_region_um", events.get(i).getEventRegionNum());
            obj.put("division_key", events.get(i).getDivisionID());
            obj.put("event_type_key", events.get(i).getEventTypeID());
            obj.put("event_name", events.get(i).getEventName());
            obj.put("division_name", events.get(i).getDivisionName());
            obj.put("start_date", events.get(i).getStartDate());
            obj.put("end_date", events.get(i).getEndDate());
            obj.put("week_key", events.get(i).getWeekID());
            obj.put("city", events.get(i).getCity());
            obj.put("state_prov", events.get(i).getStateProv());
            obj.put("country", events.get(i).getCountry());
            obj.put("venue", events.get(i).getVenue());
            obj.put("event_website", events.get(i).getEventWebsite());
            obj.put("time_zone", events.get(i).getTimeZone());
            obj.put("active_tournament_evel", events.get(i).getActiveTournamentLevel());
            obj.put("alliance_count", events.get(i).getAllianceCount());
            obj.put("number_of_fields", events.get(i).getNumberOfFields());
            obj.put("advance_spots", events.get(i).getAdvanceSpots());
            obj.put("advancement_event", events.get(i).getAdvancementEvent());
            event.put(obj);
            i++;
        }
        return event;
    }

    private JSONArray parseTeamsToJSON(List<Team> teams) {
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

    private void parseJSONtoCSV(String fileName, JSONArray json){
        writeStringToFile(CDL.toString(json), fileName, "csv");
    }
}
