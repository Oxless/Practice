package sample;

public class LinkedList {

        public Node head;
        public Node tail;

        public void add(int value) {
            Node temp = new Node(value, null);
            if(head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
        }

        public void remove(int value) {
            if(head == null) return;
            Node previous = null;
            Node current = new Node(head);
            while (current != null) {
                if (current.value == value) {
                    if (previous != null) {
                        previous.next = current.next;
                        if (current.next == null) {
                            tail = previous;
                        }
                    } else {
                        head = head.next;
                        if (head == null) {
                            tail = null;
                        }
                    }
                }
                previous = current;
                current = current.next;
            }
        }

        public int sum() {
            int sum = 0;
            Node node = head;
            while(node != null) {
                sum += node.value;
                node = node.next;
            }
            return sum;
        }

}
