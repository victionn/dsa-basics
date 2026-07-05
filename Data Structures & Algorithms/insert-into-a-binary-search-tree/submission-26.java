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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode head = root;
        TreeNode prev = root;
        while (root != null) {
            System.out.println("e");
            prev = root;
            System.out.println(prev.val);
            if (val > root.val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        }
        else {
            prev.left = new TreeNode(val);
        }
        return head;
    }
}