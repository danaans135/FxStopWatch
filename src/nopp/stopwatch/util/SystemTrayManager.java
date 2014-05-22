package nopp.stopwatch.util;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import javax.swing.JPopupMenu;


public class SystemTrayManager {
    private static SystemTrayManager sInstance = new SystemTrayManager();
    private TrayIcon mStopWatchAppTrayIcon;

    public static SystemTrayManager getInstance() {
        return sInstance;
    }

    public void init() throws AWTException {
        mStopWatchAppTrayIcon = createTrayIcon();
        SystemTray.getSystemTray().add(mStopWatchAppTrayIcon);

    }

    private TrayIcon createTrayIcon() {
        CustomTrayIcon icon = new CustomTrayIcon(ImageUtil.getImage(ImageUtil.IMG_OVAL_RED));

        ShowAction showAction = new ShowAction();
        icon.setAction(showAction);
        JPopupMenu jpopup = new JPopupMenu();
        jpopup.add(showAction);
        jpopup.addSeparator();
        jpopup.add(new ExitAction());
        icon.setJPopupMenu(jpopup);
        return icon;
    }

    public void displayMessage(String caption, String text,
            MessageType messageType) {
        mStopWatchAppTrayIcon.displayMessage(caption, text, messageType);
    }

}
