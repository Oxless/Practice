package sample;

public class Node {

    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node node) {
        this.value = node.value;
        this.next = node.next;
    }

}
