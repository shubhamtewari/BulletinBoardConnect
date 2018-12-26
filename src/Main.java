import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/layout/bulletinboard.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setHeight(850);
        primaryStage.setWidth(1050);
        primaryStage.setScene(new Scene(root,400,700));
        primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);

    }
}
