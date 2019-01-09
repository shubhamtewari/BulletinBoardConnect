package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.NoticeModel;

public class NoticeInputWindowController {
    private NoticeModel noticeModel;

    private Stage stage;
    private VBox vBox;
    private Scene scene;

    private TextField textFieldNoticeTitleInput;
    private TextArea textAreaNoticeBodyInput;
    private TextField textFieldNoticeAuthorInput;

    private Button buttonInsertNotice;

    //make true if buttonInsertNotice is pressed
    private boolean showNotice;

    //input stored here
    private String arrayNoticeInformation[];

    NoticeInputWindowController() {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        textAreaNoticeBodyInput = new TextArea();
        textFieldNoticeTitleInput = new TextField();
        textFieldNoticeAuthorInput = new TextField();
        arrayNoticeInformation = new String[3];
        buttonInsertNotice = new Button("Insert Notice");

        showNotice = false;
    }

    void setupUI() {
        stage.setTitle("Add Notice");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,20,20,20));

        //set as per the length of a short summary
        textAreaNoticeBodyInput.setPrefColumnCount(25);
        textAreaNoticeBodyInput.setPrefRowCount(18);

        textFieldNoticeTitleInput.setPromptText("Enter Title Here");
        textFieldNoticeTitleInput.setText("Sample Title");
        textFieldNoticeTitleInput.selectAll();

        textAreaNoticeBodyInput.setPromptText("Write Your Notice Here");
        textAreaNoticeBodyInput.setWrapText(true);

        textFieldNoticeAuthorInput.setPromptText("Enter Your Name");

        buttonInsertNotice.setCursor(Cursor.HAND);

        vBox.getChildren().addAll(textFieldNoticeTitleInput, textAreaNoticeBodyInput, textFieldNoticeAuthorInput, buttonInsertNotice);
    }

    void showWindowAndWait() {
        stage.showAndWait();
    }

    void addMouseClickListenerOnInsertButton() {
        buttonInsertNotice.setOnMouseClicked(e -> {
        arrayNoticeInformation[0] = textFieldNoticeTitleInput.getText();
        arrayNoticeInformation[1] = textAreaNoticeBodyInput.getText();
        arrayNoticeInformation[2] = textFieldNoticeAuthorInput.getText();

        if(textFieldNoticeAuthorInput.getText().toString().equals(""))
            arrayNoticeInformation[2] = "anonymous";
        if(textAreaNoticeBodyInput.getText().toString().trim().equals("")) {
            //System.out.println("hi");
            SmallErrorDialogController errorNullBody = new SmallErrorDialogController(SmallErrorDialogController.ERROR, "Enter body of notice!", "Okay");
            errorNullBody.showDialogAndWait();
            return;
        }
        showNotice = true;

        stage.close();
        });
    }

    public void initNoticeInputWindow() {
        setupUI();
        addMouseClickListenerOnInsertButton();
    }

    //getter
    public boolean isShowNotice() {
        return showNotice;
    }

    public String[] getArrayNoticeInformation() {
        return arrayNoticeInformation;
    }
}
