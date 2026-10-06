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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        traverseAndCalculate(root);
        return maxSum;
        

        
    }

    public int traverseAndCalculate(TreeNode node) {
        if(node == null) return 0;

        int currentLeftSum = traverseAndCalculate(node.left);
        int currentRightSum = traverseAndCalculate(node.right);

        int currentSum = Math.max(currentLeftSum + node.val, Math.max(currentRightSum + node.val , Math.max(currentLeftSum + currentRightSum + node.val, node.val)));
        maxSum = Math.max(maxSum, currentSum);
        return Math.max(Math.max(currentLeftSum, currentRightSum), 0) + node.val;

    }
}
