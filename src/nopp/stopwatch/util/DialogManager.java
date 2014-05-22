package nopp.stopwatch.util;

import java.io.IOException;
import java.util.logging.Logger;

import nopp.stopwatch.controller.NotifyTimeListDialog;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class DialogManager {

    private static Stage sDialog;

//    public static void showDialog(Window window, Parent root) {
////        try {
////            FXMLLoader loader = new FXMLLoader(DialogManager.class.getResource("NotifyTimeListDialog.fxml"));
////            loader.load();
////            Parent root = loader.getRoot();
//            Scene scene = new Scene(root);
//            Stage dialog = new Stage(StageStyle.UTILITY);
//            dialog.setScene(scene);
//            dialog.initOwner(window);
//            dialog.initModality(Modality.WINDOW_MODAL);
//            dialog.showAndWait();
//            //���X�g�ƒǉ��E�폜�{�^��������
//            //�������b���͂���
//            //�ʒm���X�g�ɒǉ�
////        } catch (IOException e) {
////            // TODO �����������ꂽ catch �u���b�N
////            e.printStackTrace();
////        }
//        
//    }

    public static void showNotifyTimeListDialog(Window owner) {
//        try {
            if (sDialog == null) {
//                FXMLLoader loader = new FXMLLoader(DialogManager.class.getResource(
//                        "/nopp/stopwatch/controller/NotifyTimeListDialog.fxml"));
//                loader.load();
//                Parent root = loader.getRoot();
//                NotifyTimeListDialog controller = loader.getController();
                NotifyTimeListDialog root = new NotifyTimeListDialog();
                Logger.getGlobal().info("new stage.");
                sDialog = new Stage(StageStyle.UTILITY);
                sDialog.setScene(new Scene(root));
                sDialog.initOwner(owner);
                sDialog.initModality(Modality.NONE);
                sDialog.setTitle("通知設定");
            }
            if (!sDialog.isShowing()) {
                sDialog.showAndWait();
            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void hideNotifyTimeListDialog() {
        sDialog.hide();
    }

    public static boolean isShowingNotifyTimeListDialog() {
        if (sDialog == null) return false;
        return sDialog.isShowing();
    }

}
