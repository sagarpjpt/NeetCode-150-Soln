/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
*/ 
class Solution {
    
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0); //0 is current height of tree
        return list;
    }

    private void dfs(TreeNode root, int height) {
        if(root == null)
            return;
        
        if(height == list.size())
            list.add(root.val);

        dfs(root.right, height + 1);
        dfs(root.left, height + 1);
    }  
}
