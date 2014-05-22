package nopp.stopwatch.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class NotifyTimeListDialogBase extends AnchorPane{

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected URL location;

    @FXML
    protected Button closeButton;

    @FXML
    protected Button notifyAddButton;

    @FXML
    protected Button notifyDeleteButton;

    @FXML
    protected ListView<String> notifyTimeList;

    @FXML
    protected TextField notifyTimeTextField;


    @FXML
    protected void onClickCloseButton(ActionEvent event) {
    }

    @FXML
    protected void onClickNotifyAddButton(ActionEvent event) {
    }

    @FXML
    protected void onClickNotifyDeleteButton(ActionEvent event) {
    }

    @FXML
    protected void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'NotifyTimeListDialog.fxml'.";
        assert notifyAddButton != null : "fx:id=\"notifyAddButton\" was not injected: check your FXML file 'NotifyTimeListDialog.fxml'.";
        assert notifyDeleteButton != null : "fx:id=\"notifyDeleteButton\" was not injected: check your FXML file 'NotifyTimeListDialog.fxml'.";
        assert notifyTimeList != null : "fx:id=\"notifyTimeList\" was not injected: check your FXML file 'NotifyTimeListDialog.fxml'.";
        assert notifyTimeTextField != null : "fx:id=\"notifyTimeTextField\" was not injected: check your FXML file 'NotifyTimeListDialog.fxml'.";


    }

}
