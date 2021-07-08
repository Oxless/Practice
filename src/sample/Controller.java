package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    private Button addButton;
    private Button removeButton;
    private Button sumButton;
    private TextField addField;
    private TextField removeField;
    private TextField sumField;
    private TextArea textArea;

    public Controller(Scene root) {
        textArea = (TextArea) root.lookup("#elementsArea");
        addButton = (Button) root.lookup("#addButton");
        addField = (TextField) root.lookup("#addField");
        removeButton = (Button) root.lookup("#removeButton");
        removeField = (TextField) root.lookup("#removeField");;
        sumButton = (Button) root.lookup("#sumButton");
        sumField = (TextField) root.lookup("#sumField");
    }

    public void handle(LinkedList list) {
        addButton.setOnMouseClicked(event -> {
            String text = addField.getText();
            if(!text.matches("\\d+")) {
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                VBox vBox = new VBox();
                Label label = new Label("Вводимые данные должны быть числом");
                label.setPadding(new Insets(20));
                vBox.getChildren().addAll(label);
                stage.setScene(new Scene(vBox));
                stage.show();
                return;
            }
            list.add(Integer.parseInt(text));
            updateList(list, textArea);
        });
        removeButton.setOnMouseClicked(event -> {
            String text = removeField.getText();
            if(!text.matches("\\d+")) {
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                VBox vBox = new VBox();
                Label label = new Label("Вводимые данные должны быть числом");
                label.setPadding(new Insets(20));
                vBox.getChildren().addAll(label);
                stage.setScene(new Scene(vBox));
                stage.show();
                return;
            }
            list.remove(Integer.parseInt(text));
            updateList(list, textArea);
        });
        sumButton.setOnMouseClicked(event -> {
            sumField.setText(String.valueOf(list.sum()));
        });
    }

    private void updateList(LinkedList list, TextArea area) {
        String result = "";
        if(list.head != null) {
            Node node = new Node(list.head);
            while (node != null) {
                result += node.value + " ";
                node = node.next;
            }
        }
        area.setText(result);
    }

}
