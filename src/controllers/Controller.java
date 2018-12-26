package controllers;

import com.sun.corba.se.impl.orbutil.graph.Node;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    @FXML
    Button but;


    public void createWindow() throws IOException {
        Stage noticeWindow = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.setLocation(getClass().getResource("/resources/layout/noticelayout.fxml"));
            //fxmlLoader.setController(this);
            fxmlLoader.load();
            noticeWindow.setScene(new Scene(fxmlLoader.getRoot()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        noticeWindow.initStyle(StageStyle.UNDECORATED);
        noticeWindow.show();
    }
    }

