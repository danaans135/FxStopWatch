package nopp.stopwatch.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import nopp.stopwatch.StopWatchAppModel;


public class NotifyTimeListDialog extends NotifyTimeListDialogBase {
    private static final Logger log = Logger.getLogger(NotifyTimeListDialog.class.getName());
    
    private ObservableList<String> items = FXCollections.observableArrayList();

    public NotifyTimeListDialog() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NotifyTimeListDialog.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try { 
            fxmlLoader.load();
        } catch (IOException exception) { 
            throw new RuntimeException(exception); 
        } 
    }

    @Override
    protected void onClickCloseButton(ActionEvent event) {
        closeButton.getScene().getWindow().hide();
    }

    @Override
    protected void onClickNotifyAddButton(ActionEvent event) {
        StopWatchAppModel.getInstance().getNotifyTimeList().add(notifyTimeTextField.getText());
        //    items.add(notifyTimeTextField.getText());
        items.clear();
        items.addAll(StopWatchAppModel.getInstance().getNotifyTimeList());
    }

    @Override
    protected void onClickNotifyDeleteButton(ActionEvent event) {
        StopWatchAppModel.getInstance().getNotifyTimeList().removeAll(
                FXCollections.observableArrayList(notifyTimeList.getSelectionModel().getSelectedItems()));
        log.finest(""+StopWatchAppModel.getInstance().getNotifyTimeList());
        items.clear();
        items.addAll(StopWatchAppModel.getInstance().getNotifyTimeList());
    }

    @Override
    protected void initialize() {
        super.initialize();
        items = FXCollections.observableArrayList(StopWatchAppModel.getInstance().getNotifyTimeList());
//        items.addListener(new ListChangeListener<String>() {
//            @Override
//            public void onChanged(Change<? extends String> ch) {
//                System.out.println(ch);
//            }
//        });
        notifyTimeList.setItems(items);
    }

}
