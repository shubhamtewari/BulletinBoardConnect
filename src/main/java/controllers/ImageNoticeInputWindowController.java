package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class ImageNoticeInputWindowController {
    private Stage stage;
    private Scene scene;
    private VBox vBox;
    private FileChooser fileChooser;
    private Button buttonSelectImage;
    private Button buttonInsertImageNotice;
    private TextField textFieldTitleText;
    private TextField textFieldAuthorText;
    private TextField textFieldCaptionText;
    private String information[];
    boolean validClose;
    private File fileImage;

    public ImageNoticeInputWindowController() {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        fileChooser = new FileChooser();
        textFieldTitleText = new TextField();
        textFieldCaptionText = new TextField();
        textFieldAuthorText = new TextField();
        buttonSelectImage = new Button("Select Image");
        buttonInsertImageNotice = new Button("Insert Image Notice");
        information = new String[4];
        validClose = false;
    }

    void show() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Add Image Notice");

        textFieldAuthorText.setPromptText("Author");
        textFieldCaptionText.setPromptText("Caption");
        textFieldTitleText.setText("Sample Title");
        textFieldTitleText.setPrefColumnCount(18);
        textFieldTitleText.selectAll();
        fileChooser.setTitle("Open Image");

        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));

        vBox.getChildren().addAll(textFieldTitleText, buttonSelectImage, textFieldCaptionText, textFieldAuthorText, buttonInsertImageNotice);

        buttonSelectImage.setOnMouseClicked(e -> {
            fileImage = fileChooser.showOpenDialog(null);
            information[3] = fileImage.getAbsolutePath();
        });

        buttonInsertImageNotice.setOnMouseClicked(e -> {
            information[0] = textFieldTitleText.getText();
            information[1] = textFieldCaptionText.getText();
            information[2] = textFieldAuthorText.getText();
            if(fileImage==null) {
                SmallErrorDialogController smallErrorDialogController = new SmallErrorDialogController(SmallErrorDialogController.ERROR, "No image selected!", "Okay");
                smallErrorDialogController.showDialogAndWait();
                return;
            }
            validClose = true;
            stage.close();
        });

        stage.showAndWait();
    }

    public String[] getInformation() {
        return information;
    }
}
