package nopp.stopwatch;


import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.stage.Stage;
import nopp.stopwatch.util.SystemTrayManager;

public class StopWatchApp extends BaseApp {
    private static final Logger log = Logger.getLogger(StopWatchApp.class.getName());
    private static final boolean SHOW_ON_START = true;

    private static StopWatchApp sInstance = null;
    
    private StopWatchStage mStopwatchStage;
    
    public static StopWatchApp getInstance() {
        assert sInstance != null;
        return sInstance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sInstance  = this;

        // メインウィンドウ作成
        mStopwatchStage = new StopWatchStage(primaryStage);
        
        Platform.setImplicitExit(false);
        
        // システムトレイにアイコンを追加
        SystemTrayManager.getInstance().init();
        
        if (SHOW_ON_START) {
            mStopwatchStage.show();
        }
    }

    @Override
    public void stop() throws Exception {
        log.finest("called");
    }

    public StopWatchStage getStopwatchStage() {
        return mStopwatchStage;
    }

}

