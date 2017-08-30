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
import org.json.simple.parser.JSONParser;
import main.classes.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray) parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    Match singleMatch = new Match(jsonobject);
                    mat.add(singleMatch);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cb_matchdetails.isSelected()){

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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
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
                JSONParser parser = new JSONParser();
                JSONArray jsonarray = (JSONArray)parser.parse(response + "");
                for (int i = 0; i < jsonarray.size(); i++) {
                    JSONObject jsonobject = (JSONObject)jsonarray.get(i);
                    Team singleTeam = new Team(jsonobject);
                    tem.add(singleTeam);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //show popup
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
        if(cb_matchdetails.isSelected()){confirm.add("Match Details(Currently Inactive) for " + tb_eventkey.getText());}
        if(cb_schedulestation.isSelected()){confirm.add("Advancements for " + tb_eventkey.getText());}
        if(cb_teamrankings.isSelected()){confirm.add("Rankings for " + tb_eventkey.getText());}
        confirm.add("Downloading as a:");
        if(cb_seperatejson.isSelected()){confirm.add("Separate JSON for ALL");}
        if(cb_seperatejson.isSelected()){confirm.add("Combined JSON for ALL");}
        if(cb_seperatejson.isSelected()){confirm.add("Separate CSV(s)");}
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
                obj.put("Awards", parseAwardToJSON(awa)); //TODO: KYLE, PLEASE FIX THIS BROKEN THING
                //tb_location.getText() + "\\" + tb_eventkey.getText() + "-Awards.json" //THIS IS THE URL TO WHERE THE FILE SHOULD BE STORED

                //try {

                    /*//FILEWRITER ATTEMPT # ONE
                    File file = new File(tb_location.getText() + "\\" + tb_eventkey.getText() + "-Awards.json");
                    file.createNewFile();
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(obj.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();
                    */

                    //EVENT TRYING TO PRINT OUT THE JSONObject DOESNT WORK... HELPPPPPPPPPPP
                    System.out.println(obj.toJSONString());
                    System.out.println("Printed");

                    /*//FILEWRITER ATTEMPT # TWO
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter out = new BufferedWriter(fw);
                    out.write(obj.toJSONString());
                    out.flush();
                    out.close();
                    */
                /*} catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            if(cb_alliance.isSelected()){

            }
            if(cb_eventparticipants.isSelected()){

            }
            if(cb_matches.isSelected()){

            }
            if(cb_matchdetails.isSelected()){

            }
            if(cb_schedulestation.isSelected()){

            }
            if(cb_teamrankings.isSelected()){

            }
            if(cb_allevents.isSelected()){

            }
            if(cb_allteams.isSelected()){

            }
        }
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

    public JSONArray parseAwardToJSON(List<Award> award) {
        JSONArray awards = new JSONArray();
        int i = 0;
        while (award.size() >= i){
            JSONObject obj = new JSONObject();
            obj.put("award_key", award.get(i).getAwardsID());
            obj.put("award_name", award.get(i).getAwardID());
            obj.put("team_key", award.get(i).getTeamId());
            obj.put("reciever_name", award.get(i).getRecieverNam());
            obj.put("award_desc", award.get(i).getAwardNamAdd());
            awards.add(obj);
        }
        i++;
        return awards;
    }

}
