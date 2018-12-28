package controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Admin {

    Stage adminStage;
    Scene scene;
    BorderPane borderPane;
    VBox toolbar;
    javafx.scene.control.Button addDefaultNotice;

    int flag;

    Admin() {
        adminStage = new Stage();
        borderPane = new BorderPane();
        scene = new Scene(borderPane,400,400);

        flag = 0;

        adminStage.setScene(scene);
        adminStage.initModality(Modality.APPLICATION_MODAL);
        adminStage.show();

        toolbar = new VBox();
        addDefaultNotice = new Button("Add Default Notice");

        toolbar.getChildren().add(addDefaultNotice);
        borderPane.setLeft(toolbar);

        }
}
