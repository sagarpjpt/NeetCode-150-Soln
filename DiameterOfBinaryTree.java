/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:
Input: root = [1,2]
Output: 1
*/ 
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
    public int diameterOfBinaryTree(TreeNode root) {
        int max_diameter[] = new int[1];

        int max_height_of_tree = helper(root, max_diameter);

        return max_diameter[0];
    }

    private int helper(TreeNode root, int[] md){
        // when node is leaf
        if(root.left == null && root.right == null)
            return 1;
        
        // for internal node
        int left_hght, right_hght;
        left_hght = (root.left != null) ? helper(root.left, md) : 0;
        right_hght = (root.right != null) ? helper(root.right, md) : 0;
    
        md[0] = Math.max(md[0], left_hght + right_hght);
        return 1 + Math.max(left_hght, right_hght);
    }
}
