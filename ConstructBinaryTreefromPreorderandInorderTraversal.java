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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre_index[] = new int[1];   //stores curr index value in pre[]
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return constrTree(preorder, map, pre_index, 0, inorder.length-1);
    }
    public TreeNode constrTree(int preorder[], HashMap<Integer,Integer> map, int pre_index[], int low, int high){
        if(low <= high){
            //pick current node from pre[]
            int root_val = preorder[pre_index[0]++];
            TreeNode root = new TreeNode(root_val);

            //get index of root in inorder
            int in_index = map.get(root_val);

            // building tree
            root.left = constrTree(preorder, map, pre_index, low, in_index-1);
            root.right = constrTree(preorder, map, pre_index, in_index + 1, high);

            return root;
        }
        else
            return null;
        
    }
}
