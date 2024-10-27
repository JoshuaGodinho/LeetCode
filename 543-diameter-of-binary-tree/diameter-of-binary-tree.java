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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    // Helper function to calculate the depth of each node
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the depth of the left and right subtrees
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // The diameter through this node is the sum of the depths of its left and right subtrees
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the depth of this node, which is max depth of its children + 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
