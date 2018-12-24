package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXTestClass {

    public void createAndShow() throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("resources/sample.fxml"));

        Stage window = new Stage();
        window.setTitle("Test Stage");
        window.setResizable(false);
        window.setHeight(250);
        window.setWidth(400);

        StackPane layout = new StackPane();
        Scene sc = new Scene(layout, 400, 250);

        window.setScene(sc);
        window.showAndWait();
    }
}
