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
    public int maxPathSum(TreeNode root) {
        
        int max_val[] = new int[1];
        max_val[0] = Integer.MIN_VALUE;
        maxPath(root, max_val);
        return max_val[0];
    }
    public int maxPath(TreeNode node, int max_val[]){
        if(node == null) return 0;
        int left = Math.max(0, maxPath(node.left, max_val));
        int right = Math.max(0, maxPath(node.right, max_val));
        max_val[0] = Math.max(max_val[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
