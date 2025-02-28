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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
        every null tree is subtree of any non empty tree
        if(subRoot == null) return true;
        but here subtree is 1 to 1000
        */
        //if main tree empty then other cant be sub tree
        if(root == null) return false;
        //check if tree are identical
        if(isSameTree(root,subRoot)) return true;
        //check lst and rst
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);

    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        //both trees are null, they are samee
        if(p == null && q == null) return true;
        // one is null or value dont match
        if(p == null || q == null || p.val != q.val) return false;
        //check lst and rst
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
