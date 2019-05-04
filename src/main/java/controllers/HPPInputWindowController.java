package controllers;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.File;


public class HPPInputWindowController {
    private Stage stage;
    private Scene scene;
    private VBox vBox;
    private FileChooser fileChooser;
    ImageView imageView;
    private Button buttonSelectImage;
    private Button buttonInsertImageNotice;
    private TextField textFieldTitleText;
    private TextField textFieldAuthorText;
    private TextField textFieldCaptionText;
    private String information[];
    boolean validClose;
    File fileImage;
    Button buttonShowImage;
    Stage parentStage;

    public HPPInputWindowController(Stage parentStage) {
        this.parentStage = parentStage;
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        fileChooser = new FileChooser();
        textFieldTitleText = new TextField();
        textFieldCaptionText = new TextField();
        textFieldAuthorText = new TextField();
        buttonSelectImage = new Button("Select Image");
        buttonShowImage = new Button("Show Image Selected");
        imageView = new ImageView();
        buttonInsertImageNotice = new Button("Insert Image Notice");
        information = new String[4];
        validClose = false;
        fileImage = null;
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

        vBox.getChildren().addAll(textFieldTitleText, buttonSelectImage, buttonShowImage, textFieldCaptionText, textFieldAuthorText, buttonInsertImageNotice, imageView);

        buttonSelectImage.setOnMouseClicked(e -> {
            fileImage = fileChooser.showOpenDialog(null);
            information[3] = fileImage.toURI().toString();

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

        buttonShowImage.setOnMouseClicked(e -> {
            if(fileImage==null) {
                SmallErrorDialogController noImageSelected = new SmallErrorDialogController(SmallErrorDialogController.ERROR, "No image Selected:(", "Okay");
                noImageSelected.showDialogAndWait();
            }
            else {
                ImageView imageView = new ImageView();
                Stage stage = new Stage();
                VBox vBox = new VBox();
                Image image = new Image(fileImage.toURI().toString());
                Double ratio = image.getWidth()/image.getHeight();
                double vBoxHeight = parentStage.getHeight() - 100;
                double vBoxWidth = ratio*vBoxHeight;
                Scene scene = new Scene(vBox, vBoxWidth , vBoxHeight);
                stage.setMaxHeight(vBoxHeight);
                stage.setMaxWidth(vBoxWidth);
                imageView.setImage(new Image(fileImage.toURI().toString()));
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(vBoxHeight);
                vBox.getChildren().add(imageView);
                stage.setScene(scene);
                stage.show();
            }
        });
        stage.showAndWait();
    }

    public String[] getInformation() {
        return information;
    }
}
