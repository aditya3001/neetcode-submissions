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
    int heightDiff = 0;

    public boolean isBalanced(TreeNode root) {

        calcHeight(root, 0);
        return heightDiff <= 1;
        
    }
    public int calcHeight(TreeNode node, int height) {
        if (node == null) return height;

        int leftHeight = calcHeight(node.left, height+1);
        int rightHeight = calcHeight(node.right, height+1);

        heightDiff = Math.max(heightDiff, Math.abs(leftHeight - rightHeight));
        return Math.max(leftHeight, rightHeight);

    }
}
