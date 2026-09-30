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
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;

        
    }

    public void reverse(TreeNode node) {
        if(node == null) return;

        swap(node);
        reverse(node.left);
        reverse(node.right);

    }

    public void swap(TreeNode node){
        TreeNode temp = new TreeNode();
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
