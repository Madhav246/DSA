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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);

        ListNode current = head;
        ListNode previous = dummy;

        while (current != null && current.next != null) {
            previous.next = current.next;
            current.next = previous.next.next;
            previous.next.next = current;

            previous = current;
            current = current.next;
        }

        return dummy.next;
    }
}
