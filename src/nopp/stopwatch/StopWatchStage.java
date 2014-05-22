package nopp.stopwatch;

import nopp.stopwatch.controller.StopWatchFrame;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class StopWatchStage extends Stage {

    public StopWatchStage(Stage primaryStage) {
        initOwner(primaryStage);
        initStyle(StageStyle.TRANSPARENT);
        setScene(createStopWatchScene());
        addEventHandler(WindowEvent.WINDOW_HIDING, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent ev) {
//                log.finest("WINDOW_HIDING");
            }
        });
    }

    private Scene createStopWatchScene() {
        StopWatchFrame root = new StopWatchFrame();
        Scene scene = new Scene(root);
        scene.setFill(null);
        return scene;
    }

}
