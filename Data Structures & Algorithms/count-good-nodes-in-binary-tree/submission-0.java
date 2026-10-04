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
    int result = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return result;
    }

    public void traverse(TreeNode node, int maxInPath) {

        if (node == null) return;
        // System.out.println(maxInPath + " " + node.val);

        if (node.val >= maxInPath) {
            result++;
            maxInPath = node.val;
        }
        traverse(node.left, maxInPath);
        traverse(node.right, maxInPath);
        
    }
}
