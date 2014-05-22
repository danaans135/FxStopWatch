package nopp.stopwatch.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static final int IMG_OVAL_RED = 0;
    public static final int IMG_OVAL_GREEN = 1;
    public static final int IMG_OVAL_ORANGE = 2;

    private static Image[] images;
    
    static {
        images = new Image[100];
        loadImage();
    }

    public static void loadImage() {
        images[IMG_OVAL_RED] = createOval(Color.red);
        images[IMG_OVAL_GREEN] = createOval(Color.green);
        images[IMG_OVAL_ORANGE] = createOval(Color.orange);
    }

    public static Image getImage(int i) {
         return images[i];
    }

    private static Image createOval(Color color) {
        Image img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D)img.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(color);
        graphics.fillOval(0, 0, 16, 16);
        return img;
    }

}
