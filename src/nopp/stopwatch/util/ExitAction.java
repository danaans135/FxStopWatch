package nopp.stopwatch.util;

import javafx.application.Platform;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class ExitAction extends AbstractAction {
    public ExitAction() {
        super();
        putValue(Action.NAME, "終了");
        putValue(Action.SMALL_ICON, new ImageIcon(ImageUtil.getImage(ImageUtil.IMG_OVAL_ORANGE)));
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }
}