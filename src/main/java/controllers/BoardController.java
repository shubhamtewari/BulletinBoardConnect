package controllers;

import core.BoardStructure;
import core.CustomerStructure;
import core.NoticeStructure;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.BoardModel;
import models.NoticeModel;
import models.PollModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    private BoardModel boardModel;

    private FXMLLoader fxmlLoaderNotice;
    private FXMLLoader fxmlLoaderPoll;

    private ArrayList<NoticeController> arrayListNoticeControllers;
    private ArrayList<PollController> arrayListPollControllers;

    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
        fxmlLoaderNotice = new FXMLLoader(getClass().getResource("/noticelayout.fxml"));
        fxmlLoaderPoll = new FXMLLoader(getClass().getResource("/polllayout.fxml"));
        arrayListNoticeControllers = new ArrayList<>();
        arrayListPollControllers = new ArrayList<>();
    }

    @FXML
    FlowPane flowPane;

    //board helper methods>>>>
    //insert related methods>>>>

    /**
     * this function makes the notice and loads in on to the board
     * @param noticeModel all the information about the notice is stored here
     */
    void insertNotice(NoticeModel noticeModel) throws IOException{
        try{
            fxmlLoaderNotice.setControllerFactory(e -> new NoticeController(noticeModel));

            flowPane.getChildren().add(fxmlLoaderNotice.load());
            arrayListNoticeControllers.add(fxmlLoaderNotice.getController());

            arrayListNoticeControllers.get(arrayListNoticeControllers.size()-1).populateFields();

            boardModel.addNoticeToBoard(false, noticeModel.getNoticeStructure());
        }catch (Exception e) {
            throw e;
        }finally {
            //for reuse of the fxml loader
            fxmlLoaderNotice.setController(null);
            fxmlLoaderNotice.setRoot(null);
        }

    }

    /**
     * this will add the notice to the board
     */
    void insertTextNotice() throws IOException{
        //get input to display on notice
        NoticeInputWindowController noticeInputWindowController = new NoticeInputWindowController();
        noticeInputWindowController.initNoticeInputWindow();
        noticeInputWindowController.showWindowAndWait();

        //if noticeInputWindowController.buttonInsertNotice pressed
        if(noticeInputWindowController.isShowNotice()) {
            String info[] = noticeInputWindowController.getArrayNoticeInformation();

            NoticeModel noticeModel = new NoticeModel(info[0], info[1], new CustomerStructure(info[2]));

            insertNotice(noticeModel);
        }
    }

    void insertImageNotice() throws IOException{
        ImageNoticeInputWindowController imageNoticeInputWindowController = new ImageNoticeInputWindowController();
        imageNoticeInputWindowController.show();
        if(imageNoticeInputWindowController.validClose) {
            String info[] = imageNoticeInputWindowController.getInformation();

            NoticeModel noticeModel = new NoticeModel(info[0], info[1], info[3], new CustomerStructure(info[2]));

            insertNotice(noticeModel);
        }
    }

    void insertPoll() throws IOException{
        PollInputWindowController pollInputWindowController = new PollInputWindowController();
        pollInputWindowController.initPollInputDataWindow();
        pollInputWindowController.showStageAndWait();

        //on poll entries added and buttonInsertPoll clicked
        if(pollInputWindowController.isShowPoll()) {
            String pollInfo[] = pollInputWindowController.pollInformation;

            //the options
            String options[] = new String[pollInfo.length - 1];
            for(int i = 1;i<pollInfo.length;i++)
                options[i-1] = pollInfo[i];

            PollModel pollModel = new PollModel(pollInfo[0],options,new CustomerStructure("@anonymous"));
            fxmlLoaderPoll.setControllerFactory(event -> new PollController(pollModel));


            flowPane.getChildren().add(fxmlLoaderPoll.load());
            arrayListPollControllers.add(fxmlLoaderPoll.getController());
            arrayListPollControllers.get(arrayListPollControllers.size()-1).populateFields();//add data from the poll input window input

            boardModel.addPollToBoard(false, pollModel.getPollStructure());
        }
    }
    //insert related methods end<<<<

    void populateBoardFromBoardObject(BoardStructure boardStructure) throws IOException{
        Stage stage = (Stage)flowPane.getScene().getWindow();
        stage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface) - "+boardStructure.getBoardName());
        for(NoticeStructure n : boardStructure.getPresentNoticeStructures()) {
            NoticeModel noticeModel = new NoticeModel(n.getNoticeTitle(),n.getNoticeBody(),new CustomerStructure(n.getNoticeCustomer().getName()));
            fxmlLoaderNotice.setControllerFactory(e -> new NoticeController(noticeModel));

            flowPane.getChildren().add(fxmlLoaderNotice.load());
            arrayListNoticeControllers.add(fxmlLoaderNotice.getController());
            arrayListNoticeControllers.get(arrayListNoticeControllers.size()-1).populateFields();

            boardModel.addNoticeToBoard(false,noticeModel.getNoticeStructure());

            fxmlLoaderNotice.setController(null);
            fxmlLoaderNotice.setRoot(null);
        }
    }
    //board helper methods end<<<<

    //getter and setters>>>>
    public BoardModel getBoardModel() {
        return boardModel;
    }

    public FXMLLoader getFxmlLoaderNotice() {
        return fxmlLoaderNotice;
    }

    public FXMLLoader getFxmlLoaderPoll() {
        return fxmlLoaderPoll;
    }

    public ArrayList<NoticeController> getArrayListNoticeControllers() {
        return arrayListNoticeControllers;
    }

    public ArrayList<PollController> getArrayListPollControllers() {
        return arrayListPollControllers;
    }
    //getters and setters end<<<<

    //initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setOrientation(Orientation.VERTICAL);

    }
}
