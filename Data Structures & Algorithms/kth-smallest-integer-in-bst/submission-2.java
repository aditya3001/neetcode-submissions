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
    int value = 0;
    int currentK = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverseAndCheck(root, k);
        return value;
    }

    public void traverseAndCheck(TreeNode node, int k) {
        if(node == null) return ;

        traverseAndCheck(node.left, k);
        // System.out.println(node.val + " " + currentK);

        currentK+=1;
        if(currentK == k) {
            value = node.val;
        }
        traverseAndCheck(node.right, k);
    }
}
