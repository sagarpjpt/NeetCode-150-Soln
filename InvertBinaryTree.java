class Solution {
    public TreeNode invertTree(TreeNode root) {
        //tree has no node or has only one node
        if(root == null || (root.left == null && root.right == null) ) 
            return root;
        //tree has more than one node
        TreeNode left = null;
        TreeNode right = null;
        //traverse down the tree till leef node
        left = invertTree(root.left);
        right = invertTree(root.right); 
        //swap the left child of node with right child 
        root.left = right;
        root.right = left;
        return root;
    }
}
