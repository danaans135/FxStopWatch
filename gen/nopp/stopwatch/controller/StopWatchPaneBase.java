package nopp.stopwatch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class StopWatchPaneBase extends AnchorPane {

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected URL location;

    @FXML
    protected AnchorPane StopWatchPane;

    @FXML
    protected Button notifyButton;

    @FXML
    protected Button resetButton;

    @FXML
    protected Button startButton;

    @FXML
    protected TextField timeTextField;


    @FXML
    protected void onClickNotifyButton(ActionEvent event) {
    }

    @FXML
    protected void onClickResetButton(ActionEvent event) {
    }

    @FXML
    protected void onClickStartButton(ActionEvent event) {
    }

    @FXML
    protected void initialize() {
        assert StopWatchPane != null : "fx:id=\"StopWatchPane\" was not injected: check your FXML file 'StopWatchPane.fxml'.";
        assert notifyButton != null : "fx:id=\"notifyButton\" was not injected: check your FXML file 'StopWatchPane.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'StopWatchPane.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'StopWatchPane.fxml'.";
        assert timeTextField != null : "fx:id=\"timeTextField\" was not injected: check your FXML file 'StopWatchPane.fxml'.";


    }

}


