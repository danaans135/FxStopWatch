package nopp.stopwatch.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RimlessFrame extends Scene {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    private Parent mLoaded;


    @FXML
    void onMouseDraggedFrame(MouseEvent event) {
    }

    @FXML
    void onMouseEnteredFrame(MouseEvent event) {
    }

    @FXML
    void onMouseExitedFrame(MouseEvent event) {
    }

    @FXML
    void onMouseMovedFrame(MouseEvent event) {
    }

    @FXML
    void onMousePressedFrame(MouseEvent event) {
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'RimlessFrame.fxml'.";
        AnchorPane.setLeftAnchor(getRoot(), 0.0);
        AnchorPane.setRightAnchor(getRoot(), 0.0);
        rootPane.getChildren().add(getRoot());


    }

    public RimlessFrame(Parent root) {
        super(root);
//        initStyle(StageStyle.TRANSPARENT);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RimlessFrame.fxml"));
        loader.setController(this);
        try {
            mLoaded = (Parent)loader.load();
            setRoot(mLoaded);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
