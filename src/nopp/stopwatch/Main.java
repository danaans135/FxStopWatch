package nopp.stopwatch;

import java.awt.AWTException;

import javafx.application.Application;

import javax.swing.UIManager;

public class Main {

    public Main(String[] args) throws AWTException {
//        Logger.getGlobal().setLevel(Level.FINEST);
        Application.launch(StopWatchApp.class, args);
    }

    /**
     * @param args
     * @throws AWTException 
     */
    public static void main(String[] args) throws AWTException {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
        }
        new Main(args);
    }

}
