package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import models.PollModel;

import java.net.URL;
import java.util.ResourceBundle;

public class PollController implements Initializable {
    private PollModel pollModel;

    @FXML
    BorderPane borderPane;
    @FXML
    HBox hBoxOpinion;
    @FXML
    HBox hBox1;
    @FXML
    HBox hBox2;
    @FXML
    HBox hBox3;
    @FXML
    HBox hBox4;
    @FXML
    Label labelPollOption1;
    @FXML
    Label labelPollOption2;
    @FXML
    Label labelPollOption3;
    @FXML
    Label labelPollOption4;
    @FXML
    Region region1;
    @FXML
    Region region2;
    @FXML
    Region region3;
    @FXML
    Region region4;
    @FXML
    Label questionText;
    @FXML
    VBox vBoxPollText;

    public PollController(PollModel pollModel) {
        this.pollModel = pollModel;
    }

    void populateFields(String[] information) {
        int infoLength = information.length;
        questionText.setText(information[0]);
        switch (infoLength) {
            case 3:
                labelPollOption1.setText(information[1]);
                labelPollOption2.setText(information[2]);
                vBoxPollText.getChildren().remove(2);
                vBoxPollText.getChildren().remove(3);
                region3.setVisible(false);
                region4.setVisible(false);
                break;
            case 4:
                labelPollOption1.setText(information[1]);
                labelPollOption2.setText(information[2]);
                labelPollOption3.setText(information[3]);
                hBox4.setVisible(false);
                region4.setVisible(false);
                break;
            case 5:
                labelPollOption1.setText(information[1]);
                labelPollOption2.setText(information[2]);
                labelPollOption3.setText(information[3]);
                labelPollOption4.setText(information[4]);
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
