/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> linkedMap = new HashMap<>();
        Node dumHead = new Node(0);
        Node dum1 = dumHead;
        Node curr = head;
        while (curr != null) {
            dum1.next = new Node(curr.val);
            dum1 = dum1.next;
            linkedMap.put(curr, dum1);
            curr = curr.next;
        }
        curr = head;
        dum1 = dumHead;
        while (curr != null) {
            dum1 = dum1.next;
            dum1.random = linkedMap.get(curr.random);
            curr = curr.next;
        }
        return dumHead.next;

    }
}
