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
    public int kthSmallest(TreeNode root, int k) {

        //list to store in order traversal of bst
        List<Integer> list = new ArrayList<>();

        //func to perfrom inorder trv
        inOrder(root, list);

        //returning kth smallest element from inorder trv of bst
        return list.get(k-1);
    }
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        // LST root RST
        inOrder(root.left, list);   //first go left
        list.add(root.val); //then add value
        inOrder(root.right, list);  //finaly go right
    }
}
