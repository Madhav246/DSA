class MyLinkedList {
    Node head;
    int length;

    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index >= length) {
            return -1;
        }

        int counter = 0;
        Node current = head;

        while (counter < index) {
            counter++;
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
        } else {
            Node current = head;
            Node newNode = new Node(val);

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            length++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        
        if (index == 0) {
            addAtHead(val);
        } else {
            int counter = 1;
            Node previous = head;

            while (counter < index) {
                previous = previous.next;
                counter++;
            }

            Node newNode = new Node(val);
            Node current = previous.next;
            previous.next = newNode;
            newNode.next = current;

            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        }

        if (index == 0) {
            head = head.next;
            length--;
        } else {
            int counter = 0;
            Node previous = head;

            while (counter < index - 1) {
                counter++;
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            length--;
        }
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
