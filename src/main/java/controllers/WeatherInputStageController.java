package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherInputStageController {
    Stage stage;
    Scene scene;
    VBox vBox;
    TextField textFieldInputData;
    Label labelError;
    Button buttonAddWeatherWidget;
    boolean canInsertWidget;
    boolean hasError;
    String information;

    public  WeatherInputStageController() {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox, 400, 300);
        textFieldInputData = new TextField();
        labelError = new Label();
        buttonAddWeatherWidget = new Button("Add Weather Widget");
        canInsertWidget = false;
        hasError = true;
    }

    void setUpUI() {
        stage.setScene(scene);
        stage.setTitle("Weather Widget Input");

        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(textFieldInputData,labelError, buttonAddWeatherWidget);

        addInsertButtonListener();

        stage.showAndWait();
    }

    void addInsertButtonListener() {
        buttonAddWeatherWidget.setOnAction(event -> {
            information = textFieldInputData.getText().toString();
            if(information.equals("")){
                SmallErrorDialogController smallErrorDialogController= new SmallErrorDialogController(SmallErrorDialogController.ERROR,"Please Enter a City!!", "Okay");
                smallErrorDialogController.showDialogAndWait();
            }
            else {
                canInsertWidget = true;
                stage.close();
            }
        });
    }

}
