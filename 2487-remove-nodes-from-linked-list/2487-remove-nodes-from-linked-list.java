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
        ListNode temp = current;
        
        while (current != null && current.next != null) {
            if(current.val > current.next.val){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }

        return reverse(temp);
    }
}
