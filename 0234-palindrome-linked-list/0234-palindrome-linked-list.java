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

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //Find mid :
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        //Reverse right half :
        slowPtr.next = reverseList(slowPtr.next);

        //Move slowPtr to right half :
        slowPtr = slowPtr.next;

        //Check right half & left half equal or not :
        while (slowPtr != null) {
            if (slowPtr.val != head.val) {
                return false;
            }
            slowPtr = slowPtr.next;
            head = head.next;
        }

        return true;
    }
}
