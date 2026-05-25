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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int car = 0;
        int val = 0;
        ListNode dummy = new ListNode(0);
        ListNode headDummy = dummy;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + car) % 10;
            car = (l1.val + l2.val + car) / 10;
            headDummy.next = new ListNode(val);
            headDummy = headDummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = (l1.val + car) % 10;
            car = (l1.val + car) / 10;
            headDummy.next = new ListNode(val);
            headDummy = headDummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = (l2.val + car) % 10;
            car = (l2.val + car) / 10;
            headDummy.next = new ListNode(val);
            headDummy = headDummy.next;
            l2 = l2.next;
        }
        if (car != 0) {
            headDummy.next = new ListNode(car);
        }
        return dummy.next;
    }
}
