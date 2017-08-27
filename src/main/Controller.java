package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML public TextField tb_apikey = new TextField();
    @FXML public Button btn_auth = new Button();
    @FXML public Pane pne_auth = new Pane();
    @FXML public Label lbl_auth = new Label();
    @FXML public TextField tb_eventkey = new TextField();
    @FXML public TextField tb_location = new TextField();
    @FXML public Button btn_browse = new Button();
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



}
