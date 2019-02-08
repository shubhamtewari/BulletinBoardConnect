package controllers;

import core.CustomerStructure;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import models.NoticeModel;

import java.net.URL;
import java.util.ResourceBundle;

public class NoticeController implements Initializable {
    private NoticeModel noticeModel;

    @FXML
    BorderPane borderPane;
    @FXML
    Button closeButton;
    @FXML
    Region regionPositive;
    @FXML
    Region regionNegative;
    @FXML
    Label labelTitleText;
    @FXML
    Label labelBodyText;
    @FXML
    Label labelAuthorText;
    @FXML
    ImageView imageViewImage;
    @FXML
    VBox vBoxNoticeText;

    public NoticeController(NoticeModel noticeModel) {
        this.noticeModel = noticeModel;
    }

    void populateFields() {
        //noticeModel.createSimpleNotice(information[0],information[1],new CustomerStructure(information[2]));
        labelTitleText.setText(noticeModel.getNoticeStructure().getNoticeTitle());
        labelBodyText.setText(noticeModel.getNoticeStructure().getNoticeBody());
        labelAuthorText.setText("@" +noticeModel.getNoticeStructure().getNoticeCustomer().getName().replace(" ", "").toLowerCase());
        if(noticeModel.getNoticeStructure().getImagePath()==null){
            vBoxNoticeText.getChildren().remove(1);
        }
        else {
            imageViewImage.setFitWidth(340);
            System.out.println(noticeModel.getNoticeStructure().getImagePath());
            imageViewImage.setImage(new Image(noticeModel.getNoticeStructure().getImagePath()));
            //imageViewImage.setImage(new Image(noticeModel.getNoticeStructure().getImagePath()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borderPane.setMaxWidth(350);
        borderPane.setMinWidth(350);
        borderPane.setPrefWidth(350);
    }

    NoticeModel getNoticeModel() {
        return noticeModel;
    }
}
