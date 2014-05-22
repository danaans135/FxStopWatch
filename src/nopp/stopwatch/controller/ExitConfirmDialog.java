package nopp.stopwatch.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ExitConfirmDialog extends Stage {
    public static final int YES = 1;

    public static final int NO = 2;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label messageLabel;

    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;


    @FXML
    void onActionNoButton(ActionEvent event) {
        mResult = NO;
        hide();
    }

    @FXML
    void onActionYesButton(ActionEvent event) {
        mResult = YES;
        hide();
    }

    @FXML
    void initialize() {
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file 'ExitConfirmDialog.fxml'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'ExitConfirmDialog.fxml'.";
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'ExitConfirmDialog.fxml'.";

    }
    
    private int mResult;
    
    public ExitConfirmDialog(Window owner) {
        super(StageStyle.UTILITY);
//        try {
            initOwner(owner);
            initModality(Modality.WINDOW_MODAL);
            setScene(createScene());
            setTitle("確認");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private Scene createScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExitConfirmDialog.fxml"));
        fxmlLoader.setController(this);
        Scene scene;
        try { 
            scene = new Scene((Parent)fxmlLoader.load());
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        } 

//        return scene;
//        RimlessFrame rf = new RimlessFrame(new Group());
        return scene;
    }

    private Scene createScene1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExitConfirmDialog.fxml"));
        fxmlLoader.setController(this);
        Scene scene;
        try { 
            scene = new Scene((Parent)fxmlLoader.load());
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        } 

        return scene;
        
    }
    
    public int getResult() {
        return mResult;
    }
}

