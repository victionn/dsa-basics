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
    public boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p, q);
        return same;
        
    }
    public void helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            same = false;
            return;
        }
        if (p.val != q.val) {
            same = false;
        }
        helper(p.left, q.left);
        helper(p.right, q.right);
    }
}
