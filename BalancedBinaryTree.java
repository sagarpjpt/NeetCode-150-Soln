/*
Given a binary tree, determine if it is height-balanced.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
*/ 

class Solution {
    public boolean isBalanced(TreeNode root) {
        // tree is null
        if(root == null) return true;
        
        boolean isAVL[] = new boolean[1];
        isAVL[0] = true;

        int temp = helper(root, isAVL);

        return isAVL[0];
    }

    private int helper(TreeNode root, boolean[] flag){
        // leaf node 
        if(root.left == null && root.right == null)
            return 1;
        
        // internal node
        int lst_h, rst_h;
        lst_h = (root.left != null) ? helper(root.left, flag) : 0;
        rst_h = (root.right != null) ? helper(root.right, flag) : 0;

        int val = lst_h - rst_h;
        if(val < -1 || val > 1)
            flag[0] = false;

        return 1 + Math.max(lst_h, rst_h);
    }
}
