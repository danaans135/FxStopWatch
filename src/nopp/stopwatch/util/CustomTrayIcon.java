package nopp.stopwatch.util;

import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.Action;
import javax.swing.JPopupMenu;

public class CustomTrayIcon extends TrayIcon {

    private static class CustomTrayIconMouseAdapter extends MouseAdapter {
        private final CustomTrayIcon mCustomTrayIcon;

        public CustomTrayIconMouseAdapter(CustomTrayIcon customTrayIcon) {
            mCustomTrayIcon = customTrayIcon;
        }

        public void mouseReleased(MouseEvent e) {
            if (!e.isPopupTrigger()) {
                if (mCustomTrayIcon.mAction != null) {
                    mCustomTrayIcon.mAction.actionPerformed(new ActionEvent(this, 0, null));
                }
            }
            if (mCustomTrayIcon.mJpopup != null && e.isPopupTrigger()) {
                mCustomTrayIcon.mJpopup.setLocation(e.getX(), e.getY());
                mCustomTrayIcon.mJpopup.setInvoker(mCustomTrayIcon.mJpopup);
                mCustomTrayIcon.mJpopup.setVisible(true);
            }
        }
    }

    private JPopupMenu mJpopup;
    private MouseAdapter mAdapter;
    private Action mAction;

    public CustomTrayIcon(Image image, String tooltip, PopupMenu popup) {
        super(image, tooltip, popup);
        addMouseListener(new CustomTrayIconMouseAdapter(this));
    }

    public CustomTrayIcon(Image image, String tooltip) {
        super(image, tooltip);
        addMouseListener(new CustomTrayIconMouseAdapter(this));
    }

    public CustomTrayIcon(Image image) {
        super(image);
        addMouseListener(new CustomTrayIconMouseAdapter(this));
    }
    
    public void setJPopupMenu(JPopupMenu jpopup) {
        mJpopup = jpopup;
        setPopupMenu(null);
        initJPopupMenu();
    }

    private void initJPopupMenu() {
//        if (mAdapter == null) {
//            mAdapter = new CustomTrayIconMouseAdapter(this);
//            addMouseListener(mAdapter);
//        }
    }

    public void setAction(Action action) {
        mAction = action;
    }

}
