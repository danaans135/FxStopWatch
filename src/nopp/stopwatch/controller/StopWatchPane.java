package nopp.stopwatch.controller;

import java.awt.TrayIcon.MessageType;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import nopp.stopwatch.StopWatchAppModel;
import nopp.stopwatch.util.DialogManager;
import nopp.stopwatch.util.StopWatch;
import nopp.stopwatch.util.StopWatchListener;
import nopp.stopwatch.util.SystemTrayManager;


public class StopWatchPane extends StopWatchPaneBase implements StopWatchListener {

    private static Image sStartImage = new Image(StopWatchPane.class.getResourceAsStream("start.png"));
    private static Image sStopImage = new Image(StopWatchPane.class.getResourceAsStream("stop.png"));

    public StopWatchPane() {
        super();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StopWatchPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try { 
            fxmlLoader.load();
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        } 
    }

    private void showElapsedTime() {
        timeTextField.setText(StopWatchAppModel.getInstance().getStopWatch().getElapsedTimeStr());
    }

    @Override
    protected void onClickNotifyButton(ActionEvent event) {
        if (!DialogManager.isShowingNotifyTimeListDialog()) {
            DialogManager.showNotifyTimeListDialog(getScene().getWindow());
        } else {
            DialogManager.hideNotifyTimeListDialog();
        }
    }

    @Override
    protected void onClickResetButton(ActionEvent event) {
        StopWatch stopWatch = StopWatchAppModel.getInstance().getStopWatch();
        if (!stopWatch.isRunning()) {
            stopWatch.reset();
            showElapsedTime();
        }
    }

    @Override
    protected void onClickStartButton(ActionEvent event) {
        StopWatch stopWatch = StopWatchAppModel.getInstance().getStopWatch();
        if (stopWatch.isRunning()) {
            stopWatch.stop();
            startButton.setText("スタート");
            ((ImageView)startButton.getGraphic()).setImage(sStartImage);
            resetButton.setDisable(false);
            showElapsedTime();
        } else {
            startButton.setText("ストップ");
            ((ImageView)startButton.getGraphic()).setImage(sStopImage);
            resetButton.setDisable(true);
            stopWatch.start();
        }
    }

    @Override
    protected void initialize() {
        super.initialize();

        StopWatchAppModel.getInstance().getStopWatch().addStopWatchListener(this);
        showElapsedTime();
    }

    @Override
    public void onTimer(long elapsedTime) {
        showElapsedTime();
        
    }

    @Override
    public void onNotifyTime(String notifyTime) {
        SystemTrayManager.getInstance().displayMessage(
                "通知", "時間です。\n"+notifyTime, MessageType.INFO);
    }

}
