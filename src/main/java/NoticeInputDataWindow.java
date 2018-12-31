import core.Notice;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class NoticeInputDataWindow {
    private Stage stage;
    private VBox vBox;
    private Scene scene;

    private TextField noticeTitleInput;
    private TextArea noticeBodyInput;
    private TextField noticeAuthorInput;

    private Button insertNoticeButton;


    String noticeInformation[];

    NoticeInputDataWindow() {
        stage = new Stage();

        stage.setTitle("Add Notice");
        stage.initModality(Modality.APPLICATION_MODAL);

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,20,20,20));

        scene = new Scene(vBox);

        stage.setScene(scene);

        //iterator = 0;
        //fxmlLoaderArrayList = new ArrayList<FXMLLoader>();

        noticeAuthorInput = new TextField();
        noticeTitleInput = new TextField();
        noticeBodyInput = new TextArea();

        noticeInformation = new String[3];

        //set as per the length of a short summary
        noticeBodyInput.setPrefColumnCount(25);
        noticeBodyInput.setPrefRowCount(18);

        //hint text
        noticeTitleInput.setPromptText("Enter Title Here");
        noticeTitleInput.setText("Sample Title");
        noticeTitleInput.selectAll();

        noticeAuthorInput.setPromptText("Enter Your Name");
        //noticeAuthorInput.setText("Sample Author Name");
        //noticeAuthorInput.selectAll();

        noticeBodyInput.setPromptText("Write Your Notice Here");
        noticeBodyInput.setWrapText(true);
        //noticeBodyInput.setText("Sample Notice Body\n" + "Sample Next Line");
        //noticeBodyInput.selectAll();

        insertNoticeButton = new Button("Insert Notice");
        insertNoticeButton.setCursor(Cursor.HAND);

        vBox.getChildren().addAll(noticeTitleInput,noticeBodyInput,noticeAuthorInput,insertNoticeButton);


    }

    void addMouseCickListenerOnButton() {
        insertNoticeButton.setOnMouseClicked(e -> {
        noticeInformation[0] = noticeTitleInput.getText();
        noticeInformation[1] = noticeBodyInput.getText();
        noticeInformation[2] = noticeAuthorInput.getText();
        stage.close();
        });
    }

    public Stage getStage() {
        return stage;
    }

    public VBox getvBox() {
        return vBox;
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getNoticeTitleInput() {
        return noticeTitleInput;
    }

    public TextArea getNoticeBodyInput() {
        return noticeBodyInput;
    }

    public TextField getNoticeAuthorInput() {
        return noticeAuthorInput;
    }

    public Button getInsertNoticeButton() {
        return insertNoticeButton;
    }
}
