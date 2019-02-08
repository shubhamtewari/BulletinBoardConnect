import controllers.BulletinBoxController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.BulletinBoxModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bulletinboxlayout.fxml"));
        primaryStage.setHeight(700);
        primaryStage.setWidth(1050);

        loader.setControllerFactory(s -> new BulletinBoxController(new BulletinBoxModel()));

        primaryStage.setScene(new Scene(loader.load(),400,700));
        primaryStage.setTitle("I.D.L.I v0.0.1 (Inter Departmental Linked Interface)");
        primaryStage.show();
        }

    public static void main(String[] args) { launch(args); }
}
