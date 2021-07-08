package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
            list.add(Integer.parseInt(addField.getText()));
            updateList(list, textArea);
        });
        removeButton.setOnMouseClicked(event -> {
            list.remove(Integer.parseInt(removeField.getText()));
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
