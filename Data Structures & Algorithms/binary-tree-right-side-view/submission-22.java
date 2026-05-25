/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deck = new ArrayDeque<>();
        List<Integer> li = new ArrayList<>();
        if (root == null) {
            return li;
        }
        deck.addLast(root);
        while (!deck.isEmpty()) {
            int size = deck.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = deck.pollFirst();
                if (i == 0) {
                    li.add(curr.val);
                }
                if (curr.right != null) {
                    deck.addLast(curr.right);
                }
                if (curr.left != null) {
                    deck.addLast(curr.left);
                }
            }
        }
        return li;
    }
}
