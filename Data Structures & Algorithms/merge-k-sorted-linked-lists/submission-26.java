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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> li = new ArrayList<>();
            for (int i = 0; i < lists.length - 1; i += 2) {
                ListNode merged = mergeTwoLinkedList(lists[i], lists[i + 1]);
                li.add(merged);
            }
            if (lists.length % 2 == 1) {
                li.add(lists[lists.length - 1]);
            }
            lists = li.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    public ListNode mergeTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
            else {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
            dummy = dummy.next;
        }
        return newHead.next;

    }
    
}
