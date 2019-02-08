package controllers;

import api.*;
import core.*;
import database.FirebaseDatabaseConnectable;
import database.FirebaseDatabaseManipulator;
import exceptions.DuplicateConnectionToDatabaseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

import models.BoardModel;
import models.BulletinBoxModel;

public class BulletinBoxController implements Initializable {
    BulletinBoxModel bulletinBoxModel;
    BoardController boardController;

    FXMLLoader fxmlLoaderBoard;//fxmlloader for the board
    private FXMLLoader fxmlLoaderNoticeWindow;//fxmlLoader for the high priority windows

    private File fileCurrentFocused;//the board file that is currently being worked on
    private DataController saverAndLoader;//interface that handles tha saving and the loading of the board data

    //for the intial board display
    VBox vBoxInitial;
    Label labelLineOneInitial;

    //if there is a board in the screen
    Boolean isboardAlive;
    //if there is a connection established to a database
    Boolean isBoardOnline;

    private database.DatabaseConnectable databaseConnection;
    private database.DatabaseManipulatable databaseManipulatable;

    //constructor
    public BulletinBoxController(BulletinBoxModel bulletinBoxModel) {
        this.bulletinBoxModel = bulletinBoxModel;
        isboardAlive = false;
        isBoardOnline = false;
        saverAndLoader = new JSONTextFileDataController();
        databaseConnection = new FirebaseDatabaseConnectable();
        databaseManipulatable = new FirebaseDatabaseManipulator();

        fxmlLoaderBoard = new FXMLLoader(getClass().getResource("/boardlayout.fxml"));
        fxmlLoaderNoticeWindow = new FXMLLoader(getClass().getResource("/highprioritynoticelayout.fxml"));

        //for the initial window
        vBoxInitial = new VBox();
        labelLineOneInitial = new Label("Go to File > Create New Board");
    }

    //fxml declaration>>>>
    @FXML
    BorderPane borderPane;
    @FXML
    MenuItem menuItemLoad;
    @FXML
    HBox hBoxWidgetBar;
    @FXML
    MenuItem menuItemInsertNotice;
    @FXML
    MenuItem menuItemInsertPoll;
    @FXML
    MenuItem menuItemWidget;
    @FXML
    MenuItem menuItemSort;
    @FXML
    MenuItem menuItemClear;
    @FXML
    MenuItem menuItemDelete;
    @FXML
    MenuItem menuItemClose;
    @FXML
    MenuItem menuItemSave;
    @FXML
    MenuItem menuItemUpload;
    @FXML
    Label labelConnectionStatus;
    @FXML
    Label labelStatusText;
    @FXML
    Region regionConnectionStatus;
    //fxml declaration end<<<<

    //methods>>>>
    /**
     * set the views that are no to be clicked on start as boolean b
     * @param b the value to be set
     */
    void setDisableOnStartViews(boolean b) {
        menuItemInsertNotice.setDisable(b);
        menuItemInsertPoll.setDisable(b);
        //menuItemWidget.setDisable(b);
        menuItemDelete.setDisable(b);
        menuItemClear.setDisable(b);
        menuItemSort.setDisable(b);
        menuItemClose.setDisable(b);
    }

    /**
    void connectToDatabase() {
        boolean connectionEstablished;
        try {
            connectionEstablished = databaseConnection.setupConnection(isBoardOnline);
        }catch (Exception e) {
            labelStatusText.setText("Error establishing connection:(");
            e.printStackTrace();
            return;
        }
        if(connectionEstablished) {
            labelStatusText.setText("Connection with database established sucessfully, Board Online:)");
            isBoardOnline = true;
            labelConnectionStatus.setText("*connected to workspace1*");
            regionConnectionStatus.setStyle("-fx-background-color:#00b300");
            setDisableConnectViews(false);

        }
        else{
            labelStatusText.setText("Already Connected:|");
        }
    }
     **/

    /**
     * disable/emable the views related to networking
     * @param b true for disable
     */
    void setDisableConnectViews(boolean b) {
        menuItemUpload.setDisable(b);
    }

    void resetBoardUI() {
        /**
         * on board close stuff : insert below
         */
        borderPane.setCenter(vBoxInitial);
        Stage stage = (Stage)borderPane.getScene().getWindow();
        //apologies for the cringe
        stage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface)");
        //disable stuff not required
        setDisableOnStartViews(true);
    }

    /**
     * closes the board
     * by setting the fxmlloader properties to null
     * and resetting the UI
     * and boardAlive flag to false
     * also other stuff
     */
    void closeBoard() {
        boardController = null;
        fxmlLoaderBoard.setController(null);
        fxmlLoaderBoard.setRoot(null);
        resetBoardUI();
        System.out.println("Board closed sucessfully:)");
        fileCurrentFocused = null;
        resetBoardUI();
        isboardAlive = false;
        setDisableOnStartViews(true);
    }

    /**
     * create a input window to take the name of board as input
     * then display it
     * @return the name entered buy the user
     */
    String createInputWindowForBoardName() {
        AtomicBoolean isClose = new AtomicBoolean(false);
        Stage stage = new Stage();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        TextField textField = new TextField("Board Name");
        Button button = new Button("Create Board");
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(textField, button);
        button.setOnMouseClicked(event -> {
            stage.close();
            isClose.set(true);
        });
        Scene scene = new Scene(vBox,300,250);
        stage.setScene(scene);
        stage.setTitle("Create Board");

        stage.showAndWait();
        if (isClose.get())
            return textField.getText();
        else
            return null;
    }
    //methods end<<<<

    //insert menu MVC listeners>>>>
    @FXML
    void onInsertTextNotice() {
        try {
            boardController.insertTextNotice();
        }catch (IOException e) {
            System.out.println("Could not insert text notice:(");
            e.printStackTrace();
        }
    }

    @FXML
    void onInsertImageNotice() {
        try {
            boardController.insertImageNotice();
        }catch (IOException e) {
            System.out.println("Could not insert image notice:(");
            e.printStackTrace();
        }
    }

    @FXML
    void onInsertPoll() {
        try {
            boardController.insertPoll();
        }catch (Exception e) {
            System.out.println("Failed to insert poll:(");
            e.printStackTrace();
            return;
        }
    }

    @FXML
    void onInsertHighPriorityNotice() {
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
        WeatherStructure weatherForCity;
        try {
            OpenWeatherMapJSONDataRetriever openWeatherMapJSONDataRetriever = new OpenWeatherMapJSONDataRetriever();
            String jsonWeatherData = openWeatherMapJSONDataRetriever.setupConn(weatherInputStageController.information);
            //convert json data to object
            weatherForCity = openWeatherMapJSONDataRetriever.convertToDeserialized(jsonWeatherData);

            for(Days a : weatherForCity.getList()) {
                System.out.println(a.getDt_txt());
                System.out.println(a.getMain().getTemp_min());
                System.out.println(a.getMain().getTemp_max());
            }

            Temperature temperature = weatherForCity.getTemperatureFrom(weatherForCity.getList(), LocalDate.now());
            Weather weather = weatherForCity.getWeatherFrom(weatherForCity.getList(), LocalDate.now());
            Wind wind = weatherForCity.getWindFrom(weatherForCity.getList(), LocalDate.now());
            System.out.println("Day 1: "+temperature.getTemp_min());
            System.out.println("Day 1 Weather: "+weather.getMain());
            System.out.println(""+weather.getDescription());
            System.out.println("Day 1 Wind Speed: "+wind.getSpeed());

            Temperature temperature1 = weatherForCity.getTemperatureFrom(weatherForCity.getList(), LocalDate.now().plusDays(1));
            Weather weather1 = weatherForCity.getWeatherFrom(weatherForCity.getList(), LocalDate.now().plusDays(1));
            Wind wind1 = weatherForCity.getWindFrom(weatherForCity.getList(), LocalDate.now().plusDays(1));
            System.out.println("Day 2: "+temperature1.getTemp_min());
            System.out.println("Day 2 Weather: "+weather1.getMain());
            System.out.println(""+weather1.getDescription());
            System.out.println("Day 2 Wind Speed: "+wind1.getSpeed());

            Temperature temperature2 = weatherForCity.getTemperatureFrom(weatherForCity.getList(), LocalDate.now().plusDays(2));
            Weather weather2 = weatherForCity.getWeatherFrom(weatherForCity.getList(), LocalDate.now().plusDays(2));
            Wind wind2 = weatherForCity.getWindFrom(weatherForCity.getList(), LocalDate.now().plusDays(2));
            System.out.println("Day 3: "+temperature2.getTemp_min());
            System.out.println("Day 3 Weather: "+weather2.getMain());
            System.out.println(""+weather2.getDescription());
            System.out.println("Day 3 Wind Speed: "+wind2.getSpeed());
        }catch (Exception e) {
            System.out.println("Something went wrong:(");
            System.out.println("Here's what happened:");
            e.printStackTrace();
        }
    }
    //insert menu options MVC listeners end<<<<

    //file menu option MVC listeners begin>>>>>
    @FXML
    void onCreateBoard() {
        Stage stage = (Stage)borderPane.getScene().getWindow();
        String string = createInputWindowForBoardName();
        if(isboardAlive) {
            closeBoard();
        }
        try {
            if(string==null) {
                throw new NullPointerException();
            }
            stage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface) - "+string);
            //load the board
            fxmlLoaderBoard.setControllerFactory(e -> new BoardController(new BoardModel(string)));
            FlowPane flowPane = (FlowPane) fxmlLoaderBoard.load();
            borderPane.setCenter(flowPane);
            boardController = fxmlLoaderBoard.getController();
            labelStatusText.setText("Board opened: "+boardController.getBoardModel().getBoardStructure().getBoardName());
        }catch (NullPointerException n){
            labelStatusText.setText("The string was null:(");
            n.printStackTrace();
        }catch (IOException i) {
            labelStatusText.setText("Error on loading of board:(");
            i.printStackTrace();
        }
        isboardAlive = true;
        //enable the views required now
        setDisableOnStartViews(false);
    }

    @FXML
    void onSaveAsBoard() {
        FileChooser fileChooser = new FileChooser();
        fileCurrentFocused = fileChooser.showSaveDialog(null);
        try {
            saverAndLoader.saveAsFile(boardController.getBoardModel().getBoardStructure(),fileCurrentFocused);
        }catch (Exception e) {
            labelStatusText.setText("Error saving as board:(");
            e.printStackTrace();
            return;
        }
        labelStatusText.setText("Board saved as successfully:) : "+boardController.getBoardModel().getBoardStructure().getBoardName());
        menuItemLoad.setDisable(false);
    }

    @FXML
    void onSaveBoard() {
        try {
            saverAndLoader.saveAsFile(boardController.getBoardModel().getBoardStructure(),fileCurrentFocused);
        }catch (Exception e) {
            System.out.println("Failed to save board:(");
            e.printStackTrace();
            return;
        }
        System.out.println("Board Saved successfully:) : "+boardController.getBoardModel().getBoardStructure().getBoardName());
    }

    @FXML
    void onLoadBoard() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        labelStatusText.setText("File loaded from:"+selectedFile.getAbsolutePath());
        BoardStructure boardStructure;
        try {
            boardStructure = (BoardStructure) saverAndLoader.loadAsObject(selectedFile);

            if(isboardAlive) {
                closeBoard();
            }

            fxmlLoaderBoard.setControllerFactory(e -> new BoardController(new BoardModel(boardStructure.getBoardName())));

            borderPane.setCenter(fxmlLoaderBoard.load());

            boardController = fxmlLoaderBoard.getController();

            boardController.populateBoardFromBoardObject(boardStructure);
            isboardAlive = true;
        }catch (Exception e) {
            labelStatusText.setText("Failed to load board:(");
            e.printStackTrace();
            return;
        }
        if(isboardAlive) {
            setDisableOnStartViews(false);
            fileCurrentFocused = selectedFile;
            labelStatusText.setText("Board opened sucessfully:) : " + boardStructure.getBoardName());
        }
    }


    @FXML
    void onClose() {
        closeBoard();
    }

    @FXML
    void onQuit() {
        //*insert save prompt here*//
        boolean isSavePromptSucessful = true;//*fix this*
        if(isSavePromptSucessful) {
            Stage stage = (Stage) borderPane.getScene().getWindow();
            stage.close();
        }
        else {}
    }
    //file menu MVC listeners end<<<<<<<<<<<<<<<<<<<

    //connect menu MVC liteners start>>>>>>>>>>>>>>>>>
    @FXML
    void onConnect() {
        ConnectDialogController connectDialogController = new ConnectDialogController((FirebaseDatabaseConnectable) databaseConnection, isBoardOnline);

        if(connectDialogController.isConnectionEstablished) {
            labelStatusText.setText("Connection with database established sucessfully, Board Online:)");
            isBoardOnline = true;
            labelConnectionStatus.setText("*connected to workspace1*");
            regionConnectionStatus.setStyle("-fx-background-color:#00b300");
            setDisableConnectViews(false);
        }
        else if(connectDialogController.wasDuplicateConnection) {
            labelStatusText.setText("Already Connected:|");
        }
    }

    @FXML
    void onUpload() {
        try {
            databaseManipulatable.testUpload(databaseConnection, boardController.getBoardModel().getBoardStructure());
        }catch (Exception e) {
            labelStatusText.setText("Test failed:(");
            e.printStackTrace();
            return;
        }
        labelStatusText.setText("Sucessfully uploaded board:)");
    }
    //file menu MVC listeners end<<<<<<<<<<<<<<<<<<<<<<

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //if no board open
        if (!isboardAlive) {
            setDisableOnStartViews(true);
        }

        if (!isBoardOnline) {
            setDisableConnectViews(true);
        }

        borderPane.setCenter(vBoxInitial);

    }

    //getters and setters>>>>
    public BulletinBoxModel getBulletinBoxModel() {
        return bulletinBoxModel;
    }
    //getters and setters end<<<<
}

