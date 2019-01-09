package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PollInputWindowController {

    private Stage stage;
    private Scene scene;
    private VBox vBox;

    private TextArea textAreaInputPollQuestion;
    private VBox vboxPollEntriesList;
    private TextField arrayTextFieldPollOption[];
    private Region arrayRegionColorOption[];
    private HBox arrayHboxPollContainer[];
    private Button buttonAddPollOption;
    private Button buttonRemovePollOption;
    private HBox hboxAddRemoveContainer;
    private Button buttonInsertPoll;
    private Label labelErrorText;

    public boolean showPoll;

    private int iteratorPollOptions;
    //flags
    private boolean singleOptionOnceFlag;
    private boolean overflowFlag;

    /**
     * 0th index question text
     * rest poll options text
     */
    public String[] pollInformation;

    public PollInputWindowController() {
        stage = new Stage();
        vBox = new VBox();
        scene = new Scene(vBox);
        buttonInsertPoll = new Button("Insert Poll");
        buttonAddPollOption = new Button("+");
        buttonRemovePollOption = new Button("-");
        labelErrorText = new Label("");
        textAreaInputPollQuestion = new TextArea();
        hboxAddRemoveContainer = new HBox();
        arrayRegionColorOption = new Region[4];
        arrayTextFieldPollOption = new TextField[4];
        arrayHboxPollContainer = new HBox[4];
        vboxPollEntriesList = new VBox();
        for (int i = 0; i<4 ;i++) {
            arrayTextFieldPollOption[i] = new TextField();
        }
        for (int i = 0; i<4 ;i++) {
            arrayRegionColorOption[i] = new Region();
        }
        for (int i = 0; i<4 ;i++) {
            arrayHboxPollContainer[i] = new HBox();
        }

        iteratorPollOptions = 1;
        showPoll = false;
    }

    void setupUI() {
        stage.setTitle("Insert Poll");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);

        labelErrorText.setDisable(true);

        textAreaInputPollQuestion.setPrefColumnCount(25);
        textAreaInputPollQuestion.setPrefRowCount(4);
        textAreaInputPollQuestion.setText("Sample Question");
        textAreaInputPollQuestion.selectAll();

        //buttonRemovePollOption.setStyle("-fx-background-radius: 15; -fx-border-radius : 15; -fx-text-fill: #ffffff; -fx-background-color: #ff0000;");

        hboxAddRemoveContainer.setSpacing(8);
        hboxAddRemoveContainer.setAlignment(Pos.CENTER);
        hboxAddRemoveContainer.getChildren().addAll(buttonAddPollOption,buttonRemovePollOption);

        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);

        vboxPollEntriesList.setAlignment(Pos.TOP_CENTER);
        vboxPollEntriesList.setSpacing(5);
        vboxPollEntriesList.setMinHeight(180);

        arrayRegionColorOption[0].setStyle("-fx-background-color: #39ff14;");
        arrayRegionColorOption[1].setStyle("-fx-background-color: #fada5e;");
        arrayRegionColorOption[2].setStyle("-fx-background-color: #2e77bb;");
        arrayRegionColorOption[3].setStyle("-fx-background-color: #fd6a02;");

        for (int i = 0; i<4 ;i++) {
            arrayTextFieldPollOption[i].setPromptText("Option "+(i+1));
        }
        for (int i = 0; i<4 ;i++) {
            arrayRegionColorOption[i].setPrefWidth(20);
            arrayRegionColorOption[i].setPrefHeight(20);
        }
        for (int i = 0; i<4 ;i++) {
            arrayHboxPollContainer[i].setAlignment(Pos.CENTER);
            arrayHboxPollContainer[i].setSpacing(8);
        }
        for (int i = 0; i<4 ;i++) {
            arrayHboxPollContainer[i].getChildren().addAll(arrayTextFieldPollOption[i], arrayRegionColorOption[i]);
        }

        vboxPollEntriesList.getChildren().addAll(arrayHboxPollContainer[0], hboxAddRemoveContainer);

        vBox.getChildren().addAll(textAreaInputPollQuestion, vboxPollEntriesList,labelErrorText, buttonInsertPoll);
    }

    public void showStageAndWait() {
        stage.showAndWait();
    }

    void listenForInsertPollButtonClick() {
        buttonInsertPoll.setOnMouseClicked(event -> {
            int count = vboxPollEntriesList.getChildren().size();

            //if only one element
            if(count == 2) {
                if(overflowFlag) {
                    labelErrorText.setText(" ");
                    overflowFlag = false;
                }
                labelErrorText.setText("Atleast two options required!");
                singleOptionOnceFlag = true;
                return;
            }

            pollInformation = new String[(count)];
            pollInformation[0] = textAreaInputPollQuestion.getText();
            for (int i = 1;i<count;i++) {
                pollInformation[i] = arrayTextFieldPollOption[i-1].getText();
            }
            showPoll = true;
            stage.close();
        });
    }

    void listenForInsertPollOptionButtonClick() {
        buttonAddPollOption.setOnMouseClicked(event -> {
            if(singleOptionOnceFlag) {
                labelErrorText.setText(" ");
                singleOptionOnceFlag = false;
            }
            if(vboxPollEntriesList.getChildren().size()==5) {
                labelErrorText.setText("Only 4 options allowed!");
                overflowFlag = true;
                return;
            }

            else if(vboxPollEntriesList.getChildren().size() > 4)
                return;

            else {
                vboxPollEntriesList.getChildren().add(vboxPollEntriesList.getChildren().size()-1,arrayHboxPollContainer[iteratorPollOptions]);
                iteratorPollOptions++;
            }
        });
    }

    void listenForRemovePollOptionButtonClick() {
        buttonRemovePollOption.setOnMouseClicked(event -> {
            int count = vboxPollEntriesList.getChildren().size();
            if(overflowFlag) {
                labelErrorText.setText("");
                overflowFlag = false;
            }
            if(count == 2) {
                return;
            }
            else {
                System.out.println("running");
                vboxPollEntriesList.getChildren().remove(arrayHboxPollContainer[count-2]);
                iteratorPollOptions--;
            }
        });
    }

    public void initPollInputDataWindow() {
        setupUI();
        listenForInsertPollOptionButtonClick();
        listenForRemovePollOptionButtonClick();
        listenForInsertPollButtonClick();
    }

    //getter
    public boolean isShowPoll() {
        return showPoll;
    }
}
