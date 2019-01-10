package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HighPriorityNoticeController implements Initializable {

    @FXML
    BorderPane borderPane;
    @FXML
    Button buttonTypeNotice;
    @FXML
    Button buttonInsertImage;
    @FXML
    Label labelOr;

    private VBox vBoxNoticeDisplay;
    private Label labelTitle;
    private Label labelBody;
    private Label labelAuthor;

    public HighPriorityNoticeController() {
        vBoxNoticeDisplay = new VBox();
        labelTitle = new Label();
        labelBody = new Label();
        labelAuthor = new Label();
    }

    void setupAndPopulateTextUI(String information[]) {
        labelTitle.setText(information[0]);
        labelBody.setText(information[1]);
        labelBody.setTextAlignment(TextAlignment.JUSTIFY);
        labelAuthor.setText("@" + information[2].replace(" ", "").toLowerCase());

        vBoxNoticeDisplay.getChildren().addAll(labelTitle, labelBody, labelAuthor);
        vBoxNoticeDisplay.setAlignment(Pos.CENTER);
        vBoxNoticeDisplay.setSpacing(15);

        Stage stage = (Stage)labelOr.getScene().getWindow();
        stage.setAlwaysOnTop(true);

        borderPane.setCenter(vBoxNoticeDisplay);
    }

    @FXML
    void onTypeNotice() {
        NoticeInputWindowController noticeInputWindowController = new NoticeInputWindowController();
        noticeInputWindowController.setupUI();
        noticeInputWindowController.addMouseClickListenerOnInsertButton();
        noticeInputWindowController.showWindowAndWait();

        if(noticeInputWindowController.isShowNotice()) {
            setupAndPopulateTextUI(noticeInputWindowController.getArrayNoticeInformation());
        }
    }

    @FXML
    void onInsertImage() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

