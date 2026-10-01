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
    public int maxDepth(TreeNode root) {
        return calcDepth(root, 0);
    }

    public int calcDepth(TreeNode node, int depth) {
        if(node == null) return depth;

        return Math.max(calcDepth(node.left, depth+1), calcDepth(node.right, depth+1));
    }
}
