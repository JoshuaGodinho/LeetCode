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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root){
        if(root==null)
            return 0;

        int leftSum=Math.max(0,maxPathSumHelper(root.left));
        int rightSum=Math.max(0,maxPathSumHelper(root.right));

        maxSum=Math.max(maxSum, leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum)+root.val;
    }
}