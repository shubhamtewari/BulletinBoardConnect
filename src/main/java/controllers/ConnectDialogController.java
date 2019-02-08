package controllers;

import database.DatabaseConnectable;
import database.FirebaseDatabaseConnectable;
import exceptions.DuplicateConnectionToDatabaseException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class ConnectDialogController {
    private Stage stage;
    private Scene scene;

    private VBox vBox;
    private Button buttonChooseKey;
    private Button buttonUsePreviousPath;
    private Label labelLogin;

    private FileChooser fileChooser;

    public int clickTag;
    public boolean connectDialogIsBoardOnline;

    public boolean isConnectionEstablished;
    public boolean wasDuplicateConnection;

    DatabaseConnectable databaseConnection;

    //methods start>>>>>>>>>>>>>>>>>>>>
    boolean connectToDatabase(DatabaseConnectable databaseConnection, boolean isBoardOnline, String path) throws IOException{
        try {
            databaseConnection.setupConnection(isBoardOnline, path);
        } catch (DuplicateConnectionToDatabaseException e) {
            wasDuplicateConnection = true;
            return false;
        } catch (IOException i) {
            throw i;
        } catch (Exception e) {
            System.out.println("Error establishing connection:(");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //methods end<<<<<<<<<<<<<<<<<<<<<

    public ConnectDialogController(DatabaseConnectable databaseConnection, boolean connectDialogIsBoardOnline){
            clickTag = -1;
            vBox = new VBox();
            buttonChooseKey = new Button("Choose Private Key");
            buttonUsePreviousPath = new Button("Use Previous Path");
            labelLogin = new Label("Connect to database");

            isConnectionEstablished = false;
            wasDuplicateConnection = false;

            this.databaseConnection = databaseConnection;
            this.connectDialogIsBoardOnline = connectDialogIsBoardOnline;

            fileChooser = new FileChooser();

            stage = new Stage();
            scene = new Scene(vBox, 300, 200);
            stage.setScene(scene);

            init();

            stage.showAndWait();
        }

        void populateWindow () {
            vBox.getChildren().addAll(labelLogin, buttonChooseKey, buttonUsePreviousPath);

            vBox.setPadding(new Insets(30));
            vBox.setSpacing(30);
            vBox.setAlignment(Pos.CENTER);

            stage.initModality(Modality.APPLICATION_MODAL);
        }

        void setupListeners () {
            buttonChooseKey.setOnMouseClicked(e -> {
                FileWriter fileWriter = null;
                File filePrivateKey;
                String path;
                filePrivateKey = fileChooser.showOpenDialog(null);
                path = filePrivateKey.getAbsolutePath();
                if (filePrivateKey == null) {
                    return;
                } else {
                    path = filePrivateKey.getAbsolutePath();
                    try {
                        fileWriter = new FileWriter("./keypath.txt");
                        fileWriter.write(path);
                    } catch (Exception e1) {
                        System.out.println("Invalid storage path:(");
                        e1.printStackTrace();
                    } finally {
                        try {
                            fileWriter.close();
                        } catch (IOException e1) {
                            System.out.println("Failed to close:(");
                            e1.printStackTrace();
                        }
                    }
                }

                //conenct to the database
                boolean b = false;
                try {
                    b = connectToDatabase(databaseConnection, connectDialogIsBoardOnline, path);
                } catch (IOException e1) {
                    System.out.println("Wrong file selected:{(");
                    e1.printStackTrace();
                }
                if (b) {
                    connectDialogIsBoardOnline = true;
                    isConnectionEstablished = true;
                    stage.close();
                }if(wasDuplicateConnection) {
                    stage.close();
                }
            });

            buttonUsePreviousPath.setOnMouseClicked(e -> {
                String path;
                boolean b = false;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./keypath.txt"));
                    path = bufferedReader.readLine();
                    //conenct to the database
                    b = connectToDatabase(databaseConnection, connectDialogIsBoardOnline, path);
                } catch (FileNotFoundException e1) {
                    System.out.println("No path in history. Please choose private key:(");
                    e1.printStackTrace();
                    return;
                } catch (IOException e2) {
                    SmallErrorDialogController smallErrorDialogController =
                            new SmallErrorDialogController(SmallErrorDialogController.ERROR, "Choose private key again or check internet connectivity:(", "Okay");
                    smallErrorDialogController.showDialogAndWait();
                    System.out.println("Failed to read file ./keypath.txt:(");
                    e2.printStackTrace();
                }
                if (b) {
                    connectDialogIsBoardOnline = true;
                    isConnectionEstablished = true;
                    stage.close();
                }if(wasDuplicateConnection) {
                    stage.close();
                }
            });
        }

        void init () {
            populateWindow();
            setupListeners();
        }
    }
