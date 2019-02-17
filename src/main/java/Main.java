import controllers.BulletinBoxController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.BulletinBoxModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bulletinboxlayout.fxml"));
        //get size of screen
        Rectangle2D rectangle2D = Screen.getPrimary().getVisualBounds();
        //set stage to screen size
        primaryStage.setHeight(rectangle2D.getHeight());
        primaryStage.setWidth(rectangle2D.getWidth());
        //resisable false
        primaryStage.setResizable(false);

        loader.setControllerFactory(s -> new BulletinBoxController(new BulletinBoxModel()));

        primaryStage.setScene(new Scene(loader.load(),400,700));
        primaryStage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface)");
        primaryStage.show();
        }

    public static void main(String[] args) { launch(args); }
}
