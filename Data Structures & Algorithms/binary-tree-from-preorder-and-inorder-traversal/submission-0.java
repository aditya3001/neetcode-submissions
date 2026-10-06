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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length - 1);
        
    }

    public TreeNode build (int[] preorder, int[] inorder, int currentPreOrder, int inStart, int inEnd) {
        if (currentPreOrder >= preorder.length || inStart >inEnd) return null;

        int c = inStart;
        while (inorder[c] != preorder[currentPreOrder]) {
            c++;
        }
        TreeNode current = new TreeNode(preorder[currentPreOrder]);
        current.left = build(preorder, inorder, currentPreOrder+1, inStart, c - 1);
        int rightCurrentPreOrder = currentPreOrder + c - inStart + 1;
        current.right = build(preorder, inorder, rightCurrentPreOrder, c+1, inEnd);
        return current;
    }
}
