package controllers;

import core.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.BoardModel;
import models.EventModel;
import models.NoticeModel;
import models.PollModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    private BoardModel boardModel;

    private FXMLLoader fxmlLoaderNotice;
    private FXMLLoader fxmlLoaderPoll;

    private ArrayList<NoticeController> arrayListNoticeControllers;
    private ArrayList<PollController> arrayListPollControllers;

    TableColumn<NoticeStructure, String> tableColumnNoticesTitle;
    TableColumn<NoticeStructure, String> tableColumnNoticesDate;
    TableColumn<NoticeStructure, Integer> tableColumnNoticesID;

    TableColumn<PollStructure, String> tableColumnPollsTitle;
    TableColumn<PollStructure, String> tableColumnPollsDate;
    TableColumn<PollStructure, Integer> tableColumnPollsID;

    TableColumn<EventStructure, String> tableColumnEventsTitle;
    TableColumn<EventStructure, Integer> tableColumnEventsID;
    TableColumn<EventStructure, String> tableColumnEventsDate;

    @FXML
    HBox hBoxBoard;
    @FXML
    TableView<NoticeStructure> tableViewNotices;
    @FXML
    TableView<PollStructure> tableViewPolls;
    @FXML
    TableView<EventStructure> tableViewEvents;
    @FXML
    VBox vBoxNotices;
    @FXML
    VBox vBoxPolls;
    @FXML
    VBox vBoxEvents;
    @FXML
    AnchorPane anchorPane;

    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
        fxmlLoaderNotice = new FXMLLoader(getClass().getResource("/noticelayout.fxml"));
        fxmlLoaderPoll = new FXMLLoader(getClass().getResource("/polllayout.fxml"));
        arrayListNoticeControllers = new ArrayList<>();
        arrayListPollControllers = new ArrayList<>();

        tableColumnNoticesTitle = new TableColumn<>("Title");
        tableColumnNoticesDate = new TableColumn<>("Date");
        tableColumnNoticesID = new TableColumn<>("S.No.");

        tableColumnPollsTitle = new TableColumn<>("Question");
        tableColumnPollsDate = new TableColumn<>("Date");
        tableColumnPollsID = new TableColumn<>("S.No.");

        tableColumnEventsTitle = new TableColumn<>("Title");
        tableColumnEventsDate = new TableColumn<>("Date");
        tableColumnEventsID = new TableColumn<>("S.No.");
    }

    //board helper methods>>>>
    //insert related methods>>>>

    /**
     * this function makes the notice and loads in on to the board
     * @param noticeModel all the information about the notice is stored here

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
    */

    /**
     * this will add the notice to the board

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
     */

    /*
    void insertImageNotice() throws IOException{
        ImageNoticeInputWindowController imageNoticeInputWindowController = new ImageNoticeInputWindowController();
        imageNoticeInputWindowController.show();
        if(imageNoticeInputWindowController.canClose) {
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
    */

    void insertTextNotice() throws Exception{
        NoticeInputWindowController noticeInputWindowController = new NoticeInputWindowController();
        noticeInputWindowController.initNoticeInputWindow();
        noticeInputWindowController.showWindowAndWait();

        //if noticeInputWindowController.buttonInsertNotice pressed
        if(noticeInputWindowController.isShowNotice()) {
            String info[] = noticeInputWindowController.getArrayNoticeInformation();

            NoticeModel noticeModel = new NoticeModel(info[0], info[1], new CustomerStructure(info[2]));

            boardModel.addNoticeToBoard(noticeModel.getNoticeStructure());

            tableViewNotices.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentNoticeStructures()));
        }
    }

    void insertImageNotice() throws Exception {

    }

    void insertPoll() throws Exception {
        PollInputWindowController pollInputWindowController = new PollInputWindowController();
        pollInputWindowController.initPollInputDataWindow();
        pollInputWindowController.showStageAndWait();

        //on poll entries added and buttonInsertPoll clicked
        if(pollInputWindowController.isShowPoll()) {
            String pollInfo[] = pollInputWindowController.pollInformation;

            //the options
            String options[] = new String[pollInfo.length - 1];
            for (int i = 1; i < pollInfo.length; i++)
                options[i - 1] = pollInfo[i];

            PollModel pollModel = new PollModel(pollInfo[0], options, new CustomerStructure("@anonymous"));
            boardModel.addPollToBoard(pollModel.getPollStructure());
            tableViewPolls.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentPollStructures()));
        }
    }

    void insertEvent()throws Exception {
        EventInputWindowController eventInputWindowController = new EventInputWindowController();

        if(eventInputWindowController.validClose) {
            String eventInfo[] = eventInputWindowController.information;
            for(int i = 0; i< eventInfo.length; i++) {
                if(eventInfo[i].equals("")) {
                    eventInfo[i] = null;
                }
            }

            EventModel eventModel = new EventModel(eventInfo[0], eventInfo[1], eventInfo[3], eventInfo[4], eventInfo[2]);
            boardModel.addEventToBoard(eventModel.getEventStructure());
            tableViewEvents.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentEventStructures()));
        }
    }
    void populateBoardFromBoardObject(BoardStructure boardStructure) throws Exception {
        Stage stage = (Stage)hBoxBoard.getScene().getWindow();
        stage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface) - "+boardStructure.getBoardName());
        tableViewNotices.setItems(FXCollections.observableArrayList(boardStructure.getPresentNoticeStructures()));
        tableViewPolls.setItems(FXCollections.observableArrayList(boardStructure.getPresentPollStructures()));
        tableViewEvents.setItems(FXCollections.observableArrayList(boardStructure.getPresentEventStructures()));
    }

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

        hBoxBoard.setPrefWidth(anchorPane.getPrefWidth());
        hBoxBoard.setPrefHeight(anchorPane.getPrefHeight());

        tableColumnNoticesID.setCellValueFactory(new PropertyValueFactory<>("noticeId"));
        tableColumnNoticesTitle.setCellValueFactory(new PropertyValueFactory<>("noticeTitle"));
        tableColumnNoticesDate.setCellValueFactory(new PropertyValueFactory<>("noticeDate"));
        tableViewNotices.getColumns().addAll(tableColumnNoticesID, tableColumnNoticesTitle, tableColumnNoticesDate);

        tableColumnPollsID.setCellValueFactory(new PropertyValueFactory<>("pollTimeStamp"));
        tableColumnPollsTitle.setCellValueFactory(new PropertyValueFactory<>("pollQuestion"));
        tableColumnPollsDate.setCellValueFactory(new PropertyValueFactory<>("pollDate"));
        tableViewPolls.getColumns().addAll(tableColumnPollsID, tableColumnPollsTitle, tableColumnPollsDate);

        tableColumnEventsID.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        tableColumnEventsTitle.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        tableColumnEventsDate.setCellValueFactory(new PropertyValueFactory<>("localDate"));
        tableViewEvents.getColumns().addAll(tableColumnEventsID, tableColumnEventsTitle, tableColumnEventsDate);

        tableViewNotices.setRowFactory(new Callback<TableView<NoticeStructure>, TableRow<NoticeStructure>>() {
            @Override
            public TableRow<NoticeStructure> call(TableView<NoticeStructure> param) {
                TableRow<NoticeStructure> row = new TableRow<>();
                row.setOnMouseClicked(e -> {
                    if(e.getClickCount()==2){
                        NoticeStructure noticeStructure = row.getItem();
                        System.out.println(noticeStructure.getNoticeTitle());
                        DetailsWindowController detailsWindowController =
                                new DetailsWindowController();
                        detailsWindowController.populate(noticeStructure);
                        //remove the notice
                        if(detailsWindowController.delete) {
                            boardModel.removeNoticeFromBoard(detailsWindowController.deleteID);
                            detailsWindowController.delete = false;
                            tableViewNotices.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentNoticeStructures()));
                        }
                    }
                });
                return row;
            }
        });

        tableViewPolls.setRowFactory(new Callback<TableView<PollStructure>, TableRow<PollStructure>>() {
            @Override
            public TableRow<PollStructure> call(TableView<PollStructure> param) {
                TableRow<PollStructure> row = new TableRow<>();
                row.setOnMouseClicked(e -> {
                    if(e.getClickCount()==2){
                        PollStructure pollStructure = row.getItem();
                        DetailsWindowController detailsWindowController =
                                new DetailsWindowController();
                        detailsWindowController.populate(pollStructure);
                        //remove the notice
                        if(detailsWindowController.delete) {
                            boardModel.removePollFromBoard(detailsWindowController.deleteID);
                            detailsWindowController.delete = false;
                            tableViewPolls.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentPollStructures()));
                        }
                    }
                });
                return row;
            }
        });

        tableViewEvents.setRowFactory(new Callback<TableView<EventStructure>, TableRow<EventStructure>>() {
            @Override
            public TableRow<EventStructure> call(TableView<EventStructure> param) {
                TableRow<EventStructure> row = new TableRow<>();
                row.setOnMouseClicked(e -> {
                    if(e.getClickCount()==2){
                        EventStructure eventStructure = row.getItem();
                        DetailsWindowController detailsWindowController =
                                new DetailsWindowController();
                        detailsWindowController.populate(eventStructure);
                        //remove the notice
                        if(detailsWindowController.delete) {
                            boardModel.removeEventFromBoard(detailsWindowController.deleteID);
                            detailsWindowController.delete = false;
                            tableViewEvents.setItems(FXCollections.observableArrayList(boardModel.getBoardStructure().getPresentEventStructures()));
                        }
                    }
                });
                return row;
            }
        });
    }
}
