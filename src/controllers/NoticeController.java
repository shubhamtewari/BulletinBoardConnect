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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoticeController implements Initializable {

    public Stage noticeWindow;
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public Button closeButton;
    @FXML
    public Region positive;
    @FXML
    public Region negative;
    double xoffset;
    double yoffset;

    public void noticeController() {
    }


    @FXML
    public void closeNotice(ActionEvent event) {
        Stage e = (Stage)((Node)event.getSource()).getScene().getWindow();
        System.out.println(e.getY());
        e.close();
    }

    public void setOffset(MouseEvent event) {
        Stage e = (Stage)((Node)event.getSource()).getScene().getWindow();
        xoffset = event.getScreenX() - e.getX();
        yoffset = event.getScreenY() - e.getY();
        System.out.println(xoffset+", "+yoffset);
    }


    public void dragWindow(MouseEvent event) {
        Stage e = (Stage)((Node)event.getSource()).getScene().getWindow();
        e.setX(event.getScreenX() - xoffset);
        e.setY(event.getScreenY() - yoffset);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeButton = new Button();
        positive = new Region();
        negative = new Region();









        closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }
}
