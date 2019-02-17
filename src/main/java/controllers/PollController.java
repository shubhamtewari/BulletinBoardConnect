package controllers;

import core.CustomerStructure;
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

    void populateFields() {

        //pollModel.createPoll(information[0],options, new CustomerStructure("@anonymous"));

        questionText.setText(pollModel.getPollStructure().getPollQuestion());
        switch (pollModel.getPollStructure().getNumberOfOptions()) {
            case 2:
                labelPollOption1.setText(pollModel.getPollStructure().getPollOptions().get(0));
                labelPollOption2.setText(pollModel.getPollStructure().getPollOptions().get(1));
                vBoxPollText.getChildren().remove(3);
                vBoxPollText.getChildren().remove(3);
                //vBoxPollText.getChildren().remove(3);
                //hBox3.setVisible(false);
                //hBox4.setVisible(false);
                region3.setVisible(false);
                region4.setVisible(false);
                break;
            case 3:
                labelPollOption1.setText(pollModel.getPollStructure().getPollOptions().get(0));
                labelPollOption2.setText(pollModel.getPollStructure().getPollOptions().get(1));
                labelPollOption3.setText(pollModel.getPollStructure().getPollOptions().get(2));
                vBoxPollText.getChildren().remove(4);
                //hBox4.setVisible(false);
                region4.setVisible(false);
                break;
            case 4:
                labelPollOption1.setText(pollModel.getPollStructure().getPollOptions().get(0));
                labelPollOption2.setText(pollModel.getPollStructure().getPollOptions().get(1));
                labelPollOption3.setText(pollModel.getPollStructure().getPollOptions().get(2));
                labelPollOption4.setText(pollModel.getPollStructure().getPollOptions().get(3));
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public PollModel getPollModel() {
        return pollModel;
    }
}
