package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoticeController implements Initializable {

    //public Stage noticeWindow;
    @FXML
    public BorderPane borderPane;
    @FXML
    public Button closeButton;
    @FXML
    public Region positive;
    @FXML
    public Region negative;
    @FXML
    Label titleText;
    @FXML
    Label bodyText;
    @FXML
    Label authorText;

    public void noticeController() {
    }

    @FXML
    void removeNotice() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleText.setText("This is a sample title.");
        bodyText.setText("sample body");
        authorText.setText("@shbmtewari");

    }
}
