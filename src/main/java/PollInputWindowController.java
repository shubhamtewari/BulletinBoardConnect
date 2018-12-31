import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PollInputWindowController {

    Stage stage;
    Scene scene;
    VBox vBox;
    TextArea inputPollQuestion;
    VBox pollEntriesList;

    HBox pollEntry1;
    HBox pollEntry2;
    HBox pollEntry3;
    HBox pollEntry4;

    TextField question1;
    ColorPicker colorQuestion1;
    TextField question2;
    ColorPicker colorQuestion2;
    TextField question3;
    ColorPicker colorQuestion3;
    TextField question4;
    ColorPicker colorQuestion4;

    Button insertPoll;

    public PollInputWindowController() {
        stage = new Stage();
        stage.setTitle("Insert Poll");
        vBox = new VBox();
        scene = new Scene(vBox);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);

        inputPollQuestion = new TextArea();
        inputPollQuestion.setPrefColumnCount(25);
        inputPollQuestion.setPrefRowCount(4);
        inputPollQuestion.setText("Sample Qustion");
        inputPollQuestion.selectAll();

        insertPoll = new Button("Insert Poll");

        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        pollEntriesList = new VBox();
        pollEntriesList.setAlignment(Pos.CENTER);
        pollEntriesList.setSpacing(5);

        pollEntry1 = new HBox();
        pollEntry2 = new HBox();
        pollEntry3 = new HBox();
        pollEntry4 = new HBox();


        question1 = new TextField();
        question1.setPromptText("Left Extreme");
        question2 = new TextField();
        question2.setPromptText("Median");
        question3 = new TextField();
        question3.setPromptText("Right Extreme");
        question4 = new TextField();
        question4.setPromptText("Other Option");


        colorQuestion1 = new ColorPicker();
        colorQuestion2 = new ColorPicker();
        colorQuestion3 = new ColorPicker();
        colorQuestion4 = new ColorPicker();

        //question1.setPrefWidth(vBox.getWidth()-colorQuestion1.getWidth());


        pollEntry1.setAlignment(Pos.CENTER);
        pollEntry2.setAlignment(Pos.CENTER);
        pollEntry3.setAlignment(Pos.CENTER);
        pollEntry4.setAlignment(Pos.CENTER);

        pollEntry1.getChildren().addAll(question1,colorQuestion1);
        pollEntry2.getChildren().addAll(question2,colorQuestion2);
        pollEntry3.getChildren().addAll(question3,colorQuestion3);
        pollEntry4.getChildren().addAll(question4,colorQuestion4);

        pollEntriesList.getChildren().addAll(pollEntry1,pollEntry2,pollEntry3,pollEntry4);

        vBox.getChildren().addAll(inputPollQuestion,pollEntriesList,insertPoll);
        stage.showAndWait();
    }
}
