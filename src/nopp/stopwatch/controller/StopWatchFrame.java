package nopp.stopwatch.controller;

import java.io.IOException;
import java.util.logging.Logger;

import nopp.stopwatch.util.DialogManager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class StopWatchFrame extends StopWatchFrameBase {

    private static final Logger log = Logger.getLogger(StopWatchFrame.class.getName());
    private double mPressX;
    private double mPressY;

    public StopWatchFrame() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StopWatchFrame.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try { 
            fxmlLoader.load();
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        } 
    }

    @Override
    protected void onActionHideButton(ActionEvent event) {
        closeButton.getScene().getWindow().hide();
    }

    @Override
    protected void onActionCloseButton(ActionEvent event) {
        int res = showConfirmDialog();
        if (res == ExitConfirmDialog.YES) {
            Platform.exit();
            System.exit(0);
        }
    }

    private int showConfirmDialog() {
        ExitConfirmDialog d = new ExitConfirmDialog(getScene().getWindow());
        d.showAndWait();
        return d.getResult();
    }

    @Override
    protected void onMouseDragged(MouseEvent event) {
        Window window = getScene().getWindow();
        window.setX(event.getScreenX()-mPressX);
        window.setY(event.getScreenY()-mPressY);
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
        mPressX = event.getSceneX();
        mPressY = event.getSceneY();
    }

    @Override
    protected void onMouseReleased(MouseEvent event) {
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void onActionHelpButton(ActionEvent event) {
        log.finest("called");
        HelpWindow hw = HelpWindow.getInstance();
        hw.show();
    }

}
