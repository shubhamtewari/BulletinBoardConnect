import api.OpenWeatherMapJSONDataRetriever;
import controllers.BoardController;
import models.BoardModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bulletinboard.fxml"));
        primaryStage.setTitle("Board 1.0");
        primaryStage.setHeight(700);
        primaryStage.setWidth(1050);

        loader.setControllerFactory(s -> new BoardController(new BoardModel()));

        primaryStage.setScene(new Scene(loader.load(),400,700));
        primaryStage.show();
        }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String zip = sc.nextLine();
        //OpenWeatherMapJSONDataRetriever openWeatherMapJSONDataRetriever = new OpenWeatherMapJSONDataRetriever();
        //System.out.println("This is \n"+openWeatherMapJSONDataRetriever.setupConn(zip));
        launch(args);

    }
}
