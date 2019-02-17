package controllers;

import core.EventStructure;
import core.NoticeStructure;
import core.PollStructure;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailsWindowController {
    Stage stage;
    Scene scene;

    VBox vBox;
    Label labelDetails;
    Button buttonDelete;
    TextArea textArea;
    String deleteID;
    boolean delete;

    public DetailsWindowController() {
        stage = new Stage();
        delete = false;
        deleteID = "none";
        textArea = new TextArea();
        textArea.setEditable(false);
        stage.setTitle("Details");
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(30));
        vBox.setMinHeight(400);
        vBox.setMinWidth(400);
        scene = new Scene(vBox);
        stage.setScene(scene);
        labelDetails = new Label();
        buttonDelete = new Button("Delete");
        vBox.getChildren().addAll(textArea, buttonDelete);
    }

    void populate(NoticeStructure noticeStructure){
        stage.setTitle(noticeStructure.getNoticeTitle());
        String details = "ID:\n"+ noticeStructure.getNoticeTimeStamp()+
                "\n\nTITLE:\n"+
                noticeStructure.getNoticeTitle()+
                "\n\nBODY:\n"+
                noticeStructure.getNoticeBody()+
                "\n\nAUTHOR:\n"+
                noticeStructure.getNoticeCustomer().getName()+
                "\n\nDATE:\n"+
                noticeStructure.getNoticeDate()+
                "\n\nPOSITIVE VOTES:\n"+
                noticeStructure.getPositiveVotes()+
                "\n\nNEGATIVE VOTES:\n"+
                noticeStructure.getNegativeVotes();
        textArea.setText(details);
        buttonDelete.setOnMouseClicked(e -> {
            delete = true;
            deleteID = noticeStructure.getNoticeTimeStamp()+"";
            stage.close();
        });
        stage.showAndWait();
    }

    void populate(EventStructure eventStructure){
        stage.setTitle(eventStructure.getEventName());
        String details = "ID:\n"+ eventStructure.getEventId()+
                "\n\nDATE:\n"+
                eventStructure.getLocalDate()+
                "\n\nNAME:\n"+
                eventStructure.getEventName()+
                "\n\nDETAILS:\n"+
                eventStructure.getEventDetails()+
                "\n\nSTATUS:\n"+
                eventStructure.getEventStatus()+
                "\n\nSTART DATE:\n"+
                eventStructure.getEventStartDate()+
                "\n\nEND DATE:\n"+
                eventStructure.getEventEndDate();
        textArea.setText(details);
        buttonDelete.setOnMouseClicked(e -> {
            delete = true;
            deleteID = eventStructure.getEventId()+"";
            stage.close();
        });
        stage.showAndWait();
    }

    void populate(PollStructure pollStructure){
        stage.setTitle(pollStructure.getPollQuestion());
        String details = "ID:\n"+ pollStructure.getPollTimeStamp()+
                "\n\nDATE:\n"+ pollStructure.getPollDate()+
                "\n\nQUESTION:\n"+ pollStructure.getPollQuestion()+
                "\n\nNO OF OPTIONS:\n"+ pollStructure.getNumberOfOptions();
        for(int i = 0;i<pollStructure.getNumberOfOptions();i++)
            details = details + "\n\nPOLL OPTION "+(i+1)+":\n"+pollStructure.getPollOptions().get(i)+
                    "\n\nPOLL OPTION "+(i+1)+" VOTES:\n"+pollStructure.getPollOptionsVote().get(i);
        details = details+"\n\nAUTHOR:\n"+pollStructure.getCustomer().getName();
        textArea.setText(details);
        buttonDelete.setOnMouseClicked(e -> {
            delete = true;
            deleteID = pollStructure.getPollTimeStamp()+"";
            stage.close();
        });
        stage.showAndWait();
    }
}
