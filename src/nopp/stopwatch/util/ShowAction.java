package nopp.stopwatch.util;

import javafx.application.Platform;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import nopp.stopwatch.StopWatchApp;
import nopp.stopwatch.StopWatchStage;


@SuppressWarnings("serial")
public class ShowAction extends AbstractAction {

    public ShowAction() {
        super();
        putValue(Action.NAME, "表示");
        putValue(Action.SMALL_ICON, new ImageIcon(ImageUtil.getImage(ImageUtil.IMG_OVAL_GREEN)));
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
//                StopWatchApp.getInstance().showStage();
                StopWatchStage stopwatchStage = StopWatchApp.getInstance().getStopwatchStage();
                if (!stopwatchStage.isShowing()) {
                    stopwatchStage.show();
                }
            }
        });
    }
}