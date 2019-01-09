package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class TimeDateDayWidgetController implements Initializable {
    @FXML
    private HBox hBox;
    @FXML
    private VBox vBox;
    @FXML
    private Label labelTime;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelDay;

    void formatTimeAndSet(String time) {
        time = time.substring(0, time.length()-2);
        labelTime.setText(time);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        formatTimeAndSet(LocalTime.now().toString());
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                formatTimeAndSet(LocalTime.now().toString());
                labelDate.setText(LocalDate.now().toString());
                labelDay.setText(LocalDate.now().getDayOfWeek().toString());

            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }
}
