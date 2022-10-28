/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode entry = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {              //there is a cycle
                while (slowPtr != entry) {         //find the cycle location
                    slowPtr = slowPtr.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        
        return null;
    }
}
