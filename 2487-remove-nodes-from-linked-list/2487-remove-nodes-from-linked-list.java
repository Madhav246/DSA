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

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode current = reverse(head);
        
        ListNode dummy = new ListNode(-1);
        ListNode dummy1 = dummy;
        int maxi = Integer.MIN_VALUE;

        while (current != null) {
            if (current.val >= maxi) {
                maxi = current.val;
                ListNode temp = new ListNode(maxi);
                dummy.next = temp;
                dummy = dummy.next;
            } 
            current = current.next;
        }

        return reverse(dummy1.next);
    }
}
