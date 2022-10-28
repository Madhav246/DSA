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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode start = new ListNode(-1);
        ListNode mainPtr = start;
        ListNode refPtr = start;
        start.next = head;
        int count = 0;

        while (count < n + 1) {
            if (refPtr == null) {
                return null;
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        mainPtr.next = mainPtr.next.next;

        return start.next;
    }
}
