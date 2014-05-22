package nopp.stopwatch;

import java.util.ArrayList;
import java.util.List;

import nopp.stopwatch.util.StopWatch;

public class StopWatchAppModel {

//    private class MyStopWatch extends StopWatch {
//        private MyStopWatch(int period) {
//            super(period);
//        }
//
//        @Override
//        public void onTimer(long elapsedTime) {
//            showElapsedTime();
//        }
//
//        @Override
//        public void onNotifyTime(String notifyTime) {
//            SystemTrayManager.getInstance().displayMessage(
//                    "通知", "時間です。\n"+notifyTime, MessageType.INFO);
//        }
//    }

    private static final StopWatchAppModel mInstance = new StopWatchAppModel();
    private List<String> mNotifyTimeList;

    private StopWatch mStopWatch;

    public static StopWatchAppModel getInstance() {
        return mInstance ;
    }

    public StopWatchAppModel() {
        mNotifyTimeList = new ArrayList<String>();
        mStopWatch = new StopWatch(10);
    }

    public List<String> getNotifyTimeList() {
        return mNotifyTimeList;
    }

    public void setNotifyTimeList(List<String> notifyTimeList) {
        mNotifyTimeList = notifyTimeList;
    }

    public StopWatch getStopWatch() {
        return mStopWatch;
    }

    public void setStopWatch(StopWatch stopWatch) {
        mStopWatch = stopWatch;
    }

}
