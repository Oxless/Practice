package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Linked list");
        primaryStage.setScene(root);
        primaryStage.show();

        LinkedList list = new LinkedList();
        new Controller(root).handle(list);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
