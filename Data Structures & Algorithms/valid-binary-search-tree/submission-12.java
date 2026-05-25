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
    public boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        helper(root.left, Integer.MIN_VALUE, root.val);
        helper(root.right, root.val, Integer.MAX_VALUE);
        return valid;
    }
    public void helper(TreeNode root, int left, int right) {
        if (root == null) {
            return;
        }
        if (root.val <= left || root.val >= right) {
            valid = false;
            return;
        }
        helper(root.left, left, root.val);
        helper(root.right, root.val, right);
    }
}
