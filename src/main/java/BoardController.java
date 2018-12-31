import core.BoardStruct;
import core.PollInputWindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    BoardModel boardModel;//the model for our controller
    NoticeInputDataWindow noticeInputDataWindow;//to refer to the window to open to insert notice
    PollInputWindowController pollInputWindowController;//to rever to the window to take poll input
    int iterator;

    ArrayList<FXMLLoader> fxmlLoaderArrayList;

    BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
        fxmlLoaderArrayList = new ArrayList<>();
    }

    @FXML
    FlowPane flowPaneNotices;

    @FXML
    BorderPane borderPane;

    @FXML
    void onInsertNotice() {
        //create and show notice input window
        noticeInputDataWindow = new NoticeInputDataWindow();
        noticeInputDataWindow.addMouseCickListenerOnButton();
        noticeInputDataWindow.getStage().showAndWait();

        //add to values data structure
        boardModel.addNoticeToStructure(iterator,noticeInputDataWindow.noticeInformation[0],
        noticeInputDataWindow.noticeInformation[1],
        noticeInputDataWindow.noticeInformation[2]);

        //create notice and display
        fxmlLoaderArrayList.add(new FXMLLoader(getClass().getResource("/noticelayout.fxml")));
        try {
            flowPaneNotices.getChildren().add(fxmlLoaderArrayList.get(iterator).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        NoticeController noticeController = fxmlLoaderArrayList.get(iterator).getController();
        noticeController.titleText.setText(noticeInputDataWindow.noticeInformation[0]);
        noticeController.bodyText.setText(noticeInputDataWindow.noticeInformation[1]);
        noticeController.authorText.setText("@"+noticeInputDataWindow.noticeInformation[2].replace(" ","").toLowerCase());
        //test
        System.out.print(boardModel.boardStructure.getPresentNotices().get(0).getBody());
        iterator++;
    }

    @FXML
    void onInsertPoll() {
        pollInputWindowController = new PollInputWindowController();
    }

    /**
     * if the current notice overflows the ui, check before adding
     * @param notice the notice to be added
     * @return true
     */
    boolean isOverloadingUI(BorderPane notice) {
        if(notice.getLayoutX()+notice.getWidth()>(borderPane.getWidth()-20))
            return false;
        else
            return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //flow pane
        flowPaneNotices = new FlowPane();
        flowPaneNotices.setOrientation(Orientation.VERTICAL);
        flowPaneNotices.setHgap(10);
        flowPaneNotices.setVgap(10);
        flowPaneNotices.setPadding(new Insets(10));

        //set flow pane as center
        borderPane.setCenter(flowPaneNotices);
    }
}

