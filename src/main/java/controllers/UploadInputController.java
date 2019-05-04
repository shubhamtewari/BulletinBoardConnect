package controllers;

import core.BoardStructure;
import core.NoticeStructure;
import core.WorkspaceStructure;
import database.DatabaseManipulatable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UploadInputController {
    private Stage stage;
    private Scene scene;
    private Button buttonShowDatabase;
    private Button buttonUpload;
    private Label labelStatus;
    private TextField textFieldWorkspaceName;
    private Label labelWorkspaceSelected;
    private VBox vBox;
    String workSpaceName;
    StringProperty stringPropertyWorkspace;

    boolean isValidClose;

    DatabaseManipulatable databaseManipulatable;

    public static final String BOARD = "board";
    public static final String ADMINNOTICE = "adminnotice";

    public UploadInputController() {
        stage = new Stage();
        vBox = new VBox();
        textFieldWorkspaceName = new TextField();
        workSpaceName = "none";
        buttonShowDatabase = new Button("Show Database");
        buttonUpload = new Button("Upload");
        labelStatus = new Label("Enter Workspace Name And Press Enter");
        //StringProperty stringPropertyWorkspace = new SimpleStringProperty(workSpaceName);
        labelWorkspaceSelected = new Label("Workspace selected: "+workSpaceName);
        scene = new Scene(vBox, 350, 300);

        isValidClose = false;

        setup();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void populate() {
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelStatus, textFieldWorkspaceName, labelWorkspaceSelected, buttonShowDatabase, buttonUpload);
        stage.setScene(scene);
    }

    public void setup() {
        populate();

        textFieldWorkspaceName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelWorkspaceSelected.setText("Workspace selected: "+textFieldWorkspaceName.getText());
            }
        });

        buttonUpload.setOnMouseClicked(e -> {
            workSpaceName = textFieldWorkspaceName.getText();
            if(!workSpaceName.equals("")) {
                isValidClose = true;
                stage.close();
            }
            else {
                labelWorkspaceSelected.setText("Please select a workspace");
            }
        });
    }
}
