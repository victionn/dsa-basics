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
        if (head.next == null) {
            return null;
        }
        int counter = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            counter ++;
        }
        dummy = head;
        dummy = new ListNode(0, head);
        ListNode prev = dummy;
        counter = counter - n;
        while (head != null && counter > 0 ) {
            prev = head;
            head = head.next;
            counter --;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
