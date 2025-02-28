/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //only 2 nodes in the tree i.e. base cond or when one of the p or q is descendant of itself
        if((root.left == q && root == p) || (root.left == p && root == q) || (root.right == q && root == p) || (root.right == p && root == q))
            return root;
        //when both are lower than the root
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        //both are higher than the root
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
