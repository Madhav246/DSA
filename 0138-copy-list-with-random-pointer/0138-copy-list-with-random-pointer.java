/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;

        //1st : Make copy of each node
        //Link them together.

        while (iter != null) {
            front = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;

            iter = front;
        }

        //2nd : Assign random pointers to the copy nodes :
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        //3rd : Restore the original list
        //Extract the copy list :

        iter = head;
        Node dummy = new Node(-1);
        Node copy = dummy;

        while (iter != null) {
            front = iter.next.next;

            //Extract the copy :
            copy.next = iter.next;
            copy = copy.next;

            //Restore the original list :
            iter.next = front;

            iter = front;
        }

        return dummy.next;
    }
}
