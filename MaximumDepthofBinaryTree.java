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
    public int maxDepth(TreeNode root) {
        //base condn(boundary value)
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        //traversing to the leaf
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return lh>rh ? 1 + lh : 1 + rh;
    }
}
