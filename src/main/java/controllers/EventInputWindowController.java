package controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EventInputWindowController {
    Stage stage;
    Scene scene;
    VBox vBox;
    HBox hBox;
    VBox vBoxBodyE;
    VBox vBoxBodyS;
    HBox hBoxCheckBox;
    Label labelStart;
    Label labelEnd;
    TextField textFieldEventName;
    TextArea textAreaEventDetails;
    CheckBox checkBoxStatusOngoing;
    CheckBox checkBoxStatusComing;
    DatePicker datePickerStart;
    DatePicker datePickerEnd;

    Button buttonAddEvent;

    String information[];

    String status;
    boolean canClose;
    boolean validClose;
    boolean hasDetails;

    public EventInputWindowController() {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        hBox = new HBox();
        hBoxCheckBox = new HBox();
        vBoxBodyS = new VBox();
        vBoxBodyE = new VBox();
        labelStart  = new Label("Start Date");
        labelEnd = new Label("End Date");
        textFieldEventName = new TextField();
        textAreaEventDetails = new TextArea("Event Details");
        checkBoxStatusOngoing = new CheckBox("Ongoing");
        checkBoxStatusComing = new CheckBox("Upcoming");
        datePickerEnd = new DatePicker();
        datePickerStart = new DatePicker();
        buttonAddEvent = new Button("Add Event");

        information = new String[5];
        canClose = false;
        validClose = false;
        status = "Upcoming";

        addListeners();
        populateWindow();
    }

    public void populateWindow() {
        textAreaEventDetails.selectAll();
        textFieldEventName.setPromptText("Event Name");
        checkBoxStatusComing.setSelected(true);

        vBoxBodyS.setAlignment(Pos.CENTER);
        vBoxBodyE.setAlignment(Pos.CENTER);
        vBoxBodyE.setSpacing(5);
        vBoxBodyS.setSpacing(5);
        vBoxBodyE.setPadding(new Insets(5));
        vBoxBodyS.setPadding(new Insets(5));

        vBoxBodyS.getChildren().addAll(labelStart, datePickerStart);
        vBoxBodyE.getChildren().addAll(labelEnd, datePickerEnd);

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(5));

        hBox.getChildren().addAll(vBoxBodyS, vBoxBodyE);

        hBoxCheckBox.setPadding(new Insets(5));
        hBoxCheckBox.setAlignment(Pos.CENTER);
        hBoxCheckBox.setSpacing(8);

        hBoxCheckBox.getChildren().addAll(checkBoxStatusComing, checkBoxStatusOngoing);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(textFieldEventName, textAreaEventDetails, hBoxCheckBox, hBox, buttonAddEvent);

        stage.setScene(scene);
        stage.setTitle("Add Event");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void addListeners() {
        checkBoxStatusComing.setOnMouseClicked(e -> {
            checkBoxStatusOngoing.setSelected(!checkBoxStatusComing.isSelected());
            status = "Upcoming";
        });

        checkBoxStatusOngoing.setOnMouseClicked(e -> {
            checkBoxStatusComing.setSelected(!checkBoxStatusOngoing.isSelected());
            status = "Ongoing";
        });

        buttonAddEvent.setOnMouseClicked(e -> {
            if(!textAreaEventDetails.getText().equals("")) {
                hasDetails = true;
            }
            if(textFieldEventName.getText().equals("")) {
                SmallErrorDialogController error = new SmallErrorDialogController(SmallErrorDialogController.ERROR, "Enter the event name!", "Okay");
                error.showDialogAndWait();
                return;
            }

            information[0] = textFieldEventName.getText();
            information[1] = textAreaEventDetails.getText();
            information[2] = status;
            information[3] = datePickerStart.getEditor().getText();
            information[4] = datePickerEnd.getEditor().getText();

            validClose = true;

            stage.close();
        });
    }
}
