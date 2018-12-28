package controllers;

import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import core.Notice;
import javafx.collections.ObservableList;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    ArrayList<FXMLLoader> fxmlLoaderArrayList;//to load the various notices
    int iterator;//to wrk on the next loader
    int flagForCommand;

    FlowPane flowPane;

    boolean isOverloadingUI(BorderPane notice) {
        //System.out.println(gridPane.getWidth()+" = "+borderPane.getWidth());
        if(notice.getLayoutX()+notice.getWidth()>(borderPane.getWidth()-20))
            return false;
        else
            return true;
    }

    /**
     * add notice to the bulletin board(to the border pane's flowpane(center)
     */
    void addNotice() {
        fxmlLoaderArrayList.add(new FXMLLoader());

        fxmlLoaderArrayList.get(iterator).setLocation(getClass().getResource("/resources/layout/noticelayout.fxml"));

        Parent root = null;
        try {
            root = fxmlLoaderArrayList.get(iterator).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BorderPane bp = fxmlLoaderArrayList.get(iterator).getRoot();

        if(isOverloadingUI(bp)) {
            //System.out.print("hi");
        }

        flowPane.getChildren().add(root);
        NoticeController notice = fxmlLoaderArrayList.get(iterator).getController();
        if(iterator==1)
            notice.bodyText.setText("d\n\n\n\n\n\n\n\n\n\n\n");
        else notice.bodyText.setText("hghh "+iterator);

        iterator++;
    }

    @FXML
    Button draggableBut;
    @FXML
    BorderPane borderPane;
    @FXML
    BorderPane notice;
    @FXML
    HBox hbox;

    @FXML
    public void createWindow() throws IOException {
        //make and display admin window
        Admin adminWindow = new Admin();

        //on clicking the add default notice button call the add notice function
        adminWindow.addDefaultNotice.setOnMouseClicked(event -> {
            addNotice();
        });



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxmlLoaderArrayList = new ArrayList<>();

        //flow pane
        flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(10));



        //set flow pane as center
        borderPane.setCenter(flowPane);

        iterator = 0;
    }
}

