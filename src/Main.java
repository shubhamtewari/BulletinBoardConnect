import core.Customer;
import core.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,400,600));
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        Customer c = new Student("svdfbdf");
        System.out.print(c.getName()+" has priviledges "+((Student) c).getLevel());
        launch(args); }
}
