package nopp.stopwatch.util;

public interface StopWatchListener {

    void onTimer(long elapsedTime);

    void onNotifyTime(String s);

}
