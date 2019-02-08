package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SmallErrorDialogController {

    private Stage stage;
    private Scene scene;
    private VBox vBox;

    static final String ERROR = "Error";
    static final String INFO = "Information";
    static final String DIALOG = "Dialog";

    private Label labelMessage;
    private Button buttonClick;

    public SmallErrorDialogController(final String type, String message, String buttonText) {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20));
        stage.setTitle(type);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);

        labelMessage = new Label();
        buttonClick = new Button();

        labelMessage.setText(message);

        vBox.getChildren().addAll(labelMessage, buttonClick);

        buttonClick.setText(buttonText);
        buttonClick.setOnMouseClicked(event -> stage.close());
    }

    public void showDialogAndWait() {
        stage.showAndWait();
    }
}
