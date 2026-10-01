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

    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverseDepth(root);
        return maxDia;
    }

    public int traverseDepth(TreeNode node) {
        if(node == null) return -1;

        int leftDepth = traverseDepth(node.left) + 1;
        int rightDepth = traverseDepth(node.right) + 1;

        maxDia = Math.max(maxDia, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);


    }
}
