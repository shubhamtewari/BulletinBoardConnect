import com.sun.corba.se.impl.orbutil.graph.Node;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.awt.*;

public class Controller {
    @FXML
    BorderPane borderpane = new BorderPane();
    HBox hboxopinionbar = new HBox();
    @FXML
    Region positive = new Region();
    @FXML
    Region negative = new Region();
    @FXML
    javafx.scene.control.Button button = new javafx.scene.control.Button();
    @FXML
    TextField post = new TextField();
    @FXML
    TextField negt = new TextField();


    public void onClick() {
        System.out.print("tufgv");
        float pod;
        float ned;
        if(post.getText()==null||negt.getText()==null){
            pod = 1;
            ned = 1;
        }
        pod = Float.parseFloat(post.getText());
        ned = Float.parseFloat(negt.getText());
        float perpod = pod/(pod+ned)*100;
        float perned = ned/(pod+ned)*100;
        ObservableList<javafx.scene.Node> a = hboxopinionbar.getChildren();
        positive.setPrefWidth(perpod/100*borderpane.getWidth());
        negative.setPrefWidth(perned/100*borderpane.getWidth());

        button.setText("fd");
        borderpane.getWidth();
    }
}
