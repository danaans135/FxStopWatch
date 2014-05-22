package nopp.stopwatch.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import org.markdown4j.Markdown4jProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HelpWindow extends HelpWindowBase {
    private static final int PADDING_LEFT = 4;
    private static final Logger log = Logger.getLogger(HelpWindow.class.getName());
    private static HelpWindow sInstance = new HelpWindow();
    
    private boolean mEnteredFrame = false;
    private int mState;
    private double mPressX;
    private double mPressY;
    private double mPressScreenX;
    private double mPressScreenY;
    private int mPressState;
    private double mPressWidth;

    public static HelpWindow getInstance() {
        return sInstance ;
    }

    public HelpWindow() {
        super();
        initStyle(StageStyle.TRANSPARENT);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelpWindow.fxml"));
        fxmlLoader.setController(this);
        Parent root;
        try { 
            root = (Parent)fxmlLoader.load();
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        }
        Scene scene = new Scene(root);
        scene.setFill(null);
        setScene(scene);
    }

    @Override
    protected void onActionCloseButton(ActionEvent event) {
        log.finest("called");
        hide();
    }

//    @Override
//    protected void onMouseEnteredBorder(MouseEvent event) {
//        log.finest("called");
//    }

    @Override
    protected void onMousePressedFrame(MouseEvent event) {
        log.finest("called");
        mPressX = event.getSceneX();
        mPressY = event.getSceneY();
        mPressScreenX = event.getScreenX();
        mPressScreenY = event.getScreenY();
        mPressWidth = getWidth();
        mPressState = mState;
    }

    @Override
    protected void onMouseEnteredFrame(MouseEvent event) {
        log.finest("called");
        mEnteredFrame  = true;
//        this.getScene().setCursor(Cursor.DEFAULT);
    }

    @Override
    protected void onMouseExitedFrame(MouseEvent event) {
        log.finest("called");
        mEnteredFrame = false;
    }

    @Override
    protected void onMouseDraggedFrame(MouseEvent event) {
        log.finest("called");
        Window window = getScene().getWindow();
        switch (mPressState) {
        case 0:
            window.setX(event.getScreenX()-mPressX);
            window.setY(event.getScreenY()-mPressY);
            break;

        case 1:
            setWidth(mPressWidth + mPressScreenX - event.getScreenX());
            setX(event.getScreenX()-mPressX);
            break;
        case 2:
            setWidth(mPressWidth - mPressScreenX + event.getScreenX());
            break;
            
        default:
            break;
        }
    }

    @Override
    protected void onMouseMovedFrame(MouseEvent event) {
        log.finest("called");
        if (event.getSceneX() < PADDING_LEFT) {
            mState = 1;
            getScene().setCursor(Cursor.H_RESIZE);
        } else if (getWidth() - PADDING_LEFT < event.getSceneX()) {
            mState = 2;
            getScene().setCursor(Cursor.H_RESIZE);
        } else {
            mState = 0;
            getScene().setCursor(Cursor.DEFAULT);
        }
    }

    @Override
    protected void initialize() {
        super.initialize();
        final WebEngine engine = webView.getEngine();
//        String urlStr = getClass().getResource("/nopp/stopwatch/res/html/2013-06-25-vb_net_code_std.html").toExternalForm();
        String urlStr = getClass().getResource("/nopp/stopwatch/res/html/help.markdown").toExternalForm();
        String html = "";
        try {
            html = new Markdown4jProcessor().process(getClass().getResourceAsStream("/nopp/stopwatch/res/html/help.markdown"));
            log.finest("html="+html);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        engine.load(urlStr);
        engine.loadContent(html);
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> ov, State oldState,
                    State newState) {
                treeView.getRoot().setValue(engine.getTitle());
                Document doc = engine.getDocument();
                NodeList nodeList = doc.getElementsByTagName("h1");
                log.finest("nodeList.getLength()="+nodeList.getLength());
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element elem = (Element) nodeList.item(i);
                    log.finest(elem.getAttribute("id"));
                    treeView.getRoot().getChildren().add(new TreeItem<String>(elem.getAttribute("id")));
                    
                }
            }
        });
        TreeItem<String> treeroot = new TreeItem<String>();
        treeView.setRoot(treeroot);
    }

}
