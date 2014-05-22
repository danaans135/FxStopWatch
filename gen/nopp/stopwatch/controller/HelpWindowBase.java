package nopp.stopwatch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpWindowBase extends Stage {

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected URL location;

    @FXML
    protected Button closeButton;

    @FXML
    protected TreeView<String> treeView;

    @FXML
    protected WebView webView;


    @FXML
    protected void onActionCloseButton(ActionEvent event) {
    }

    @FXML
    protected void onMouseDraggedFrame(MouseEvent event) {
    }

    @FXML
    protected void onMouseEnteredFrame(MouseEvent event) {
    }

    @FXML
    protected void onMouseExitedFrame(MouseEvent event) {
    }

    @FXML
    protected void onMouseMovedFrame(MouseEvent event) {
    }

    @FXML
    protected void onMousePressedFrame(MouseEvent event) {
    }

    @FXML
    protected void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'HelpWindow.fxml'.";
        assert treeView != null : "fx:id=\"treeView\" was not injected: check your FXML file 'HelpWindow.fxml'.";
        assert webView != null : "fx:id=\"webView\" was not injected: check your FXML file 'HelpWindow.fxml'.";


    }

}

