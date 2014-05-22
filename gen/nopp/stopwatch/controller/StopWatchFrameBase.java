package nopp.stopwatch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class StopWatchFrameBase extends AnchorPane {

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected URL location;

    @FXML
    protected Button closeButton;

    @FXML
    protected Button helpButton;

    @FXML
    protected Button hideButton;

    @FXML
    protected StopWatchPane stopWatchPane;


    @FXML
    protected void onActionCloseButton(ActionEvent event) {
    }

    @FXML
    protected void onActionHelpButton(ActionEvent event) {
    }

    @FXML
    protected void onActionHideButton(ActionEvent event) {
    }

    @FXML
    protected void onMouseClicked(MouseEvent event) {
    }

    @FXML
    protected void onMouseDragged(MouseEvent event) {
    }

    @FXML
    protected void onMousePressed(MouseEvent event) {
    }

    @FXML
    protected void onMouseReleased(MouseEvent event) {
    }

    @FXML
    protected void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'StopWatchFrame.fxml'.";
        assert helpButton != null : "fx:id=\"helpButton\" was not injected: check your FXML file 'StopWatchFrame.fxml'.";
        assert hideButton != null : "fx:id=\"hideButton\" was not injected: check your FXML file 'StopWatchFrame.fxml'.";
        assert stopWatchPane != null : "fx:id=\"stopWatchPane\" was not injected: check your FXML file 'StopWatchFrame.fxml'.";


    }

}
