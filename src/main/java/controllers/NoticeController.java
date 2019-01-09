package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public NoticeController(NoticeModel noticeModel) {
        this.noticeModel = noticeModel;
    }

    void populateFields(String[] information) {
        labelTitleText.setText(information[0]);
        labelBodyText.setText(information[1]);
        labelAuthorText.setText("@" +information[2].replace(" ", "").toLowerCase());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borderPane.setMaxWidth(300);
        borderPane.setMinWidth(300);
        borderPane.setPrefWidth(300);
    }

    NoticeModel getNoticeModel() {
        return noticeModel;
    }
}
