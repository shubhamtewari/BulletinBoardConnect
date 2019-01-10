package controllers;

import api.OpenWeatherMapJSONDataRetriever;
import core.CustomerStructure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import models.BoardModel;
import models.NoticeModel;
import models.PollModel;

public class BoardController implements Initializable {

    private BoardModel boardModel;//the model
    //private NoticeInputWindowController noticeInputWindowController;//window to input notice data
    //private PollInputWindowController pollInputWindowController;//window to input poll data
    private int iterator;//for iterating through fxml loaders for poll and notices

    private FXMLLoader fxmlLoaderNoticeWindow;//the high priority notice window

    private int combinedNoticeWidth;//the total width of all the notices
    private File fileCurrentFocused;//the board file that is currently being worked on

    private ArrayList<FXMLLoader> fxmlLoaderArrayList;//storing fxml loaders

    //constructor
    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
        fxmlLoaderArrayList = new ArrayList<>();
        combinedNoticeWidth = 20;//the padding initial
    }

    @FXML
    FlowPane flowPaneNotices;
    @FXML
    BorderPane borderPane;
    @FXML
    MenuItem menuItemLoad;
    @FXML
    HBox hBoxWidgetBar;

    //ESSENTIAL METHODS>>>>>>>>>>>>>>
    String getWeatherData(api.WeatherDataRetriever weatherDataRetriever, String string)throws Exception {
        return weatherDataRetriever.setupConn(string).toString();
    }
    //<<<<<<<<<<<<<<<ESSENTIAL METHODS END

    //insert menu options MVC listeners begin>>>>>>>>>>>>>>>>>>>
    @FXML
    void onInsertTextNotice() {
        //if flow pane is full
        if(combinedNoticeWidth+300>flowPaneNotices.getWidth()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Overflow");
            alert.setContentText("Board Full!! Your notice is in Queue.");
            alert.showAndWait();
            return;
        }

        //create and show notice input window and wait
        NoticeInputWindowController noticeInputWindowController = new NoticeInputWindowController();
        noticeInputWindowController.initNoticeInputWindow();
        noticeInputWindowController.showWindowAndWait();

        //if noticeInputWindowController.buttonInsertNotice pressed
        if(noticeInputWindowController.isShowNotice()) {
            //create notice and display
            fxmlLoaderArrayList.add(new FXMLLoader(getClass().getResource("/noticelayout.fxml")));
            fxmlLoaderArrayList.get(iterator).setControllerFactory(param -> new NoticeController(new NoticeModel()));
            try {
                flowPaneNotices.getChildren().add(fxmlLoaderArrayList.get(iterator).load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            NoticeController noticeController = fxmlLoaderArrayList.get(iterator).getController();
            noticeController.populateFields(noticeInputWindowController.getArrayNoticeInformation());

            iterator++;

            combinedNoticeWidth += 300 + 10;
            //System.out.println(flowPaneNotices.getWidth() + "=" + combinedNoticeWidth);
        }
    }

    @FXML
    void onInsertImageNotice() {

    }

    @FXML
    void onInsertPoll() throws IOException{
        PollInputWindowController pollInputWindowController = new PollInputWindowController();
        pollInputWindowController.initPollInputDataWindow();
        pollInputWindowController.showStageAndWait();

        //on poll entries added and buttonInsertPoll clicked
        if(pollInputWindowController.isShowPoll()) {
            fxmlLoaderArrayList.add(new FXMLLoader(getClass().getResource("/polllayout.fxml")));
            fxmlLoaderArrayList.get(iterator).setControllerFactory(event -> new PollController(new PollModel()));
            flowPaneNotices.getChildren().add(fxmlLoaderArrayList.get(iterator).load());
            PollController pollController = fxmlLoaderArrayList.get(iterator).getController();
            pollController.populateFields(pollInputWindowController.pollInformation);//add data from the poll input window input

            //for next notice/poll
            iterator++;
        }

    }

    @FXML
    void onInsertHighPriorityNotice() {
        fxmlLoaderNoticeWindow = new FXMLLoader(getClass().getResource("/highprioritynotice.fxml"));
        Stage stageHighPriorityNoticeWindow = new Stage();
        try {
            stageHighPriorityNoticeWindow.setScene(new Scene(fxmlLoaderNoticeWindow.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageHighPriorityNoticeWindow.show();
    }

    public void OnAddTimeDateDayWidget(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoaderTimeDateDay = new FXMLLoader(getClass().getResource("/datewidgetlayout.fxml"));
        hBoxWidgetBar.getChildren().add(fxmlLoaderTimeDateDay.load());
    }

    @FXML
    void OnAddWeatherWidget() {
        WeatherInputStageController weatherInputStageController = new WeatherInputStageController();
        weatherInputStageController.setUpUI();
        try {
            System.out.println(getWeatherData(new OpenWeatherMapJSONDataRetriever(), weatherInputStageController.information));
        }catch (Exception e) {
            System.out.println("Wrong Input!!");
            //e.printStackTrace();
        }
    }
    //insert menu options MVC listeners end<<<<<<<<<<<<<<<<<<<<<<<<

    //file menu option MVC listeners begin>>>>>>>>>>>>>>>>>>>>>>>>>.
    @FXML
    void onSaveAsBoard() throws IOException {
        CustomerStructure customerStructure = new CustomerStructure("hey");
        customerStructure.setAdministrator(true);

        FileChooser fileChooser = new FileChooser();
        fileCurrentFocused = fileChooser.showSaveDialog(null);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCurrentFocused);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);;
        try {
            objectOutputStream.writeObject(customerStructure);
        }catch (IOException e) { } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
        menuItemLoad.setDisable(false);
        System.out.println(fileCurrentFocused.getAbsolutePath());
    }

    @FXML
    void onSaveBoard() throws IOException {
        CustomerStructure customerStructure = new CustomerStructure("test");
        FileOutputStream fileOutputStream = new FileOutputStream(fileCurrentFocused);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);;
        try {
            objectOutputStream.writeObject(customerStructure);
        }catch (IOException e) { } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
        System.out.println(fileCurrentFocused.getAbsolutePath());

    }

    @FXML
    void onLoadBoard() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        System.out.println(selectedFile.getAbsolutePath());
    }

    @FXML
    void onClose() {
        Stage stage = (Stage)borderPane.getScene().getWindow();
        stage.close();
    }
    //file menu MVC listeners end<<<<<<<<<<<<<<<<<<<


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //flow pane
        flowPaneNotices = new FlowPane();
        flowPaneNotices.setOrientation(Orientation.VERTICAL);
        flowPaneNotices.setHgap(10);
        flowPaneNotices.setVgap(10);
        flowPaneNotices.setPadding(new Insets(10));

        //menu items/file menu
        menuItemLoad.setDisable(true);

        //set flow pane as center
        borderPane.setCenter(flowPaneNotices);
    }

}

