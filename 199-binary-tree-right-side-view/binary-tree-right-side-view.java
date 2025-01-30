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
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        backtrack(root,0);

        return result;
    }

    private void backtrack(TreeNode root,int currentDepth){
        if(root==null)
            return;
        if(result.size()==currentDepth)
            result.add(root.val);
        
        backtrack(root.right,currentDepth+1);
        backtrack(root.left,currentDepth+1);
    }
}