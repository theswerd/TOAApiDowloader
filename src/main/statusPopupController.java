package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by SPZ Productions on 8/20/2017.
 */
public class statusPopupController implements Initializable {

    @FXML public TextArea stat_popup_textField = new TextArea();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void populateWindow(){

    }

    @FXML
    public void closeWindow(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stat_popup_textField.clear();
    }

    @FXML
    public void download(ActionEvent event){
        Main.getController().save();
    }
}
