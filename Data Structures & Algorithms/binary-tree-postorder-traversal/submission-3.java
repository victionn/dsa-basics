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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postList = new ArrayList<>();
        postOrder(postList, root);
        return postList;
        
    }

    public void postOrder(List<Integer> postList, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(postList, root.left);
        postOrder(postList, root.right);
        postList.add(root.val);
        
    }
}