/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        //Edge case :
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode current = head;

        //Find the length :
        while (current.next != null) {
            length++;
            current = current.next;
        }

        //Connect last node to head :
        current.next = head;

        //If it is in multiple of k we don't need to anything,
        // Example : if k = 12 .. we only have to rotate 2 times.
        k = k % length;

        //If length = 5 & rotate = 2 .. we only need to point third node to null
        // i..e length - k and make next node head;
        k = length - k;
        //For left rotation skip k = length - k step.

        while (k > 0) {
            current = current.next;
            k--;
        }

        head = current.next;
        current.next = null;

        return head;
    }
}
