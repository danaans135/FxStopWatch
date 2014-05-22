package nopp.stopwatch.util;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import nopp.stopwatch.StopWatchAppModel;

import javafx.application.Platform;

public class StopWatch {

    private static final int DEFAULT_PERIOD = 10;

    private Timer mCurTimer;
    private long mStartTime;
    private long mElapsedTime;
    private int mPeriod;

    private StopWatchListener mListener;

    public StopWatch() {
        this(DEFAULT_PERIOD);
    }

    public StopWatch(int period) {
        mPeriod = period;
        reset();
    }

    public void start() {
        mStartTime = System.currentTimeMillis() - mElapsedTime;
        mCurTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        long oldElaps = mElapsedTime;
                        mElapsedTime = System.currentTimeMillis() - mStartTime;
                        List<String> notifyList = StopWatchAppModel.getInstance().getNotifyTimeList();
                        for (String s : notifyList) {
                            long t = Integer.parseInt(s)*1000;
                            if (oldElaps < t && t < mElapsedTime) {
                                mListener.onNotifyTime(s);
                            }
                        }
                        if (mListener != null) mListener.onTimer(mElapsedTime);
                    }
                });
            }
        };
        mCurTimer.scheduleAtFixedRate(task , 0, mPeriod);
    }

    public void stop() {
        mElapsedTime = System.currentTimeMillis() - mStartTime;
        mCurTimer.cancel();
        mCurTimer = null;
    }

//    public abstract void onTimer(long elapsedTime);

//    public abstract void onNotifyTime(String notifyTime);

    public boolean isRunning() {
        return mCurTimer != null;
    }

    public void reset() {
        mStartTime = System.currentTimeMillis();
        mElapsedTime = 0;
    }

    public String getElapsedTimeStr() {
        String str = String.format("%d.%02d", mElapsedTime/1000, mElapsedTime%1000/10);
        return str;
    }

    public void addStopWatchListener(StopWatchListener l) {
        mListener = l;
        
    }

}
