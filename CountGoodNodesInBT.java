/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.
Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
*/ 
class Solution {
    List<Integer> list = new ArrayList<>();
    int[] ans = new int[1];
    public int goodNodes(TreeNode root) {
        // list.add(root.val);
        helper(root);
        return ans[0];
    }

    private void helper(TreeNode root){ 
        if(root == null) return;

        if(list.size() == 0){
            list.add(root.val);
            ans[0]++;
        }

        else{
            int curr = root.val;
        
            if(curr >= Collections.max(list) )
                ans[0]++;
            
            list.add(curr);
        }

        helper(root.left);
        helper(root.right);
        
        if(list.size() > 1)
            list.remove(list.size() - 1);
    }
}
